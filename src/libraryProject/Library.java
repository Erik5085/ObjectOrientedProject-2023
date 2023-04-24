package libraryProject;

public class Library {
    public Book []books;
    public int amount;
    public String name;
    public Library(String name,int length)
    {
        this.name=name;
        books=new Book[length];
    }
    public Library(String name, Book books[])
    {
        this.name=name;
        this.books=books;
        amount=books.length;
    }
    public void list_books()
    {
        System.out.println("Indexn\tName\tAuthor\tGenre");
        for(int i=0;i<amount;i++)
        {
            System.out.printf("%d\t%s\t%s\t%d\t%s\n",i,books[i].name,books[i].author,books[i].serialNumber,books[i].genre);
        }
    }
    public int add_book(Book book_inp)
	{
        books[amount]=book_inp;
        amount++;
        System.out.println("You have successfully added a book");
        return 1;
	}
    public Book remove_book(int index)
    {
        Book tmp=books[index];
        for(int i = index;i<amount-1;i++)
        {
            books[i]=books[i+1];
        }
        return tmp;
    }
}
