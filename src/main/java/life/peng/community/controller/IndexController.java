package life.peng.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller//将当前的类作为路由API的承载者
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
