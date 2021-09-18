package cn.melonkid.daily.repository;


import cn.melonkid.daily.dto.ContentCheckRet;

public interface BaiduApiRepository {

    ContentCheckRet checkContent(String content);
}
