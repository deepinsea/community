package life.peng.community.mapper;

import life.peng.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {//将获取到用户信息存入数据库并且写入session
    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);//如果是类就需要变成方法体（;变成{}）

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);
}
