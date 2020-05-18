package life.peng.community.dto;

import life.peng.community.model.User;
import lombok.Data;

/**
 * @author 南街北巷
 * @data 2020/5/18 2:37
 */
@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private long gmtCreate;
    private long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
