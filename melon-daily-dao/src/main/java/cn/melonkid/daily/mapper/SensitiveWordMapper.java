package cn.melonkid.daily.mapper;

import cn.melonkid.daily.domain.SensitiveWordDomain;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SensitiveWordMapper {

    boolean insert(SensitiveWordDomain sensitiveWordDomain);

    SensitiveWordDomain findByWord(String word);
}
