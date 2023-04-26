 

/**
 * Book class stores basic values for books to be called by Library and Member classes
 * @author Erik Vaughn, Thomas Truong
 *
 */
public class Book{
	private String name;			//book name
    private String author;		//book author
    private int serialNumber;	//book serial number/id number
    private String genre;		//book genre
    private int restriction;		//restriction level of book (0-normal member, 1-librarian)
    
    /*
     * Book constructor for empty vals
     */
    public Book()
    {
        this.name="";
        this.author="";
        this.serialNumber=0;
        this.genre="";
        this.restriction=0;
    }
    
    /*
     * Book constructor for all params + restriction lvl
     */
    public Book(String name,String author,int serialNumber,String genre,int restriction)
    {
        this.name=name;
        this.author=author;
        this.serialNumber=serialNumber;
        this.genre=genre;
        this.restriction=restriction;
    }
    
    /*
     * Book constructor for all params without restriction lvl
     */
    public Book(String name,String author,int serialNumber,String genre)
    {
        this.name=name;
        this.author=author;
        this.serialNumber=serialNumber;
        this.genre=genre;
        this.restriction=0;
    }
    
    /*
     * Getter methods for variables
     */
    public String getName() {
    	return name;
    }    
    public String getAuthor() {
    	return author;
    }    
    public int getSerial() {
    	return serialNumber;
    }
    public String getGenre() {
    	return genre;
    }
    public int getRestriction() {
    	return restriction;
    }
    
    /*
     * Setter methods for variables
     */
    public void setName(String name) {
    	this.name = name;
    }    
    public void setAuthor(String author) {
    	this.author = author;
    }    
    public void setSerial(int serialNumber) {
    	this.serialNumber = serialNumber;
    }
    public void setGenre(String genre) {
    	this.genre = genre;
    }
    public void setRestriction(int restriction) {
    	this.restriction = restriction;
    }
}
