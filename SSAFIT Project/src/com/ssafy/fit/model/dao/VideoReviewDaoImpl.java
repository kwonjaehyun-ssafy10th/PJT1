package com.ssafy.fit.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.fit.model.VideoReview;

public class VideoReviewDaoImpl implements VideoReviewDao {

	private static int reviewNo;
	private Map<Integer, List<VideoReview>> VideoReviewDb;
	private static VideoReviewDaoImpl instance;
	
	private VideoReviewDaoImpl() {
		
	}
	
	public VideoReviewDaoImpl getInstance() {
		
		return instance;
	}
	
	@Override
	public boolean insertReview(VideoReview videoReview) {

		VideoReviewDb()
		
		return false;
	}

	@Override
	public List<VideoReview> selectReview(int videoNo) {
		
		
		
		return null;
	}

}
