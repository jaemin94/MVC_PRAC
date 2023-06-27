package Tests.ControllerTests;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import ClassDiagram.C01App.Controller.FrontController;

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

}
