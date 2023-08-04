package com.ssafy.fit.ui;

import com.ssafy.fit.model.Video;
import com.ssafy.fit.model.dao.VideoDao;
import com.ssafy.fit.model.dao.VideoDaoImpl;
import com.ssafy.fit.util.SsafitUtil;

public class VideoUi {
	private VideoDao videoDao = VideoDaoImpl.getInstance();
	static private VideoUi instance = new VideoUi();

	private VideoUi() {
	}

	public static VideoUi getInstance() {
		return instance;
	}

	public void service() {
		SsafitUtil.printLine();
		System.out.println("1.  영 상 목 록");
		System.out.println("0.  이 전 으 로");
		SsafitUtil.printLine();
		while (true) {
			switch (SsafitUtil.inputInt("메 뉴 를   선 택 하 세 요   :")) {
			case 1:
				listVideo();
				break;
			case 0:
				MainUi.getMu().service();
			}
		}

	}

	void listVideo() {
		SsafitUtil.printLine();
		System.out.printf("전 체   %d개\n", VideoDaoImpl.getInstance().selectVideo().size());
		SsafitUtil.printLine();
		int i = 1;
		for (Video video : VideoDaoImpl.getInstance().selectVideo()) {
			System.out.printf("%d   %s   %s\n", i++, video.getPart(), video.getTitle());
		}
		SsafitUtil.printLine();
		System.out.println("1.  영 상 상 세");
		System.out.println("0.  이 전 으 로");
		SsafitUtil.printLine();
		while (true) {
			switch (SsafitUtil.inputInt("메 뉴 를   선 택 하 세 요   :")) {
			case 1:
				detailVideo();
				break;
			case 0:
				service();
			}
		}
	}

	private void detailVideo() {
		int inputNo;
		while (true) {
			inputNo = SsafitUtil.inputInt("영 상 번 호 를   입 력 하 세 요   :");
			if (inputNo < 1 || inputNo > VideoDaoImpl.getInstance().selectVideo().size()) {
				continue;
			}			
			Video curVideo = VideoDaoImpl.getInstance().selectVideo().get(inputNo - 1);
			SsafitUtil.printLine();
			System.out.printf("번 호   : %d\n", curVideo.getNo());
			System.out.printf("제 목   : %s\n", curVideo.getTitle());
			System.out.printf("운 동   : %s\n", curVideo.getPart());
			System.out.printf("영 상 URL   : %s\n", curVideo.getUrl());
			SsafitUtil.printLine();
			SsafitUtil.printLine();
			break;
		}
		VideoReviewUi vru = VideoReviewUi.getInstance(inputNo);
		vru.service();
		
		
	}

}
