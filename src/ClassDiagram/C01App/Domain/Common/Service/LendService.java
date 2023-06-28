package ClassDiagram.C01App.Domain.Common.Service;

import ClassDiagram.C01App.Domain.Common.Dao.RentalDao;
import ClassDiagram.C01App.Domain.Common.Dto.BookDto;
import ClassDiagram.C01App.Domain.Common.Dto.MemberDto;
import ClassDiagram.C01App.Domain.Common.Dto.RentalDto;

public class LendService {
	
	private MemberService memService;
	private BookService bookService;
	private RentalDao dao;
	
	private static LendService instance;
	public static LendService getInstance()
	{
		if(instance == null)
			instance =new LendService();
		return instance;
		
	}
	
	private LendService()
	{
		dao = RentalDao.getInstance();
		memService = MemberService.getInstance();
		bookService = BookService.getInstance();
	}
	
	// 외부로부터 Service 받기
	public void setMemberService(MemberService memService)
	{
		this.memService = memService;
	}
	public void setBookrService(BookService bookService)
	{
		this.bookService = bookService;
	}
	
	public boolean reqLend(String sid,String userid, int bookcode) throws Exception
	{
		// 사서 로그인 확인, Role 받기
		String role = memService.getRole(sid);
		if(!role.equals("Role_Member"))
			{
				System.out.println("[WARN] 사서만 로그인 할 수 있습니다.");
				return false;
			}
		// 회원 존재 유무 확인
		MemberDto dto = memService.memberSearchOne(role, userid);
		
		if(dto != null)
		{
			// 도서존재 유무 확인
			BookDto bdto = bookService.getBook(bookcode);
			if(bdto != null)
			{
				// 책이 존재한다면 대여중인 상태인지 확인(RentalDao이용해서 대여중인 책이 있는지 조회)
				RentalDto ldto = dao.select(bookcode);
				if(ldto == null)
				{
					// 대여가능 상태라면 대여진행
					dao.insert(new RentalDto(0,bookcode,userid,null,null));
					System.out.println("[INFO] 도서대여 완료되었습니다.");
					return true;
				}
				System.out.println("[INFO] 요청한 도서는 대여중입니다.");
				return false;
			}
			System.out.println("[INFO] 해당 도서는 존재하지 않습니다.");
			return false;
		}
		System.out.println("[INFO] 해당 회원이 존재하지 않습니다.");
		return false;
	}
	
	
}
