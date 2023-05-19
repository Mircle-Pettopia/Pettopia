package com.yedam.pettopia.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.pettopia.user.UserVO;
import com.yedam.pettopia.user.auth.PrincipalDetails;
import com.yedam.pettopia.user.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService, UserService{
	/*SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
    Date time = new Date();
    String localTime = format.format(time);*/
	
	@Autowired
    private final UserMapper mapper;
	
	@Transactional
	public int joinUser(UserVO vo) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		vo.setPw(passwordEncoder.encode(vo.getPassword()));
		vo.setRole("USER");
		
		int result = mapper.saveUser(vo);
		if(result < 1) {
			result = -1;
		}
		
		return result;
	};
	
	@Override
	public UserDetails loadUserByUsername(String meId) throws UsernameNotFoundException {
		//여기서 받은 유저 패스워드와 비교하여 로그인 인증
		UserVO byUsername = mapper.getUserAccount(meId);
		
        if (byUsername != null){
        	return new PrincipalDetails(byUsername);
        };
        
        return byUsername;
	};

	@Override
	public UserVO getUserAccount(String meId) {
		return mapper.getUserAccount(meId);
	}
	

	//아이디 중복확인
	public int idChk(String meId) {
		return mapper.idChk(meId);
	}
	
	//카카오 회원가입
	@Override
	public int kakaosaveUser(UserVO vo) {
		/*BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		vo.setPw(passwordEncoder.encode(vo.getPassword()));*/
		
		int result = mapper.kakaosaveUser(vo);
		if(result < 1) {
			result = -1;
		};
		
		return result;
	}

	//DB 정보 확인
	@Override
	public UserVO snsIdTokenChk(String meSnsToken) {
		return mapper.snsIdTokenChk(meSnsToken);
	}

	@Override
	public UserVO snsIdToKenInfo(String meSnsToken) {
		return mapper.snsIdToKenInfo(meSnsToken);
	}

	@Override
	public UserVO snsGetNullInfo(String meSnsToken) {
		UserVO result = mapper.snsGetNullInfo(meSnsToken);
		UserVO vo = new UserVO();
		
		if(result == null) {
			vo.setPhone("null");
			vo.setPost("null");
			vo.setAddr("null");
			vo.setAddrDetail("null");
		}
		return vo;
	}

	//정보 수정
	@Override
	public int userInfoUpdate(UserVO vo) {
		int result = 0;
		String pw = "";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		if(vo.getSignPath() != "SC1") {
			result = mapper.userInfoUpdate(vo);
		}
		
		vo.setPw(pw);
		result = mapper.userInfoUpdate(vo);
		
		System.out.println(vo);
		
		if(result < 1) {
			result = -1;
		};
		
		return result;
	}

	//회원탈퇴
	@Override
	public int userDelete(String meId) {
		int result = mapper.userDelete(meId);
		
		return result;
	}

	@Override
	public int userDelNotLogin(String meId, String pw) {
		return mapper.userDelNotLogin(meId, pw);
	}
	
}
