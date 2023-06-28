package ClassDiagram.C01App.Domain.Common.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ClassDiagram.C01App.Domain.Common.Dto.MemberDto;
import ClassDiagram.C01App.Domain.Common.Dto.RentalDto;

public class RentalDao {

	private String id;
	private String pw;
	private String url;

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private  static RentalDao instance;
	public static RentalDao getInstance()
	{
		if(instance == null)
			instance = new RentalDao();
		return instance;
	}
	private RentalDao()
	{
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
	
	public int insert(RentalDto dto)
	{
		int result = 0;
		try
		{
			pstmt = conn.prepareStatement("insert into tbl_lend values(null,?,?,curdate(),DATE_ADD(curdate(),interval 7 day))");
			pstmt.setInt(1, dto.getBookcode());
			pstmt.setString(2, dto.getId());
			
			result = pstmt.executeUpdate();	 
			pstmt.close();
					 
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return result;		
	}
	
	public List<RentalDto> select()
	{
		List<RentalDto> list = new ArrayList();
		RentalDto dto = null;
		
		try
		{
			pstmt = conn.prepareStatement("select * from tbl_lend");
			rs = pstmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					dto = new RentalDto();
					dto.setLendid(rs.getInt("lend_id"));
					dto.setBookcode(rs.getInt("book_code"));
					dto.setId(rs.getString("id"));
					dto.setLenddate(rs.getDate("lend_date"));
					dto.setReturndate(rs.getDate("return_date"));
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
	
	public RentalDto select(int bookcode)
	{
		
		RentalDto dto = null;
		
		try
		{
			pstmt = conn.prepareStatement("select * from tbl_lend where book_code=?");
			pstmt.setInt(1,bookcode);
			rs = pstmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					dto = new RentalDto();
					dto.setLendid(rs.getInt("lend_id"));
					dto.setBookcode(rs.getInt("book_code"));
					dto.setId(rs.getString("id"));
					dto.setLenddate(rs.getDate("lend_date"));
					dto.setReturndate(rs.getDate("return_date"));
					
				}
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
	

	

	public int update(RentalDto dto)
	{
		try
		{
			pstmt = conn.prepareStatement("update tbl_lend set book_code= ?,id=? ,lend_date = ?, return_date = ? where lend_id =?");
			
			pstmt.setInt(1, dto.getBookcode());
			pstmt.setString(2, dto.getId());
			pstmt.setDate(3, (Date) dto.getLenddate());
			pstmt.setDate(4, (Date) dto.getReturndate());
			pstmt.setInt(5, dto.getLendid());
			
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
	
	public int delete(String id)
	{
		try
		{
			pstmt = conn.prepareStatement("delete from tbl_member where id =?");
			pstmt.setString(1, id);
			
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
