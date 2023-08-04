import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.ssafy.fit.model.Video;

public class Test {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("data/video.json")));
		StringBuilder sb = new StringBuilder();
		String str = null;
		
		
		while((str=br.readLine())!=null)
		{
			sb.append(str).append("\n");
		}

		Gson gson = new Gson();
		Video[] arr = gson.fromJson(sb.toString(), Video[].class);
		
		List<Video> list = new ArrayList<>();
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