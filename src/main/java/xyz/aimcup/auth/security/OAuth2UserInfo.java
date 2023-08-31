package xyz.aimcup.auth.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
@Getter
public abstract class OAuth2UserInfo {
    protected Map<String, Object> attributes;

    public abstract Long getOsuId();
    public abstract String getUsername();
    public abstract Boolean isRestricted();
}
