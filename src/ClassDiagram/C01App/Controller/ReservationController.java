package ClassDiagram.C01App.Controller;

import java.util.Map;

import ClassDiagram.C01App.Domain.Common.Dto.BookDto;
import ClassDiagram.C01App.Domain.Common.Dto.ReservationDto;

public class ReservationController {

	// 1 Select , 2 Insert , 3 Update , 4 Delete
	public Map<String, Object> execute(int serviceNo, Map<String,Object> param) 
	{	
		if(serviceNo == 1)
		{
			// 1. 파라미터 추출(생략)
			// 2. 입력값 검증(생략)
			// 3. 서비스 실행(서비스 모듈작업 이후 처리)
			// 4. View로 전달
				System.out.println("Reservation_Select Block!");
		}
		else if(serviceNo == 2)
		{
			// 1. 파라미터 추출
				Integer rid = (Integer)param.get("rid");
				Integer lendid = (Integer)param.get("lendid");
				String id = (String)param.get("id");
				Integer isresvmessage = (Integer)param.get("isresvmessage");
			// 2. (데이터)입력값 검증
				if(rid == null || lendid == null || id == null || isresvmessage == null)
				{
					System.out.println("[ERROR] Data Validation Check Error!");
					return null; // 함수종료
				}
			// 3. 서비스 실행
				ReservationDto dto = new ReservationDto(rid,lendid,id,null,isresvmessage);
				System.out.println("Dto : " + dto);
			// 4. View로 전달
				System.out.println("Reservation_Insert Block!");
		}
		else if(serviceNo == 3)
		{
			// 1. 파라미터 추출
			Integer rid = (Integer)param.get("rid");
			Integer lendid = (Integer)param.get("lendid");
			String id = (String)param.get("id");
			Integer isresvmessage = (Integer)param.get("isresvmessage");
		// 2. (데이터)입력값 검증
			if(rid == null || lendid == null || id == null || isresvmessage == null)
			{
				System.out.println("[ERROR] Data Validation Check Error!");
				return null; // 함수종료
			}
		// 3. 서비스 실행
			ReservationDto dto = new ReservationDto(rid,lendid,id,null,isresvmessage);
			System.out.println("Dto : " + dto);
			// 4. View로 전달
			System.out.println("Reservation_Update Block!");
		}
		else if(serviceNo == 4)
		{
			// 1. 파라미터 추출
			Integer bookcode = (Integer)param.get("book_code");
			// 2. 입력값 검증
			if(bookcode == null)
			{
				System.out.println("[ERROR] Data Validation Check Error!");
				return null; // 함수종료
			}
			// 3. 서비스 실행
			// 4. View로 전달
			System.out.println("Reservation_Delete Block!");
		}
		return null;
	}
	
}
