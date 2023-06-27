package ClassDiagram.C01App.Controller;

import java.util.HashMap;
import java.util.Map;

public class FrontController {

	private Map<String, Object> map = new HashMap(); 	
	
	// 초기값 설정
	// 사용자요구사항API Controller에 맞게 저장
	// /req_bookinfo에 요구사항은 BookController 전달
	
	private void init()
	{
		// RequestUri ServiceNo Param
		
		// 도서 정보 요구사항 - Controller Mapping
		map.put("/book", new BookController());

		
		// 회원 정보 요구사항 - Controller Mapping
		map.put("/member", new MemberController());

		
		// 대여 정보 요구사항 - Controller Mapping
		map.put("/lend", new LendController());

		
		// 예약 정보 요구사항 - Controller Mapping
		map.put("/reserve", new ReservationController());

		
	}
	
	public FrontController()
	{
		init();
	}
	
	// request 맞는 controller를 추출, 해당컨트롤러 실행
	// request, ServiceNo(1 select, 2 insert, 3 update, 4 delete), param
	
	public void execute(String request, int ServiceNo, Map<String,Object> param)
	{
		Object controller = map.get(request);
		
		if(controller instanceof BookController)
		{
			BookController down = (BookController) controller;
			down.execute(ServiceNo,param);
			System.out.println("BookController !");
		}
		else if(controller instanceof MemberController)
		{
			MemberController down = (MemberController) controller;
			down.execute(ServiceNo,param);
			System.out.println("MemberController !");
		}
		else if(controller instanceof LendController)
		{
			LendController down = (LendController) controller;
			down.execute(ServiceNo,param);
			System.out.println("LendController !");
		}
		else if(controller instanceof ReservationController)
		{
			ReservationController down = (ReservationController) controller;
			down.execute(ServiceNo,param);
			System.out.println("ReservationController !");
		}
		else
		{
			System.out.println("Request ERROR");
		}
		
		
	}
	
}
