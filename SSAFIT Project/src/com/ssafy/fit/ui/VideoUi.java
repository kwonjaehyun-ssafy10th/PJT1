package com.ssafy.fit.ui;

import com.ssafy.fit.model.dao.VideoDao;
import com.ssafy.fit.model.dao.VideoDaoImpl;

public class VideoUi {
	private VideoDao videoDao = VideoDaoImpl.getInstance();
	static private VideoUi instance = new VideoUi();
	
	private VideoUi() {}
	
	public static VideoUi getInstance() {
		return instance;
	}
	
	public void service() {
		
	}
	
	private void listVideo() {}
	
	private void detailVideo() {}
	
	
	
}
