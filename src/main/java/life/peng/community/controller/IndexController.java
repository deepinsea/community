package life.peng.community.controller;

import life.peng.community.dto.QuestionDTO;
import life.peng.community.mapper.QuestionMapper;
import life.peng.community.mapper.UserMapper;
import life.peng.community.model.Question;
import life.peng.community.model.User;
import life.peng.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
   public String index(HttpServletRequest request,
                       Model model)
    {
        Cookie[] cookies = request.getCookies();
        if (cookies!=null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    //现在的Key为token的value
                    User user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        Calendar cal = Calendar.getInstance();
//        model.addAttribute("time",dateFormat.format(cal.getTime()));
        // 日期格式化

        List<QuestionDTO> questionList=questionService.list();
        model.addAttribute("questions",questionList);

        return "index";
    }
}
