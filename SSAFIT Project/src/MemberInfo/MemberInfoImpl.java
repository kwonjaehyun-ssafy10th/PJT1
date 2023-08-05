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
	public Member loginMem = new Member("none", "none");

	private MemberInfoImpl() {
		// JSON에서 memList에 회원정보 등록
		try {
			loadData();
		} catch (Exception e) {
		}
	}

	public static MemberInfoImpl getInstance() {
		return instance;
	}

	
	public ArrayList<Member> getMemList() {
		
		try {
			loadData();
		} catch (Exception e) {
		}
		
		return (ArrayList<Member>) memList;
	}
	
	//로그인 메서드
	public boolean login(String id, String pw) {
		
		for(Member m : memList) {
			if(m.getId().equals(id) && m.getPassword().equals(pw)) {
				loginMem = m;
				return true;
			}
		}
		return false;

	}

	
	public void regist(Member member) {
		
		int  cnt = 0;
		for(Member m : memList) {
			if(m.getId().equals(member.getId())) {
				System.out.println("사용할 수 없는 아이디입니다.");
				cnt++;
				break;
			}
		}

		if(cnt ==0) {
			memList.add(member);
			try {
				saveData();
			} catch (Exception e) {}
			;
		}

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

			//초기화 후 load해야 기존 아이디 중복이 안됨
			memList = new ArrayList<Member>();
			Member[] arr = gson.fromJson(sb.toString(), Member[].class);
			for (int i = 0; i < arr.length; i++) {
				memList.add(arr[i]);
			}
		} catch (Exception e) {
		}

	}

	private void saveData() {
		try {
			//false값 할당을 통해 기존의 데이터를 덮어씌우는 과정
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data/member.json",false)));
			String str2 = gson.toJson(memList);
			bw.write(str2);
			bw.close();
		} catch (Exception e) {
		}
	}

}