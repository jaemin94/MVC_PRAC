package ClassDiagram.C01App.Domain.Common.Dto;

import java.util.Date;


// @Data
public class RentalDto {

	private int lendid;
	private int bookcode;
	private String id;			// userid
	private Date lenddate;
	private Date returndate;	// 7일이후 반납예정일 계산
	
	public RentalDto()
	{
		
	}
	
	public RentalDto(int lendid , int bookcode, String id, Date lenddate, Date returndate)
	{
		this.lendid = lendid;
		this.bookcode = bookcode;
		this.id = id;
		this.lenddate = lenddate;
		this.returndate = returndate;
	}

	@Override
	public String toString() {
		return "RentalDto [lendid=" + lendid + ", bookcode=" + bookcode + ", id=" + id
				+ ", lenddate=" + lenddate + ", returndate=" + returndate + "]";
	}

	public int getLendid() {
		return lendid;
	}

	public void setLendid(int lendid) {
		this.lendid = lendid;
	}

	public int getBookcode() {
		return bookcode;
	}

	public void setBookcode(int bookcode) {
		this.bookcode = bookcode;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getLenddate() {
		return lenddate;
	}

	public void setLenddate(Date lenddate) {
		this.lenddate = lenddate;
	}

	public Date getReturndate() {
		return returndate;
	}

	public void setReturndate(Date returndate) {
		this.returndate = returndate;
	}
	
	

}
