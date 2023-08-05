package com.ssafy.fit.ui;

import com.ssafy.fit.model.Video;
import com.ssafy.fit.model.dao.VideoDao;
import com.ssafy.fit.model.dao.VideoDaoImpl;
import com.ssafy.fit.test.SsafitApplication;
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
		
		int serviceNo = 1;

VU_service : while (true) {
			
			switch (serviceNo) {
			
			//서비스의 페이지 나누기 
			// 1- main 2-videolist 3-videoDetail
			case 1:
			{
				SsafitUtil.printLine();
				System.out.println("1.  영 상 목 록");
				System.out.println("0.  이 전 으 로");
				SsafitUtil.printLine();
				int VU_pageint = SsafitUtil.inputInt("메 뉴 를   선 택 하 세 요   :");
				if(VU_pageint== 0 ) {
					//0.이전으로 선택시
					/*VU_service 종료
					-> pageint:1 진입*/
					
					SsafitApplication.pageint = 1;
					break VU_service;
				}else if(VU_pageint == 1) {
					//1.영상목록 
					//listVideo진입 --> break없이 그대로
					serviceNo = 2;
				}else {
					//예외값 입력시 -> case문 종료 => while로 다시 실행 
					break;
				}

			}
			case 2:
				serviceNo = listVideo();
				break;
			case 3:
				detailVideo();
				break VU_service;			
			}
			
}
	}

	private int listVideo() {
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
			
			int VU_pageint = SsafitUtil.inputInt(" 메 뉴 를   선 택 하 세 요   :");
			//1- detail video
			//0-함수 종료 -> 이전 while문 재진입 // case 
			
			if(VU_pageint == 0) {
				//serviceNo =1 videoUI메인 화면
				return 1;
			}else if(VU_pageint == 1) {
				return 3;
			}else {
				//오류값 입력시 윗 while문의 case 값을 변경해서 돌아옴
				return 2;
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

		SsafitApplication.movieint = inputNo;
		SsafitApplication.pageint = 3;

	}

}
