package cn.melonkid.daily;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 工具集合
 *
 * @author imelonkid
 * @date 2021/09/18 22:38
 **/
@Controller
@RequestMapping(value = "/tools")
public class MelonToolsController {

    @RequestMapping("/home")
    public String toolsHome() {
        return "daily-tools";
    }
}
