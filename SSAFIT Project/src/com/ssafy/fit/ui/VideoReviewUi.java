package com.ssafy.fit.ui;

import java.util.List;

import com.ssafy.fit.model.VideoReview;
import com.ssafy.fit.model.dao.VideoDaoImpl;
import com.ssafy.fit.model.dao.VideoReviewDaoImpl;
import com.ssafy.fit.util.SsafitUtil;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class VideoReviewUi {
	
	VideoReviewDaoImpl videoReviewDao = VideoReviewDaoImpl.getInstance();
	VideoUi vu = VideoUi.getInstance();
	
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
		
		

		while (true) {
			System.out.println("1.  리 뷰 등 록");
			System.out.println("0.  이 전 으 로");
			switch (SsafitUtil.inputInt("메 뉴 를   선 택 하 세 요   :")) {
			case 1:
				registReview();
				break;
			case 0:
				vu.listVideo();
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
		nickname = SsafitUtil.input("닉네임을 입력하세요 : ");
		content = SsafitUtil.input("내용을 입력하세요 : ");
		
		
		R.setNickName(nickname);
		R.setContent(content);
		R.setVideoNo(this.videoNo);	
		videoReviewDao.insertReview(R);
		
		
	}

}
