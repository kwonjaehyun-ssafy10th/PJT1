import java.io.IOException;
import java.util.ArrayList;

import com.ssafy.fit.model.dao.VideoDao;
import com.ssafy.fit.model.dao.VideoDaoImpl;

import MemberInfo.Member;
import MemberInfo.MemberInfoImpl;

public class MemberTest {
	public static void main(String[] args) {

		MemberInfoImpl mem = MemberInfoImpl.getInstance();
		Member m1 = new Member("id1", "pw1");
		Member m2 = new Member("id2", "pw2");
		Member m3 = new Member("id3", "pw3");
		
		mem.regist(m1);
		mem.regist(m2);
		mem.regist(m3);
		ArrayList<Member> memL = mem.getMemList();
		System.out.println(memL.toString());
		System.out.println(memL.size());
		
		mem.regist(m1);
		Member m4 = new Member("id4", "pw4");
		mem.regist(m4);
		
		System.out.println(memL.toString());
		System.out.println(memL.size());
		mem.regist(m4);
		
		
		mem.regist(m2);
		mem.regist(m3);
	}
	
}