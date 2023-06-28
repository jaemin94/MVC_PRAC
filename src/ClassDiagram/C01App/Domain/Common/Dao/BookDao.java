package ClassDiagram.C01App.Domain.Common.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ClassDiagram.C01App.Domain.Common.Dto.BookDto;

// 스프링부트를 가면 @NoArgsConstructor 이걸로 생성자를 따로 만들 필요가 없다
public class BookDao {

	private String id;
	private String pw;
	private String url;

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static BookDao instance;
	
	public static BookDao getInstance()
	{
		if(instance == null)
			instance = new BookDao();
		return instance;
	}
	private BookDao() {
		id = "root";
		pw = "1234";
		url = "jdbc:mysql://localhost:3306/bookdb";

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	// CRUD
	public int insert(BookDto dto)
	{
		try
		{
			pstmt = conn.prepareStatement("insert into tbl_book values(?,?,?,?)");
			pstmt.setInt(1, dto.getBookcode());
			pstmt.setString(2, dto.getBookname());
			pstmt.setString(3, dto.getPublisher());
			pstmt.setString(4, dto.getIsbn());
			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
			
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return 0;		
	}
	
	public List<BookDto> select()
	{
		List<BookDto> list = new ArrayList();
		BookDto dto = null;
		
		try
		{
			pstmt = conn.prepareStatement("select * from tbl_book");
			rs = pstmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					dto = new BookDto();
					dto.setBookcode(rs.getInt("book_code"));
					dto.setBookname(rs.getString("book_name"));
					dto.setPublisher(rs.getString("publisher"));
					dto.setIsbn(rs.getString("isbn"));
					list.add(dto);
					
				}
				
			}
			rs.close();
			pstmt.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		return list;
	}
	
	public BookDto select(int bookcode)
	{
		
		BookDto dto = null;
		
		try
		{
			pstmt = conn.prepareStatement("select * from tbl_book where book_code=?");
			pstmt.setInt(1, bookcode);
			rs = pstmt.executeQuery();
			if(rs != null)
			{
				rs.next();				
				dto = new BookDto();
				dto.setBookcode(rs.getInt("book_code"));
				dto.setBookname(rs.getString("book_name"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setIsbn(rs.getString("isbn"));	
				
			}
			rs.close();
			pstmt.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dto;
	}
	
	public List<BookDto> select(String keyword)
	{
		return null;
	}
	
	public List<BookDto> select(String keyfield, String keyword)
	{
		return null;
	}

	public int update(BookDto dto)
	{
		try
		{
			pstmt = conn.prepareStatement("update tbl_book set book_name= ?,publisher=? ,isbn = ?where book_code =?");
			
			pstmt.setString(1, dto.getBookname());
			pstmt.setString(2, dto.getPublisher());
			pstmt.setString(3, dto.getIsbn());
			pstmt.setInt(4, dto.getBookcode());
			
			int result = pstmt.executeUpdate();	 
			pstmt.close();
			return result;	 
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return 0;	
	}
	
	public int delete(int bookcode)
	{
		try
		{
			pstmt = conn.prepareStatement("delete from tbl_book where book_code =?");
			pstmt.setInt(1, bookcode);
			
			int result = pstmt.executeUpdate();	 
			pstmt.close();
			return result;		 
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return 0;	
	}
	
	
}
