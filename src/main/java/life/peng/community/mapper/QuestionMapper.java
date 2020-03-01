package life.peng.community.mapper;

import life.peng.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
//接口声明
@Mapper
public interface QuestionMapper {

    //插入语句一定要正确，否则服务器会报提交异常，则无法跳转
    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator,tag) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);
}
