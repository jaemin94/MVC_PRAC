package ClassDiagram.C01App.Domain.Common.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import ClassDiagram.C01App.Domain.Common.Dao.MemberDao;
import ClassDiagram.C01App.Domain.Common.Dto.MemberDto;
import ClassDiagram.C01App.Domain.Common.Service.Auth.Session;


public class MemberService {

	// 세션정보 저장
	public Map<String,Session> sessionMap;
	
	private MemberDao dao;
	
	private static MemberService instance;
	public static MemberService getInstance()
	{
		if(instance == null)
			instance =new MemberService();
		return instance;
		
	}
	
	private MemberService()
	{
		dao = MemberDao.getInstance();
		sessionMap = new HashMap();
	}
	
	// 회원 가입하기
	public boolean memberJoin(MemberDto dto) throws Exception
	{
		System.out.println("MemberService's memberJoin()");
		int result = dao.insert(dto);
		if(result > 0)
			return true;
		
		return false;
	}
	
	// 회원 조회하기(전체 조회하기)
	public List<MemberDto> memberSearch(String sid) throws Exception
	{
		String role = this.getRole(sid);
		
		if(role.equals("Role_Member"))
		{
			return dao.select();
		}
		return null;
	}
	
	public MemberDto memberSearchOne(String role,String id) throws Exception
	{
		if(role.equals("Role_Member"))
		{
			return dao.select(id);
		}
		return null;
	}
	
	// 회원 조회하기(한 회원)
	public MemberDto memberSearch(String id,String sid) throws Exception
	{
		Session session = sessionMap.get(sid);
		if(session != null && session.getId().equals(id))
		{
			return dao.select(id);
		}
		return null;
	}
	
	// 회원 수정하기
	public boolean memberUpdate(MemberDto dto, String sid) throws Exception
	{
		Session session = sessionMap.get(sid);
		if(session != null && session.getId().equals(dto.getId()))
		{
			int result = dao.update(dto);
			if(result > 0)
			return true;
		}
		return false;
	}
	
	// 회원 삭제하기
	public boolean memberDelete(String id, String sid) throws Exception
	{
		Session session = sessionMap.get(sid);
		if(session != null && session.getId().equals(id))
		{
			int result = dao.delete(id);
			if(result > 0)
			return true;
		}
		return false;
	}
	
	// 로그인
	public Map<String,Object> Login(String id, String pw)
	{
		// 1 ID/PW 체크 -> Dao 전달받은 id 와 일치하는 정보를 가져와서 Pw 일치 확인
		MemberDto dbDto = dao.select(id);
		if(dbDto == null) {
			System.out.println("아이디를 확인해주세요.");
			return null;
		}
		if(!pw.equals(dbDto.getPw()))
		{
			System.out.println("비밀번호를 확인해주세요.");
			return null;
		}
		// 2 사용자에대한 정보(Session)을 MemberService에 저장
		String sid = UUID.randomUUID().toString();
		Session session = new Session(sid,dbDto.getId(),dbDto.getRole());
		// key값, value 값
		sessionMap.put(sid, session);
		
		// 3 세션에 대한정보를 클라이언트가 접근할수 잇도록 하는 세션구별ID(Session Cookie) 전달
		Map<String,Object> result = new HashMap();
		result.put("sid", sid);
		result.put("role", dbDto.getRole());
		return result;
	}
	
	// 로그아웃
	public boolean Logout(String id,String sid)
	{
		//  세션 객체를 생성해서 받아온다
		Session session = sessionMap.get(sid);
		// 세션아이디에 있는 아이디가 일치하는지 확인한다
		if(session.getId().equals(id))
		{
			System.out.println("[ERROR] ID가 일치하지 않습니다.");
			return false;
		}
		sessionMap.remove(sid);
		return true;
	}
	
	// 역활반환메서드
	public String getRole(String sid)
	{
		Session session = sessionMap.get(sid);
		if(session != null )
		{
			return session.getRole();
		}
		
		return null;
	}
}
