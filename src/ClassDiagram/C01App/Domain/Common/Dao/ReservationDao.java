package ClassDiagram.C01App.Domain.Common.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ClassDiagram.C01App.Domain.Common.Dto.ReservationDto;

public class ReservationDao {

	private String id;
	private String pw;
	private String url;

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static ReservationDao instance;
	public static ReservationDao getInstance()
	{
		if(instance == null)
			instance = new ReservationDao();
		return instance;
	}
	
	private ReservationDao()
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
	
	public int insert(ReservationDto dto)
	{
		int result = 0;
		try
		{
			pstmt = conn.prepareStatement("insert into tbl_reserve values(?,?,?,curdate(),?)");
			pstmt.setInt(1, dto.getRid());
			pstmt.setInt(2, dto.getLendid());
			pstmt.setString(3, dto.getId());
			pstmt.setInt(4, dto.getIsResvMessage());
			
			result = pstmt.executeUpdate();	 
			pstmt.close();
					 
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return result;		
	}
	
	public List<ReservationDto> select()
	{
		List<ReservationDto> list = new ArrayList();
		ReservationDto dto = null;
		
		try
		{
			pstmt = conn.prepareStatement("select * from tbl_reserve");
			rs = pstmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					dto = new ReservationDto();
					dto.setRid(rs.getInt("r_id"));
					dto.setLendid(rs.getInt("lend_id"));
					dto.setId(rs.getString("id"));
					dto.setRdate(rs.getDate("r_date"));
					dto.setIsResvMessage(rs.getInt("isresvmessage"));
				
					
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
	

	

	public int update(ReservationDto dto)
	{
		try
		{
			pstmt = conn.prepareStatement("update tbl_reserve set lend_id= ?,id=? ,r_date = ?, isresvmessage = ? where r_id =?");
			
			
			pstmt.setInt(1, dto.getLendid());
			pstmt.setString(2, dto.getId());
			pstmt.setDate(3, (Date) dto.getRdate());
			pstmt.setInt(4, dto.getIsResvMessage());
			pstmt.setInt(5, dto.getRid());
			
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
	
	public int delete(int id)
	{
		try
		{
			pstmt = conn.prepareStatement("delete from tbl_reserve where r_id =?");
			pstmt.setInt(1, id);
			
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
