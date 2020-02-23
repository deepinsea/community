package life.peng.community.controller;

import life.peng.community.dto.AccesTokensDTO;
import life.peng.community.dto.GithubUser;
import life.peng.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//在Tomcat启动时，将这个类作为控制器加载到Spring的Bean工厂
public class AuthorizeController {

    @Autowired//自动将写好的实例化对象加载到IOC容器中
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    //RequestMapping的作用是请求路径的跳转,相当于文件系统,Url唯一
    //RequestBody会将这个方法返回的数据通过IO流写入到浏览器
    //GetMapping组合注解，是@RequestMapping(method = RequestMethod.GET)的缩写
   public String callback(@RequestParam(name = "code") String code,
                          @RequestParam(name = "state") String state)
                          //@RequestParam 获取请求参数的值
    {
        AccesTokensDTO accesTokensDTO=new AccesTokensDTO();
        accesTokensDTO.setClient_id("6ec6304bbb35b05f0194");
        accesTokensDTO.setClient_secret("c4661c64b6e9a79a887ca694d88b45de9ccdba70");
        accesTokensDTO.setCode(code);
        accesTokensDTO.setRedirect_url("http://localhost:8887/callback");
        accesTokensDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accesTokensDTO);
        GithubUser user = githubProvider.getuser(accessToken);
        System.out.println(user.getName());
        return "hello";
    }
}
