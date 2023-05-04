package com.yedam.pettopia.user.auth;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.yedam.pettopia.user.UserVO;
import com.yedam.pettopia.user.service.UserServiceImpl;
import com.yedam.pettopia.user.userinfo.OAuth2UserInfo;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService{
	@Autowired private UserServiceImpl userRepository;
    
	@Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(userRequest);
        
        OAuth2UserInfo oAuth2UserInfo = null;	//추가
        String provider = userRequest.getClientRegistration().getRegistrationId();    
        
        //추가
        if(provider.equals("kakao")){	//추가
            oAuth2UserInfo = new KakaoUserInfo(oAuth2User.getAttributes());
        }
        
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String providerId = oAuth2UserInfo.getProviderId();	//수정
        String username = provider+"_"+providerId;
        
        System.out.println("provider===" + provider);
        System.out.println("providerId===" + providerId);
        System.out.println("username===" + username);

        String uuid = UUID.randomUUID().toString().substring(0, 6);
        String password = bCryptPasswordEncoder.encode("패스워드"+uuid); 

        String email = oAuth2UserInfo.getEmail();
        
        //카카오 계정의 고유한 아이디 토큰을 받아 DB에 정보가 있는지 체크한다.
        UserVO meSesTokenChk = userRepository.snsIdTokenChk(providerId);
        
        System.out.println("meSesTokenChk===" + meSesTokenChk);
        
        UserVO meSnsToken = userRepository.snsIdToKenInfo(providerId);
        
        //DB에 없는 사용자라면 회원가입처리
        if(meSesTokenChk == null){
        	System.out.println("아이디없다");
        	
        	meSnsToken = UserVO.oauth2Register()
	                    .meId(email).pw(password).name(username)
	                    .meSnsToken(providerId).signPath(provider)
	                    .provider(provider).providerId(providerId)
	                    .build();
            
            System.out.println(meSnsToken);
            userRepository.kakaosaveUser(meSnsToken);
        }

        return new PrincipalDetails(meSnsToken, oAuth2UserInfo);
    }
}
