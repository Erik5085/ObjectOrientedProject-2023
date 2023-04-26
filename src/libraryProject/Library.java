package libraryProject;

<<<<<<< HEAD
public class Library {
    public Book []books;
    public int amount;
    public int max;
    public String name;
    public Library(String name,int length)
    {
        this.name=name;
        books=new Book[length];
        amount=0;
        this.max=length;
    }
    public Library(String name, Book books[])
    {
        this.name=name;
        this.books=books;
        amount=0;
        this.max=50;
    }
=======
/**
 * Library class stores Books as arrays and adds/removes books
 * @author Erik Vaughn, Thomas Truong
 *
 */
public class Library {
    public Book []books;	//Book array to contain Book values/params
    public int amount;		//amount of books stored in Library
    public int max;			//maximum amount of books to be stored in Library
    public String name;		//Name of library, mostly for Member name
        
    /*
     * Library constructor for length
     */
    public Library(String name, int length)
    {
        this.name=name;
        books=new Book[length];	//set the book array with length 
        amount=0;				//
        this.max=length;		//set the max library to length
    }
    
    /*
     * Library constructor for Book array
     */
    public Library(String name, Book books[])
    {
        this.name=name;
        this.books=books;	//sets books to given Book array
        amount=0;
        this.max=50;		//sets max library to 50
    }
    
    /*
     * Prints out the list of books
     */
>>>>>>> 1b3ea11 (Added comments and changed formatting)
    public void list_books()
    {
        System.out.println("Index\tName\tAuthor\tGenre");
        for(int i=0;i<amount;i++)
        {
            System.out.printf("%d\t%s\t%s\t%d\t%s\n",i,books[i].name,books[i].author,books[i].serialNumber,books[i].genre);
        }
    }
<<<<<<< HEAD
=======
    
    /*
     * Adds book to Book array
     */
>>>>>>> 1b3ea11 (Added comments and changed formatting)
    public int add_book(Book book_inp)
	{
        if(max<=amount)
        {
            return 0;
        }
        books[amount]=book_inp;
        amount++;
        return 1;
	}
<<<<<<< HEAD
=======
    
    /*
     * Removes book from Book array
     */
>>>>>>> 1b3ea11 (Added comments and changed formatting)
    public Book remove_book(int index)
    {
        Book tmp=books[index];
        for(int i = index;i<(amount-1);i++)
        {
            books[i]=books[i+1];
        }
        amount--;
        return tmp;
    }
}
