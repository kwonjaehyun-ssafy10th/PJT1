package com.ssafy.fit.test;

import com.ssafy.fit.ui.MainUi;
import com.ssafy.fit.ui.VideoReviewUi;
import com.ssafy.fit.ui.VideoUi;

public class SsafitApplication {
	
	public static int pageint = 1;
	public static int movieint = 0;
	
	public static void main(String[] args) {
		MainUi mu = new MainUi();
		mu.service();
		
		
		
		/////여기서부터 수정////
		
		MainUi MU = new MainUi();
		VideoUi VU = VideoUi.getInstance();
		
		
		
		
		while(true) {
			
			switch(pageint) {
			case 1:
				MU.service();
				break;
			case 2:
				VU.service();
				break;
			case 3:
				VideoReviewUi VRU = VideoReviewUi.getInstance(movieint);
				VRU.service();
				break;
			}
		}
		
		
		
		
	}
}
