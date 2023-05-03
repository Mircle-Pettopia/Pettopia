package com.yedam.pettopia.user;

import java.util.Collection;
import java.util.Collections;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserVO implements UserDetails{
	private String meId;
	private String pw;
	private String name;
	private String phone;
	private String post;
	private String addr;
	private String addrDetail;
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:sss")
	private String signDt;
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String updateDt;
	private String signPath;
	private String outYn;
	private String role;
	private Long meSnsToken;
	
	private int idChk;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singletonList(new SimpleGrantedAuthority(this.role));
	}
	
	@Override
	public String getPassword() {
		return this.pw;
	}
	
	@Override
	public String getUsername() {
		return this.meId;
	}
	
	// Vo의 name !
    public String getUserName(){
        return this.name;
    }
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}

	public UserVO orElse(Object object) {
		return null;
	}

	public static Object builder() {
		return null;
	}
}
