package life.peng.community.dto;

import lombok.Data;

@Data
public class AccesTokensDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_url;
    private String state;
}
