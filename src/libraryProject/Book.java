package libraryProject;

public class Book{
	public String name;
    public String author;
    public int serialNumber;
    public String genre;
    public int restriction;
    public Book(String name,String author,int serialNumber,String genre,int restriction)
    {
        this.name=name;
        this.author=author;
        this.serialNumber=serialNumber;
        this.genre=genre;
        this.restriction=restriction;
    }
    public Book(String name,String author,int serialNumber,String genre)
    {
        this.name=name;
        this.author=author;
        this.serialNumber=serialNumber;
        this.genre=genre;
        this.restriction=0;
    }
    public Book()
    {
        this.name="";
        this.author="";
        this.serialNumber=0;
        this.genre="";
        this.restriction=0;
    }
    public int get_restriction()
    {
        return restriction;
    }
}
