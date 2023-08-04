package MemberInfo;

import java.util.ArrayList;
import java.util.List;

public class MemberInfoImpl implements MemberInfo {
	
	private static MemberInfoImpl instance = new MemberInfoImpl();
	private List<Member>memList = new ArrayList<Member>();
	
	private MemberInfoImpl() {
		//JSON에서 memList에 회원정보 등록
		
	}
	
	public MemberInfoImpl getInstance() {		
		return instance;
	}
	
	
	public void regist(Member member) {
		
		memList.add(member);
		
		//JSON에 member등록
		
	}
	

}
