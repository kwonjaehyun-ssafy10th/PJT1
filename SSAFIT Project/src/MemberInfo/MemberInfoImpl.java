package MemberInfo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.ssafy.fit.util.SsafitUtil;

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

	// 로그인 메서드
	public boolean login(String id, String pw) {

		for (Member m : memList) {
			if (m.getId().equals(id) && m.getPassword().equals(pw)) {
				loginMem = m;
				return true;
			}
		}
		return false;

	}

	@Override
	public void regist(Member member) {

		boolean flag = true;
		for (Member m : getMemList()) {
			if (m.getId().equals(member.getId())) {
				System.out.println("사용할 수 없는 아이디입니다.");
				flag = false;
				break;
			}
		}

		if (flag) {
			memList.add(member);
			System.out.println("회원가입 완료!");
			try {
				saveData();
			} catch (Exception e) {
			}
		}

	}

	private void loadData() throws Exception {
		try {
			File file = new File("data/member.json");
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			StringBuilder sb = new StringBuilder();
			String str = null;
			while ((str = br.readLine()) != null) {
				sb.append(str).append("\n");
			}

			// 초기화 후 load해야 기존 아이디 중복이 안됨
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
			// false값 할당을 통해 기존의 데이터를 덮어씌우는 과정
			BufferedWriter bw = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream("data/member.json", false)));
			String str2 = gson.toJson(memList);
			bw.write(str2);
			bw.close();
		} catch (Exception e) {
		}
	}
	
	public void viewMemList() {
		SsafitUtil.printLine();
		System.out.println(String.format("회원 목록: 총 %d개 아이디", memList.size()));
		System.out.println("번호: 아이디");
		int i = 1;
		for(Member m: memList) {
			System.out.println(String.format("%-2d: %s", i++, m.getId()));;
		}
		SsafitUtil.printLine();
	}

}