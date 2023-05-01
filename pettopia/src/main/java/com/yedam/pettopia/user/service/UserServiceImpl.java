package com.yedam.pettopia.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.pettopia.user.UserVO;
import com.yedam.pettopia.user.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService{
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
	public UserVO loadUserByUsername(String meId) throws UsernameNotFoundException {
		//여기서 받은 유저 패스워드와 비교하여 로그인 인증
		UserVO vo = mapper.getUserAccount(meId);
		System.out.println(vo);
		
        if (vo == null){
            throw new UsernameNotFoundException("User not authorized.");
        };
        
		return vo;
	};
	
	//아이디 중복확인
	public int idChk(String meId) {
		return mapper.idChk(meId);
	};
	
}
