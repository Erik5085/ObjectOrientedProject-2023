package libraryProject;
import java.util.*;

import javax.lang.model.util.ElementScanner14;
public class Member extends Library{
	private String user;
	private String pass;
	private int restriction;
	public Book books[]=new Book[5];
	public int amount=0;
	public Member(String user,String pass)
	{
		super(user,5);
		this.user=user;
		this.pass=pass;
		this.restriction=0;
	}
	public Member(String user,String pass,int restriction)
	{
		super(user,5);
		this.user=user;
		this.pass=pass;
		this.restriction=restriction;
	}
	public Member()
	{
		super(" ",5);
		this.user="";
		this.pass="";
		this.restriction=0;
	}
	public String name()
	{
		return user;
	}
	public boolean password_cmp(String pass)
	{
		return this.pass.equals(pass);
	}
	public int permission(){
		return this.restriction;
	}
	public int add_book(Book book_inp)
	{
		if(amount<5)
		{
			books[amount]=book_inp;
			amount++;
			System.out.println("You have successfully added a book");
			return 1;
		}
		System.out.println("You can only rent 5 books at a time");
		return 0;
	}
	public void list_books()
	{
		System.out.println("Index\tName\tAuthor\tGenre");
        for(int i=0;i<amount;i++)
        {
            System.out.printf("%d %s\t%s\t%d\t%s\n",i,books[i].name(),books[i].author,books[i].serialNumber,books[i].genre);
        }
    }
	public Book return_book(int index)
	{
		Book tmp;
		return books[index];
		for(int i=index; i<amount-1;i++)
		{
			book[i]=book[i+1];
		}
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Welcome to the library!");
		boolean bool=true;
		String user;
		String pass;
		int count=0;
		int inp;
		boolean repeat=false;
		boolean logged=false;
		Member reader= new Member();
		Member member_list[]=new Member[50];
		Book books[]={new Book("The Hunger Games","Suzanne Collins",0,"Young adult"),new Book("Harry Potter and the Order of the Phoenix"," J.K. Rowling",1,"Fantasy"),new Book("Pride and Prejudice","Jane Austen",2,"Classics"),new Book("Industrial society and its future","Ted Kazynski",3,"Nonfiction"),new Book("A Game of Thrones","George R. R. Martin",4,"Fantasy")};
		Library lib=new Library("The library",books);
		int book_index;
		Book tmp_book;
		while(bool)
		{
			System.out.println("Press 1 to login, 2 to register, 3 to view members, 4 to rent a book, 5 to return a book,6 to exit");
			try
			{
			inp = kb.nextInt();
			}
			catch (InputMismatchException e)
     	 	{ 
         		System.out.println("Invalid input run the program again");
				inp=0;
     	 	}
			switch (inp) {
			case 1:
				try
				{
					System.out.println("Enter username:");
					user = kb.nextLine();
					System.out.println("Enter pass:");
					pass = kb.nextLine();
				}
				catch (InputMismatchException e)
				{ 
					System.out.println("Invalid input run the program again");
					break;
				}
				for(int i=0;i<=count;i++)
				{
					if(member_list[i].name().equals(user))
					{
						if(member_list[i].password_cmp(pass))
						{

							System.out.println("you have successfully logged in");
						}
						else
						{
							System.out.println("incorrect password");
						}
						break;
					}
				}
				break;
			case 2:
				try
				{
					System.out.println("Enter username:");
					user = kb.nextLine();
					System.out.println("Enter pass:");
					pass = kb.nextLine();
					repeat=false;
					for(int i=0;i<count;i++)
					{
						if(member_list[i].name().equals(user))
						{
							System.out.println("Username already in use");
							repeat=true;
							break;
						}
					}
					if(!repeat)
					{
						reader=new Member(user,pass);
						member_list[count]=reader;
						logged=true;
					}
				}
				catch (InputMismatchException e)
				{ 
					System.out.println("Invalid input run the program again");
					break;
				}
				Member tmp=new Member(user,pass);
				member_list[count]=tmp;
				count++;
				break;
			case 3:
				System.out.println("Users");
				for(int i=0;i<count;i++)
				{
					System.out.println(member_list[i].name());
				}
				break;
			case 4:
				if(logged)
				{
				System.out.println("pick a book to rent out");
				lib.list_books();
				book_index=kb.nextInt();
				tmp_book=lib.remove_book(book_index);
				reader.add_book(tmp_book);
				}
				else
					System.out.println("you have not logged in yet please log in");
				break;
			case 5:
				if(logged)
				{
					System.out.println("Which book do you want to return");
					reader.list_books();
					book_index=kb.nextInt();
					lib.add_book(reader.remove_book(book_index));
				}
				else
					System.out.println("you have not logged in yet please log in");
				break;
			case 6:
				bool=false;
				break;
			default:
				System.out.println("Incorrect input please try again");	
			}
		}
	}
}

