package com.ssafy.fit.ui;

import com.ssafy.fit.util.SsafitUtil;
import com.ssafy.fit.test.*;

public class MainUi {
	
	private static MainUi mu = new MainUi();
	public static MainUi getMu() {
		return mu;
	}
		
	public void service() {
		SsafitUtil.printLine();
		System.out.println("자 바 로   구 현 하 는   SSAFIT");
		SsafitUtil.printLine();
		SsafitUtil.printLine();
		System.out.println("1.  영 상 정 보");
		System.out.println("0.  종 료");
		SsafitUtil.printLine();

go:		while (true) {
			switch (SsafitUtil.inputInt("메 뉴 를   선 택 하 세 요   :")) {
			case 1:	
				SsafitApplication.pageint = 2;
				
//				VideoUi.getInstance().service();
				break go;
			case 0:
				exit();
				break;
			}
		}
	}

	private void exit() {
		System.exit(0);
	}

}
