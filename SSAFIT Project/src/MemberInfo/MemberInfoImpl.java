package MemberInfo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class MemberInfoImpl implements MemberInfo {

	private static Gson gson = new Gson();

	private static MemberInfoImpl instance = new MemberInfoImpl();
	private List<Member> memList = new ArrayList<Member>();

	private MemberInfoImpl() {
		// JSON에서 memList에 회원정보 등록
		try {
			loadData();
		} catch (Exception e) {
		}
	}

	public MemberInfoImpl getInstance() {
		return instance;
	}

	public void regist(Member member) {

		memList.add(member);
		try {
			saveData();
		} catch (Exception e) {}
		;
		// JSON에 member등록

	}

	private void loadData() {
		try {
			File file = new File("data/member.json");
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			StringBuilder sb = new StringBuilder();
			String str = null;
			while ((str = br.readLine()) != null) {
				sb.append(str).append("\n");
			}

			Member[] arr = gson.fromJson(sb.toString(), Member[].class);
			for (int i = 0; i < arr.length; i++) {
				memList.add(arr[i]);
			}
		} catch (Exception e) {
		}

	}

	private void saveData() {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data/member.json")));
			String str2 = gson.toJson(memList);
			bw.write(str2);
			bw.close();
		} catch (Exception e) {
		}
	}

}