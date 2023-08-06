package com.ssafy.fit.ui;

import com.ssafy.fit.test.SsafitApplication;
import com.ssafy.fit.util.SsafitUtil;

public class MainUi {

	private static MainUi mu = new MainUi();

	public static MainUi getMu() {
		return mu;
	}

	public void service() {


go: while (true) {
			SsafitUtil.printLine();
			System.out.println("1.  영 상 정 보");
			System.out.println("2.  로 그 아 웃");
			System.out.println("0.  종 료");
			SsafitUtil.printLine();
			switch (SsafitUtil.inputInt("메 뉴 를   선 택 하 세 요   :")) {
			case 1:
				SsafitApplication.pageInt = 2;
				break go;
			
			case 2:
				SsafitApplication.pageInt = 0;
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
