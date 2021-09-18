package cn.melonkid.daily.service.impl;

import cn.melonkid.commons.lang.parser.JSONUtil;
import cn.melonkid.daily.domain.SensitiveWordDomain;
import cn.melonkid.daily.dto.ContentCheckRet;
import cn.melonkid.daily.mapper.SensitiveWordMapper;
import cn.melonkid.daily.repository.BaiduApiRepository;
import cn.melonkid.daily.service.ContentCensorService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        SensitiveWordDomain wordDomain = new SensitiveWordDomain();
        wordDomain.setId(1);
        String word = UUID.randomUUID().toString().substring(0, 5);
        wordDomain.setWord(word);
        wordDomain.setMsg("这是测试数据:" + word);
        sensitiveWordMapper.insert(wordDomain);
        wordDomain = sensitiveWordMapper.findByWord(word);
        System.out.println(JSONUtil.toJSONString(wordDomain));
        return null;
    }
}
