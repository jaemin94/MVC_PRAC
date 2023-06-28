package Tests.ServiceTests;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import ClassDiagram.C01App.Domain.Common.Dto.BookDto;
import ClassDiagram.C01App.Domain.Common.Service.BookService;
import ClassDiagram.C01App.Domain.Common.Service.LendService;
import ClassDiagram.C01App.Domain.Common.Service.MemberService;
import ClassDiagram.C01App.Domain.Common.Service.Auth.Session;

public class ServiceTests {

	@Test
	public void test1_BookService() throws Exception{
		
		BookService service = new BookService();
		assertNotNull(service);
		
		List<BookDto> list = service.getAllBook();
		list.stream().forEach((dto)->{System.out.println(dto);});
		
//		service.addBook(new BookDto(101,"이것이 리눅스다","B출판사","123456"));
	}

	@Test
	public void test2_MemberService() throws Exception{
		
		MemberService service = new MemberService();
		assertNotNull(service);
		
//		List<MemberDto> list = service.memberSearch();
//		list.stream().forEach((dto)->{System.out.println(dto);});
		
//		service.addBook(new BookDto(101,"이것이 리눅스다","B출판사","123456"));
	}
	
	@Test
	public void test3_MemberService_login() throws Exception{
		
		MemberService service = new MemberService();
//		assertNotNull(service);
		String sid = service.Login("user1", "1234");
		System.out.println("sid: " + sid);
		Session mySession = service.sessionMap.get(sid);
		System.out.println("mySession : " + mySession);
	}
	
	@Test
	public void test4_LendService_ReqLend() throws Exception{
		
		MemberService memberService = new MemberService();
		BookService bookService = new BookService();
		LendService lendService = new LendService();
		assertNotNull(lendService);
		
		lendService.setMemberService(memberService);
		lendService.setBookrService(bookService);
		
		// 로그인
		String login_sid = memberService.Login("member6", "1234");
	
		// 대여요청
		boolean islend = lendService.reqLend(login_sid,"user1",1);
		
	}
}
