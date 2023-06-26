package Tests.DaoTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import ClassDiagram.C01App.Domain.Common.Dao.BookDao;
import ClassDiagram.C01App.Domain.Common.Dao.MemberDao;
import ClassDiagram.C01App.Domain.Common.Dao.RentalDao;
import ClassDiagram.C01App.Domain.Common.Dto.BookDto;
import ClassDiagram.C01App.Domain.Common.Dto.MemberDto;
import ClassDiagram.C01App.Domain.Common.Dto.RentalDto;

public class DaoTests {

	@Test
	public void BookDaoTest1() {
		BookDao dao = new BookDao();
		// 객체연결 여부 확인 TEST 함수
		assertNotNull(dao);

	}

	@Test
	public void BookDaoTest2_insert() {
		BookDao dao = new BookDao();
		// 객체연결 여부 확인 TEST 함수
		assertNotNull(dao);
		int result = dao.insert(new BookDto(1,"JAVA의정석","A출판사","1111"));
		assertEquals(1,result); // 기대값, 실제값
	}
	
	@Test
	public void BookDaoTest3_insert_post100() {
		BookDao dao = new BookDao();
		// 객체연결 여부 확인 TEST 함수
		assertNotNull(dao);
		int result = 0;
		for(int i =0; i<100; i ++)
		{
			result += dao.insert(new BookDto(1+i,"JAVA의정석","A출판사","1111" + i));
		}
		assertEquals(99,result); // 기대값, 실제값
		
	}
	@Test
	public void BookDaoTest4_select() {
		BookDao dao = new BookDao();
		// 객체연결 여부 확인 TEST 함수
		assertNotNull(dao);
		
		List<BookDto> list = dao.select();
		// list 의 내용이 비어있는지 TEST 함수
		assertNotNull(list);
		
		// list에 있는 요소들을 하나씩 객체 안으로 넣어주고 출력하는 형식 LAMBDA
		list.stream().forEach((dto)->{System.out.println(dto);});	
	}
	
	@Test
	public void BookDaoTest5_select_bookcode() {
		BookDao dao = new BookDao();
		// 객체연결 여부 확인 TEST 함수
		assertNotNull(dao);
		
		BookDto dto = dao.select(10);
		// list 의 내용이 비어있는지 TEST 함수
		assertNotNull(dto);
		
		// list에 있는 요소들을 하나씩 객체 안으로 넣어주고 출력하는 형식 LAMBDA
		System.out.println(dto);	
	}
	
	@Test
	public void BookDaoTest6_Update() {
		BookDao dao = new BookDao();
		// 객체연결 여부 확인 TEST 함수
		assertNotNull(dao);
		
		List<BookDto> list = dao.select();
		// list 의 내용이 비어있는지 TEST 함수
		assertNotNull(list);
		
		// list에 있는 요소들을 하나씩 객체 안으로 넣어주고 출력하는 형식 LAMBDA
		list.stream().forEach((dto)->{System.out.println(dto);});	
	}
	
	@Test
	public void BookDaoTest7_delete() {
		BookDao dao = new BookDao();
		// 객체연결 여부 확인 TEST 함수
		assertNotNull(dao);
		
		List<BookDto> list = dao.select();
		// list 의 내용이 비어있는지 TEST 함수
		assertNotNull(list);
		
		// list에 있는 요소들을 하나씩 객체 안으로 넣어주고 출력하는 형식 LAMBDA
		list.stream().forEach((dto)->{System.out.println(dto);});	
	}
	// ----------------------------------------------------------------------------------
	
	@Test
	public void MemberDaoTest1_insert() {
		MemberDao dao = new MemberDao();
		// 객체연결 여부 확인 TEST 함수
		assertNotNull(dao);
		
		int result = dao.insert(new MemberDto("user1","1111","홍길동","Role_User"));
		assertEquals(1,result);
			
	}
	
	
	public void MemberDaoTest2_update() {
		MemberDao dao = new MemberDao();
		// 객체연결 여부 확인 TEST 함수
		assertNotNull(dao);
		
		int result = dao.update(new MemberDto("user1","1234","hongGilDong","Role_Member"));
		assertEquals(1,result);
			
	}
	
	@Test
	public void MemnberDaoTest3_delete() {
		MemberDao dao = new MemberDao();
		// 객체연결 여부 확인 TEST 함수
		assertNotNull(dao);
		
		int result = dao.update(new MemberDto("user1","1234","hongGilDong","Role_Member"));
		assertEquals(1,result);
	}
	
	@Test
	public void MemnberDaoTest4_postMember() {
		MemberDao dao = new MemberDao();
		// 객체연결 여부 확인 TEST 함수
		assertNotNull(dao);
		
		int result = 0;
		for(int i = 0; i<=5 ; i++)
		{
			result += dao.insert(new MemberDto("user" + i, "1234", "username" +i , "Role_User"));
		}
		for(int i = 6; i<=10 ; i++)
		{
			result += dao.insert(new MemberDto("member" + i, "1234", "username" +i , "Role_Member"));
		}
		assertEquals(10,result);
	}
	
	@Test
	public void MemnberDaoTest5_select() {
		MemberDao dao = new MemberDao();
		// 객체연결 여부 확인 TEST 함수
		assertNotNull(dao);
		List<MemberDto> list = dao.select();
		
		list.stream().forEach((dto)->{System.out.println(dto);});
	}
	
	// ----------------------------------------------------------------------------------
	
	@Test
	public void RentalDaoTest1_insert(){
		RentalDao dao = new RentalDao();
		assertNotNull(dao);	//Unit Test Function
		
		int result = dao.insert(new RentalDto(0,1,"user1",null,null));
		assertEquals(1,result);
		
		
		 
	}
	}

