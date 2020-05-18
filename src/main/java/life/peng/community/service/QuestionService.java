package life.peng.community.service;

import life.peng.community.dto.QuestionDTO;
import life.peng.community.mapper.QuestionMapper;
import life.peng.community.mapper.UserMapper;
import life.peng.community.model.Question;
import life.peng.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 南街北巷
 * @data 2020/5/18 2:40
 * 组装UserMapper与QuestionMapper
 */
@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    public List<QuestionDTO> list() {
        List<Question> questions = questionMapper.list();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
//            questionDTO.setId(question.getId()); //比较原始的设置值的方式
            BeanUtils.copyProperties(question, questionDTO);
            //该工具类的作用是将question对象的属性拷贝到QuestionDTO对象上
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
            //将每次创建的回复list添加到questionDTO中去

        }
        return questionDTOList;
        //最后展示到前端页面显示
    }
}
