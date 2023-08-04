package com.ssafy.fit.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.fit.model.Video;

public class VideoDaoImpl implements VideoDao {
	private List<Video> list = new ArrayList<>();
	static private VideoDaoImpl instance = new VideoDaoImpl();
	
	private VideoDaoImpl() {}
	static public VideoDaoImpl getInstance() {
		return instance;
	}
	
	public List<Video> selectVideo() {
		return list;
		
	}
	
	public Video selectVideoByNo(int no) {
		return null;
		
	}
	
}
