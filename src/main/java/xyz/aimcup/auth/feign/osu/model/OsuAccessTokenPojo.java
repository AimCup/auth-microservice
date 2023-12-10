package xyz.aimcup.auth.feign.osu.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OsuAccessTokenPojo {

    private String clientId;

    private String clientSecret;

    private String grantType;

    private String scope;
}
