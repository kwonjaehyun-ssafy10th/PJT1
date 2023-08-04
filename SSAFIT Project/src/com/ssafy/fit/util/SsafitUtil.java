package com.ssafy.fit.util;

import java.util.Scanner;

public class SsafitUtil {
	private static Scanner sc = new Scanner(System.in);
	private SsafitUtil() {}
	
	public static String input(String msg) {
		System.out.print(msg);
		return sc.next();
	}
	
	public static int inputInt(String msg) {
		System.out.print(msg);
		return sc.nextInt();
	}
	
	public static void printLine() {
		System.out.println("------------------------------------------------------");
	}
	
//	public void screenClear() {}
	
	
	
	
	
}
