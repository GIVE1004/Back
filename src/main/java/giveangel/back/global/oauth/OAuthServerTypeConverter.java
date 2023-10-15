package giveangel.back.global.oauth;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

public class OAuthServerTypeConverter implements Converter<String,OAuthServerType> {

	@Override
	public OAuthServerType convert(String source) {
		return OAuthServerType.fromName(source);
	}

}
