package com.spring.start.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Rol implements GrantedAuthority {
	ADMIN, USER;

	@Override
	public String getAuthority() {
		return this.name();
	}
}
