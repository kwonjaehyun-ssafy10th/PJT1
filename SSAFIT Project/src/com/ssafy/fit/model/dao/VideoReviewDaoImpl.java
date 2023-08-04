package com.ssafy.fit.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.fit.model.VideoReview;

public class VideoReviewDaoImpl implements VideoReviewDao {

	private static int reviewNo = 0;
	// MAP - key : video-no / value : review list
	private Map<Integer, List<VideoReview>> VideoReviewDb = new HashMap<Integer, List<VideoReview>>();
	private static VideoReviewDaoImpl instance = new VideoReviewDaoImpl();

	private VideoReviewDaoImpl() {
	}

	public static VideoReviewDaoImpl getInstance() {
		return instance;
	}


	@Override // return 값 : 리뷰 no
	public int insertReview(VideoReview videoReview) {
		
		videoReview.setReviewNo(++reviewNo);
		// 해당하는 리뷰를 모아놓을 List 만들기
		List<VideoReview> addlist = new ArrayList<VideoReview>();
		// 리뷰가 있는지 없는지 먼저 체크
		if (!(VideoReviewDb.containsKey(videoReview.getVideoNo()))) {
			System.out.println("check");
			addlist.add(videoReview);
			// 해당하는 리뷰가 없을 경우 새로운 key로 삽입
			VideoReviewDb.put(videoReview.getVideoNo(), addlist);
		} else {
			addlist = VideoReviewDb.get(videoReview.getVideoNo());
			addlist.add(videoReview);
			VideoReviewDb.replace(videoReview.getVideoNo(), addlist);
		}

		int no = videoReview.getReviewNo();
		return no;

//		VideoReviewDb()
		

	}

	@Override
    public List<VideoReview> selectReview(int videoNo) {
        // 리뷰가 있는지 없는지 먼저 체크
        List<VideoReview> addlist = new ArrayList<VideoReview>();
        
        if ((VideoReviewDb.containsKey(videoNo))) {
            addlist = VideoReviewDb.get(videoNo);
        }

        // 리뷰가 있으므로 get - return : List<>
        return addlist;

    }
	

}
