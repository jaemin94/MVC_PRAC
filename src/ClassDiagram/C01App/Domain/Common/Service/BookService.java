package ClassDiagram.C01App.Domain.Common.Service;

import java.util.List;

import ClassDiagram.C01App.Domain.Common.Dao.BookDao;
import ClassDiagram.C01App.Domain.Common.Dto.BookDto;

public class BookService {
	
	
	private BookDao dao;
	
	
	// 싱글톤
	private static BookService instance;
	public static BookService getInstance()
	{
		if(instance == null)
			instance =new BookService();
		return instance;
		
	}
	private MemberService memberService;
	private BookService()
	{
		dao = BookDao.getInstance();
		memberService = MemberService.getInstance();
	}
	
	
	// 도서 조회하기
	public  List<BookDto> getAllBook() throws Exception
	{
		System.out.println("BookService's getAllBook()");
		return dao.select();
	}
	
	public  BookDto getBook(int bookcode) throws Exception
	{
		System.out.println("BookService's getBook()");
		return dao.select(bookcode);
	}
	
	// 도서 등록하기
	public  boolean addBook(BookDto dto,String sid) throws Exception
	{
		System.out.println("BookService's addBook()");
		
		String role = memberService.getRole(sid);
		
		if(role.equals("Role_Member"))
		{
		int result = dao.insert(dto);
		if(result > 0)
			return true;
		}
		return false;
	}
	// 도서 수정하기
	public  boolean updateBook(BookDto dto,String sid) throws Exception
	{
		System.out.println("BookService's updateBookBook()");
		String role = memberService.getRole(sid);
		
		if(role.equals("Role_Member"))
		{
		int result = dao.update(dto);
		if(result >0)
			return true;
		}
		return false;
	}
	// 도서 삭제하기
	public  boolean removeBook(int bookcode,String sid) throws Exception
	{
		System.out.println("BookService's removeBook()");
		String role = memberService.getRole(sid);
		if(role.equals("Role_Member"))
		{
		int result = dao.delete(bookcode);
		if(result > 0)
			return true;
		}
		return false;
	}
	
}
