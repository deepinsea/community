package life.peng.community.model;

import lombok.Data;

/**
 * @author 南街北巷
 * @date  2020/5/18 1:15
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private long gmtCreate;
    private long gmtModified;
    private String avatarUrl;
}
