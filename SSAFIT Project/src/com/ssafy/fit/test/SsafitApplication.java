package com.ssafy.fit.test;

import com.ssafy.fit.ui.LoginUi;
import com.ssafy.fit.ui.MainUi;
import com.ssafy.fit.ui.VideoReviewUi;
import com.ssafy.fit.ui.VideoUi;
import com.ssafy.fit.util.SsafitUtil;

public class SsafitApplication {

	public static int pageInt = 0;
	public static int videoInt = 0;

	public static void main(String[] args) {

		/////여기서부터 수정////

		MainUi MU = new MainUi();
		VideoUi VU = VideoUi.getInstance();
		LoginUi LU = LoginUi.getLu();
		VideoReviewUi VRU = VideoReviewUi.getInstance(videoInt);

		SsafitUtil.printLine();
		System.out.println("자 바 로   구 현 하 는   SSAFIT");
		SsafitUtil.printLine();


		while(true) {

			switch(pageInt) {
			case 1:
				MU.service();
				break;
			case 2:
				VU.service();
				break;
			case 3:
				VRU.service();
				break;
			case 0:
				LU.service();
				break;
			}
		}




	}
}
