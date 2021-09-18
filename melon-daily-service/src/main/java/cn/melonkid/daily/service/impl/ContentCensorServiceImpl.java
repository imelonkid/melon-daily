package cn.melonkid.daily.service.impl;

import cn.melonkid.commons.lang.parser.JSONUtil;
import cn.melonkid.daily.domain.SensitiveWordDomain;
import cn.melonkid.daily.dto.ContentCheckHit;
import cn.melonkid.daily.dto.ContentCheckRet;
import cn.melonkid.daily.mapper.SensitiveWordMapper;
import cn.melonkid.daily.repository.BaiduApiRepository;
import cn.melonkid.daily.service.ContentCensorService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * ContentCensorService
 *
 * @author imelonkid
 * @date 2021/09/17 12:07
 **/
@Service
public class ContentCensorServiceImpl implements ContentCensorService {

    /**
     * 百度过滤服务
     */
    @Autowired
    private BaiduApiRepository baiduApiRepository;

    /**
     * 敏感词缓存服务
     */
    @Autowired
    private SensitiveWordMapper sensitiveWordMapper;

    /**
     * 开始敏感词匹配
     *
     * @param content 匹配文本
     * @return
     */
    @Override
    public ContentCheckRet checkContent(String content) {
        ContentCheckRet checkRet = baiduApiRepository.checkContent(content);
        if (checkRet.getConclusion().equals("合规") || CollectionUtils.isEmpty(
            checkRet.getContentCheckHits())) {
            return checkRet;
        }

        List<ContentCheckHit> hits = checkRet.getContentCheckHits();
        for (ContentCheckHit hit : hits) {
            List<String> words = hit.getWords();
            if (CollectionUtils.isEmpty(words)) {
                // 这次hit无效
                continue;
            }

            for (String word : words) {
                SensitiveWordDomain qwordDomain = sensitiveWordMapper.findByWord(word);
                if (qwordDomain != null) {
                    continue;
                }

                // 将敏感词保存到数据库
                SensitiveWordDomain wordDomain = new SensitiveWordDomain();
                wordDomain.setConclusion(hit.getConclusion());
                wordDomain.setWord(word);
                wordDomain.setMsg(hit.getMsg());
                sensitiveWordMapper.insert(wordDomain);
            }
        }

        return checkRet;
    }
}
