package xyz.aimcup.auth.security;

import java.util.Map;

public class OsuOAuth2UserInfo extends OAuth2UserInfo {
    public OsuOAuth2UserInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public Long getOsuId() {
        return Long.parseLong(attributes.get("id").toString());
    }

    @Override
    public String getUsername() {
        return attributes.get("username").toString();
    }

    @Override
    public Boolean isRestricted() {
        return Boolean.parseBoolean(attributes.get("is_restricted").toString());
    }
}
