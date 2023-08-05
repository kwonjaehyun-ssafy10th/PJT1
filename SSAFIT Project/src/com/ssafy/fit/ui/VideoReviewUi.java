package com.ssafy.fit.ui;

import java.util.List;

import com.ssafy.fit.model.VideoReview;
import com.ssafy.fit.model.dao.VideoDaoImpl;
import com.ssafy.fit.model.dao.VideoReviewDaoImpl;
import com.ssafy.fit.test.SsafitApplication;
import com.ssafy.fit.util.SsafitUtil;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import MemberInfo.MemberInfoImpl;

public class VideoReviewUi {
	
	VideoReviewDaoImpl videoReviewDao = VideoReviewDaoImpl.getInstance();
	VideoUi vu = VideoUi.getInstance();
	MemberInfoImpl MI = MemberInfoImpl.getInstance();
	
	private static VideoReviewUi instance = new VideoReviewUi(0);
	
	int videoNo;
	

	private VideoReviewUi(int videoNo) {
		this.videoNo = videoNo;
	}
	
	public static VideoReviewUi getInstance(int videoNo) {
		
		instance.videoNo = videoNo;
		
		return instance;
	}

	public void service() {
		
		listReview();
		
		int serviceNo = 1;

VRU_service:while (true) {
			switch (serviceNo) {
			case 1:{
				System.out.println("1.  리 뷰 등 록");
				System.out.println("0.  이 전 으 로");
				int VRU_pageint = SsafitUtil.inputInt("메 뉴 를   선 택 하 세 요   :");
				
				if(VRU_pageint == 1) {
					serviceNo = 2;
				}else if(VRU_pageint == 0) {
					//이전으로 -> VU페이지로 돌아가야함
					SsafitApplication.pageint = 2;
					break VRU_service;
					
				}else {
					serviceNo = 1;
					break;
				}
			}
			case 2:{
				registReview();
				serviceNo = 1;
				break;
			}			
			}
		}
		
	}
	
	private void listReview() {
		List<VideoReview> list = videoReviewDao.selectReview(videoNo);
		System.out.printf("영 상 리 뷰   : %d개\n", list.size());
		SsafitUtil.printLine();
		for(int i = 0; i < list.size(); i++) {
			System.out.printf("%d  %s  %s\n", (i + 1), list.get(i).getNickName(), list.get(i).getContent());
		}
		SsafitUtil.printLine();
		
		
	}
	
	private void registReview() {
		
		String nickname = null;
		String content = null;
		
		VideoReview R = new VideoReview();
		if(MI.loginMem.getId().equals("none")) {
			nickname = SsafitUtil.input("닉네임을 입력하세요 : ");
		}
		else {
			nickname = MI.loginMem.getId();
			System.out.println("아이디 : " + nickname);
		}
	content = SsafitUtil.input("내용을 입력하세요 : ");
		
		
		R.setNickName(nickname);
		R.setContent(content);
		R.setVideoNo(this.videoNo);	
		videoReviewDao.insertReview(R);
		
		
	}

}
