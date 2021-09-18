package cn.melonkid.daily;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.melonkid.daily.mapper")
@SpringBootApplication(scanBasePackages="cn.melonkid")
public class MelonDailyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MelonDailyApplication.class, args);
    }

}
