package cn.melonkid.daily.service;


import cn.melonkid.daily.dto.ContentCheckRet;

/**
 * ContentCensor
 *
 * @author imelonkid
 * @date 2021/09/17 12:06
 **/
public interface ContentCensorService {

    /**
     * 敏感词匹配服务
     *
     * @param content 匹配文本
     * @return
     */
    ContentCheckRet checkContent(String content);
}
