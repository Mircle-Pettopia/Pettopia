package com.yedam.pettopia.user;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@SuppressWarnings("serial")
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
	private String meSnsToken;
	
	private String provider;    // oauth2를 이용할 경우 어떤 플랫폼을 이용하는지
    private String providerId;  // oauth2를 이용할 경우 아이디값
	
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
	
	@Builder(builderClassName = "UserDetailRegister", builderMethodName = "userDetailRegister")
	public UserVO(String name, String pw, String role) {
		this.name = name;
		this.pw = pw;
		this.role = role;
	}
	
	@Builder(builderClassName = "OAuth2Register", builderMethodName = "oauth2Register")
	public UserVO(String meId, String pw, String name, String meSnsToken,
			String signPath, String provider, String providerId) {
		this.meId = meId;
		this.pw = pw;
		this.name = name;
		this.meSnsToken = meSnsToken;
		this.signPath = signPath;
		this.provider = provider;
        this.providerId = providerId;
	}
	
	public UserVO() {}
	
    public void update(String pw, String name) {
        this.pw = pw;
        this.name = name;
    }
    

}
