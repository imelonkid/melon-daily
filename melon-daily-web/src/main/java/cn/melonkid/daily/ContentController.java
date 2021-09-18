package cn.melonkid.daily;

import cn.melonkid.daily.dto.ContentCheckRet;
import cn.melonkid.daily.service.ContentCensorService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 内容服务
 *
 * @author imelonkid
 * @date 2021/09/17 12:14
 **/
@Controller
@RequestMapping(value = "/content")
public class ContentController {

    @Autowired
    private ContentCensorService contentCensorService;

    @RequestMapping("/censor/home")
    public String checkText() {
        return "ccensor";
    }

    /**
     * @param request HttpServletResponse
     */
    @RequestMapping(value = "/censor.do", produces = "application/json;charset=UTF-8")
    public @ResponseBody
    ContentCheckRet doCheckContent(HttpServletRequest request,
        @RequestParam(value = "content") String content) {
        ContentCheckRet checkRet = contentCensorService.checkContent(content);
        return checkRet;
    }

}
