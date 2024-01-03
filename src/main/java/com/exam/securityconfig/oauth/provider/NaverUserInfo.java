package com.exam.securityconfig.oauth.provider;

import java.util.Map;

public class NaverUserInfo implements OAuth2UserInfo{

	private Map<String, Object> attributes;
	
//	{id=fw1m5uu-QnObSQf_0_J7DveE2Q7Q3SsdQGCdUXnEtJQ, email=sjjjang0205@yahoo.co.kr, name=최선준}
    public NaverUserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
	
    @Override
    public String getProviderId() {
        return (String) attributes.get("id");
    }

    @Override
    public String getName() {
        return (String) attributes.get("name");
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }

	@Override
	public String getProvider() {
		return "naver";
	}

}
