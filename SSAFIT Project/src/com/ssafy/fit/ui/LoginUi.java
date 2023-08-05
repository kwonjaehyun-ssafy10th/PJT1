package com.ssafy.fit.ui;

import com.ssafy.fit.test.SsafitApplication;
import com.ssafy.fit.util.SsafitUtil;

import MemberInfo.Member;
import MemberInfo.MemberInfoImpl;

public class LoginUi {
	
	private static LoginUi lu = new  LoginUi();
	
	public static LoginUi getLu() {
		return lu;
	}
	
	public void service() {
		MemberInfoImpl MI = MemberInfoImpl.getInstance();
LU_service: while(true) {
	
	SsafitUtil.printLine();
	SsafitUtil.printLine();
	System.out.println("1. 로그인");
	System.out.println("2. 회원가입");
	System.out.println("0. 종료");
	SsafitUtil.printLine();
	switch (SsafitUtil.inputInt("메 뉴 를   선 택 하 세 요   :")) {
	
	//1. 로그인
	case 1: {
		SsafitUtil.printLine();
		SsafitUtil.printLine();
		String input_id = SsafitUtil.input("아이디를 입력하세요 : ");
		String input_pw = SsafitUtil.input("비밀번호를 입력하세요 : ");
		
		
		if(MI.login(input_id, input_pw)) {
			SsafitUtil.printLine();
			System.out.println( MI.loginMem.getId()+"님 환영합니다.");
			SsafitUtil.printLine();
			SsafitApplication.pageint = 1;
			
			break LU_service;
		}
		else {
			SsafitUtil.printLine();
			System.out.println("아이디 혹은 비밀번호가 잘못되었습니다.");
			break;
		}
	}
	//2. 회원가입
	case 2: {
		SsafitUtil.printLine();
		SsafitUtil.printLine();
		System.out.println("회원가입 화면입니다.");
		SsafitUtil.printLine();
		String input_id = SsafitUtil.input("아이디를 입력하세요 : ");
		String input_pw = SsafitUtil.input("비밀번호를 입력하세요 : ");
		Member M = new Member(input_id, input_pw);
		MI.regist(M);
		break;
	}
	case 0:{
		System.exit(0);
	}
}
	
	
}

		
	}

}
