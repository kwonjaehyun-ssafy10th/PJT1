package com.ssafy.fit.model.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.ssafy.fit.model.Video;

public class VideoDaoImpl implements VideoDao {
	private List<Video> list = new ArrayList<>();
	static private VideoDaoImpl instance = new VideoDaoImpl();

	private VideoDaoImpl() {
	}

	static public VideoDaoImpl getInstance() {
		return instance;
	}

	public List<Video> selectVideo() {
		return list;

	}

	public Video selectVideoByNo(int no) {
		for (Video video : list) {
			if (video.getNo() == no) {
				return video;
			}
		}
		System.out.println("검색하신 번호의 동영상은 존재하지 않습니다.");
		return null;
	}
	
	
	public  void test() throws IOException{


		String str = "test";
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("data/video.json")));
		StringBuilder sb = new StringBuilder();
		
		
		while((str=br.readLine())!=null)
		{
			sb.append(str).append("\n");
		}

		Gson gson = new Gson();
		Video[] arr = gson.fromJson(sb.toString(), Video[].class);
		
		for(int i = 0;i<arr.length;i++) {
			list.add(arr[i]);
		}
		
//		System.out.println(list);
		for(Video video:list) {
			System.out.println(video);
		}
		br.close();
	}


}