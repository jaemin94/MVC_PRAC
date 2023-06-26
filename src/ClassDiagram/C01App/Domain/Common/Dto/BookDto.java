package ClassDiagram.C01App.Domain.Common.Dto;

public class BookDto {

	private int bookcode;
	private String bookname;
	private String publisher;
	private String isbn;

	public BookDto(int bookcode, String bookname, String publisher, String isbn) {
		this.bookcode = bookcode;
		this.bookname = bookname;
		this.publisher = publisher;
		this.isbn = isbn;
	}

	public BookDto() 
	{
		
	}

	public String toString() {
		return "BookDto [bookcode=" + bookcode + ", bookname=" + bookname + ", publisher=" + publisher + ", isdn=" + isbn + "]";
	}

	public int getBookcode() {
		return bookcode;
	}

	public void setBookcode(int bookcode) {
		this.bookcode = bookcode;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

}
