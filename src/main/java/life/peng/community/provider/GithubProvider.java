package life.peng.community.provider;

import com.alibaba.fastjson.JSON;
import life.peng.community.dto.AccessTokenDTO;
import life.peng.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

//请求类
@Component
//将当前的类初始化到Spring容器（IOC）的上下文,可无需具体对象实例化
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url(" https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            response.body().string();
//            String token=string.split("&")[0].split("=")[1];
//            return token;
            System.out.println(string);
            return string;
        } catch (IOException e) {
//            e.printStackTrace();
        }
        return "Hello";
    }


    /**捕获用户信息的JSON**/
    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string=response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            //将String类型的JSON（相当于请求中的结构体）对象自动解析为Java类的对象
            return githubUser;
        } catch (IOException e) {
//            e.printStackTrace();
        }
        return null;
    }
}
