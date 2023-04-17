package libraryProject;

public class Book {
	private String title;
	private String author;
	private int serialNumber;
	
	/*
	 * default constructor
	 */
	public Book() {
		title = "";
		author = "";
		serialNumber = 0;
	}
	
	/*
	 * constructor w/ params
	 */
	public Book(String title, String author, int serialNumber) {
		this.title = title;
		this.author = author;
		this.serialNumber = serialNumber;
	}
	
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public int getNum() {
		return serialNumber;
	}
	
	public void setTitle(String newTitle) {
		title = newTitle;
	}
	public void setAuthor(String newAuthor) {
		author = newAuthor;
	}
	public void setNum(int newSerial) {
		serialNumber = newSerial;
	}
}
