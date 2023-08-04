package test;

import java.util.Arrays;

import com.ssafy.fit.model.VideoReview;
import com.ssafy.fit.model.dao.VideoReviewDaoImpl;


public class VideoReviewTest {
	
	public static void main(String[] args) {
		
		
		VideoReview vr1 = new VideoReview();	
		vr1.setContent("r1");
		vr1.setNickName("nick");
		vr1.setReviewNo(1234);
		vr1.setVideoNo(123);
		
		System.out.println(vr1);
		
		VideoReviewDaoImpl ReviewDao = VideoReviewDaoImpl.getInstance();
		ReviewDao.insertReview(vr1);
				
		
	}

}
