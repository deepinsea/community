package life.peng.community.provider;

import com.alibaba.fastjson.JSON;
import life.peng.community.dto.AccesTokensDTO;
import life.peng.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component//将当前类中的对象自动实例化，放到IOC容器池中
public class GithubProvider {
    //第二次握手
    public String getAccessToken(AccesTokensDTO accesTokensDTO){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType,JSON.toJSONString(accesTokensDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String token = string.split("&")[0].split("=")[1];
            return token;
            } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //第三次握手
    public GithubUser getuser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                //此处地址为参数传值的关键,要注意复制过来有没有少https
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            //将string转换为Java的类对象
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
