package Tests.ControllerTests;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import ClassDiagram.C01App.Controller.BookController;
import ClassDiagram.C01App.Controller.FrontController;
import ClassDiagram.C01App.Controller.LendController;
import ClassDiagram.C01App.Controller.MemberController;
import ClassDiagram.C01App.Domain.Common.Dto.BookDto;
import ClassDiagram.C01App.Domain.Common.Dto.MemberDto;

public class ControllerTests {

	@Test
	public void test1_FrontController() 
	{
		FrontController fcontroller = new FrontController();
		assertNotNull(fcontroller);	// NULL 여부 확인
		
		fcontroller.execute("/book",1,null);
		fcontroller.execute("/member",2,null);
		fcontroller.execute("/lend",3,null);
		fcontroller.execute("/reserve",4,null);
		fcontroller.execute("/asdaasdas",1,null);
	}
	
	@Test
	public void test2_FrontController_SubController_Init() 
	{
		FrontController fcontroller = new FrontController();
		assertNotNull(fcontroller);	// NULL 여부 확인
		
//		fcontroller.execute("/book",1,null);
		
		Map<String, Object> param = new HashMap();
		param.put("bookname", "이것이자바다");
		param.put("publisher", "한빛미디어");
//		fcontroller.execute("/book",2,param);
		
		fcontroller.execute("/member",3,null);
		fcontroller.execute("/lend",4,null);
//		fcontroller.execute("/reserve",4,null);
//		fcontroller.execute("/asdaasdas",1,null);
	}
	
	@Test
	public void test3_FrontController_SubController_param() 
	{
		FrontController fcontroller = new FrontController();
		assertNotNull(fcontroller);	// NULL 여부 확인
		
//		fcontroller.execute("/book",1,null);
		
		Map<String, Object> param = new HashMap();
		param.put("bookcode", 1234);
		param.put("bookname", "이것이자바다");
		param.put("publisher", "한빛미디어");
		param.put("isbn", "111-1111");
		fcontroller.execute("/book", 2, param);
	}
	
	@Test
	public void test4_FrontController_SubController_param() 
	{
		FrontController fcontroller = new FrontController();
		assertNotNull(fcontroller);	// NULL 여부 확인
		
//		fcontroller.execute("/book",1,null);
		
		Map<String, Object> param = new HashMap();
		param.put("bookcode", 1234);
		param.put("bookname", "이것이자바다");
		param.put("publisher", "한빛미디어");
		param.put("isbn", "111-1111");
		fcontroller.execute("/book", 2, param);
	}

	@Test
	public void test5_BookControlle() throws Exception
	{
		BookController controller = new BookController();
		assertNotNull(controller);
		
		// 조회
		Map<String,Object> result = controller.execute(1, null);
		List<BookDto> list = (List<BookDto>) result.get("result");
		
		list.stream().forEach((dto) -> {System.out.println(dto);});
		// 삽입
	}
	
	@Test
	public void test6_MemberController() throws Exception
	{
		MemberController controller = new MemberController();
		assertNotNull(controller);
		
		// 로그인
		Map<String,Object> param = new HashMap();
		param.put("id", "user1");
		param.put("pw", "1234");
		
		// SID 발급
		Map<String,Object> result = controller.execute(5,param);
		String sid = (String)result.get("result");
		System.out.println("로그인 성공! Sid : " + sid);
		
		// 전체멤버 조회
		param.put("sid", sid);
		Map<String,Object> result2 = controller.execute(1, param);
		List<MemberDto> list = (List<MemberDto>)result2.get("result");
		list.stream().forEach((dto) -> {System.out.println(dto);});
	}
	
	@Test
	public void test7_LendController() throws Exception
	{
		LendController controller = new LendController();
		assertNotNull(controller);
		
	
	}
}
