package com.ssafy.fit.ui;

import java.util.List;

import com.ssafy.fit.model.VideoReview;
import com.ssafy.fit.model.dao.VideoReviewDaoImpl;

public class VideoReviewUi {
	
	VideoReviewDaoImpl videoReviewDao = VideoReviewDaoImpl.getInstance();
	
	VideoReviewUi instance = new VideoReviewUi(0);
	
	int videoNo;
	

	private VideoReviewUi(int videoNo) {
		this.videoNo = videoNo;
	}
	
	public VideoReviewUi getInstance(int videoNo) {
		
		instance.videoNo = videoNo;
		
		return instance;
	}

	public void Service() {
		
		System.out.println("메뉴를 선택하세요 : ");
		int a;
		
		//input ---- 메소드 
		
		if(a==1) {
			//1.리뷰등록 선택
			registReview();
		}
		else if(a==0) {
			
		}else {
			System.out.println("잘못된 입력입니다.");
		}
		
	}
	
	private void listReview() {
		List<VideoReview> list = videoReviewDao.selectReview(videoNo);
		
		
		
	}
	
	private void registReview() {
		
		String nickname = null;
		String content = null;
		
		VideoReview R = new VideoReview();
		System.out.print("닉네임을 입력하세요 : ");
		
		//input ---  nickname
		
		System.out.print("내용을 입력하세요 : ");
		
		//input --- nickname
		
		R.setNickName(nickname);
		R.setContent(content);
			
		videoReviewDao.insertReview(R);
		
		
	}

}
