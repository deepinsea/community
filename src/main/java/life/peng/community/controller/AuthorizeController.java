package life.peng.community.controller;

import life.peng.community.dto.AccessTokenDTO;
import life.peng.community.dto.GithubUser;
import life.peng.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    //响应类
    @Autowired
    //将写好的实例化的实例加载当前使用的上下文
    private GithubProvider githubProvider;
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClent_id("6ec6304bbb35b05f0194");
        accessTokenDTO.setClent_secret("c4661c64b6e9a79a887ca694d88b45de9ccdba70");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        //分别获得几大参数
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        //马上打印user，验证是否为我们想要的user:如果是，则证明传值成功
        return "index";
    }
}
