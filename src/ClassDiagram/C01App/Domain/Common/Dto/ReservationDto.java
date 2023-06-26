package ClassDiagram.C01App.Domain.Common.Dto;

import java.util.Date;

public class ReservationDto {

	private int rid;
	private int lendid;
	private String id;
	private Date rdate;
	private int isResvMessage;

	public ReservationDto()
	{
		
	}
	
	public ReservationDto(int rid, int lendid, String id, Date rdate, int isResvMessage)
	{
		this.rid = rid;
		this.lendid = lendid;
		this.id = id;
		this.rdate = rdate;
		this.isResvMessage = isResvMessage;
	}

	@Override
	public String toString() {
		return "ReservationDto [rid=" + rid + ", lendid=" + lendid + ", id=" + id + ", rdate=" + rdate
				+ ", isResvMessage=" + isResvMessage + "]";
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getLendid() {
		return lendid;
	}

	public void setLendid(int lendid) {
		this.lendid = lendid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	public int getIsResvMessage() {
		return isResvMessage;
	}

	public void setIsResvMessage(int isResvMessage) {
		this.isResvMessage = isResvMessage;
	}
	
	
	
}
