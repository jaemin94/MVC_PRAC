package ClassDiagram.C01App.Domain.Common.Service;

import java.util.List;

import ClassDiagram.C01App.Domain.Common.Dao.BookDao;
import ClassDiagram.C01App.Domain.Common.Dto.BookDto;

public class BookService {
	
	private BookDao dao;
	
	public BookService()
	{
		dao = new BookDao();
	}
	
	
	// 도서 조회하기
	public  List<BookDto> getAllBook() throws Exception
	{
		System.out.println("BookService's getAllBook()");
		return dao.select();
	}
	// 도서 등록하기
	public  boolean addBook(BookDto dto) throws Exception
	{
		System.out.println("BookService's addBook()");
		int result = dao.insert(dto);
		if(result > 0)
			return true;
		
		return false;
	}
	// 도서 수정하기
	public  boolean updateBook(BookDto dto) throws Exception
	{
		System.out.println("BookService's updateBookBook()");
		int result = dao.update(dto);
		if(result >0)
			return true;
		
		return false;
	}
	// 도서 삭제하기
	public  boolean removeBook(int bookcode)
	{
		System.out.println("BookService's removeBook()");
		int result = dao.delete(bookcode);
		if(result > 0)
			return true;
		
		return false;
	}
	
}
