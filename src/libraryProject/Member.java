package libraryProject;
import java.util.*;

<<<<<<< HEAD
import javax.lang.model.util.ElementScanner14;
public class Member extends Library{
	private String user;
	private String pass;
	private int restriction;
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
=======
/**
 * 
 * @author Erik ___, Thomas Truong
 *
 */
public class Member extends Library{
	private String user;		//username of user
	private String pass;		//password for user
	private int restriction;	//stores user's restriction
	
	////***********CONSTRUCTORS**********////
	/*
	 * Basic constructor for Member
	 */
>>>>>>> 1b3ea11 (Added comments and changed formatting)
	public Member()
	{
		super(" ",5);
		this.user="";
		this.pass="";
		this.restriction=0;
	}
<<<<<<< HEAD
	public String name()
	{
		return user;
	}
	public boolean password_cmp(String pass)
	{
		return this.pass.equals(pass);
	}
=======
	
	/*
	 * Constructor given username and password
	 */
	public Member(String user,String pass)
	{
		super(user,5);
		this.user=user;
		this.pass=pass;
		this.restriction=0;	//restriction set to 0 for all members
	}
	
	/*
	 * Constructor for user, pass, and restriction
	 */
	public Member(String user,String pass,int restriction)
	{
		super(user,5);
		this.user=user;
		this.pass=pass;
		this.restriction=restriction;
	}
	
	/*
	 * Getter methods for variables
	 */
	public String getName()
	{
		return user;
	}
>>>>>>> 1b3ea11 (Added comments and changed formatting)
	public int permission()
	{
		return this.restriction;
	}
<<<<<<< HEAD
	public void change_restriction(int restriction)
	{
		this.restriction=restriction;
=======
	
	/*
	 * Setter method for changing restriction value
	 */
	public void change_restriction(int restriction)
	{
		this.restriction=restriction;
	}
	
	/*
	 * Password checker for correct or not
	 */
	public boolean password_cmp(String pass)
	{
		return this.pass.equals(pass);	//compares given password from parameter with this.pass(known correct pass)
>>>>>>> 1b3ea11 (Added comments and changed formatting)
	}
	public static void main(String[] args) {
<<<<<<< HEAD
		Scanner kb = new Scanner(System.in);
		System.out.println("Welcome to the library!");
		boolean bool=true;
		String user;
		String pass;
		int count=0;
		int inp;
		int restriction;
		boolean repeat=false;
		boolean logged=false;
		Member reader= new Member();
		Member member_list[]=new Member[50];
		Library lib=new Library("The library",50);
=======
		Scanner kb = new Scanner(System.in);	//Scanner variable for inputs
		System.out.println("Welcome to the library!");
		
		boolean bool=true; //bool set to true to keep while loop on
		String user;	//local inputted username
		String pass;	//local inputted password
		int restriction;	//Stores restriction of user
		int count=0;	//counter for For loops
		int inp;		//Value storage for case choice
		
		boolean repeat=false; //Used for register event
		boolean logged=false; //checks if user is logged in
		
		Member reader= new Member();	//Instantiate member object
		Member member_list[]=new Member[50];	//Create array of max 50 members
		Library lib=new Library("The Library", 50);	//initiate Library with max size 50
		
		//Adding books to Book array
>>>>>>> 1b3ea11 (Added comments and changed formatting)
		lib.add_book(new Book("The Hunger Games","Suzanne Collins",0,"Young adult"));
		lib.add_book(new Book("Harry Potter and the Order of the Phoenix"," J.K. Rowling",1,"Fantasy"));
		lib.add_book(new Book("Pride and Prejudice","Jane Austen",2,"Classics"));
		lib.add_book(new Book("Industrial society and its future","Ted Kazynski",3,"Nonfiction"));
		lib.add_book(new Book("A Game of Thrones","George R. R. Martin",4,"Fantasy"));
<<<<<<< HEAD
		int book_index;
		Book tmp_book;
=======
		
		int book_index;	//stores index of chosen book
		Book tmp_book;	//stores temp index of chosen book
>>>>>>> 1b3ea11 (Added comments and changed formatting)
		while(bool)
		{
			System.out.print("Press 1 to login, 2 to register, 3 to view members, 4 to view all books ,5 to rent a book, 6 to return a book,7 to exit");
			if(logged)
			{
<<<<<<< HEAD
				if(reader.restriction==1)
=======
				if(reader.restriction==1)	//check if user is logged in as admin
>>>>>>> 1b3ea11 (Added comments and changed formatting)
					System.out.print(" ,8 to add a book to the library, 9 to remove a book from the library");
			}
			System.out.println();
			try
			{
			inp = kb.nextInt();
			}
			catch (InputMismatchException e)
     	 	{ 
<<<<<<< HEAD
         		System.out.println("Invalid input run the program again");
				inp=6;
     	 	}
			switch (inp) {
			case 1:
=======
         		System.out.println("Invalid input run the program again at start");
				inp=7;	//exits when theres error, figure out how to make repeat while loop
     	 	}
			switch (inp) {
			case 1:		//Login event
>>>>>>> 1b3ea11 (Added comments and changed formatting)
				try
				{
					System.out.println("Enter username:");
					user = kb.next();
					System.out.println("Enter pass:");
					pass = kb.next();
				}
				catch (InputMismatchException e)
				{ 
					System.out.println("Invalid input run the program again");
<<<<<<< HEAD
					inp=6;
=======
					inp=7;
>>>>>>> 1b3ea11 (Added comments and changed formatting)
					break;
				}
				for(int i=0;i<count;i++)
				{
<<<<<<< HEAD
					if(member_list[i].name().equals(user))
=======
					if(member_list[i].getName().equals(user))
>>>>>>> 1b3ea11 (Added comments and changed formatting)
					{
						if(member_list[i].password_cmp(pass))
						{
							logged=true;
							System.out.println("you have successfully logged in");
						}
						else
						{
							System.out.println("incorrect password");
						}
						break;
					}
				}
				if(!logged)
				{
					System.out.println("your username or password was incorrect");
				}
				break;
<<<<<<< HEAD
			case 2:
=======
			case 2:		//Register event
>>>>>>> 1b3ea11 (Added comments and changed formatting)
				try
				{
					System.out.println("Enter username:");
					user = kb.next();
					System.out.println("Enter pass:");
					pass = kb.next();
					System.out.println("Enter a restriction:");
					restriction = kb.nextInt();
<<<<<<< HEAD
					repeat=false;
					for(int i=0;i<count;i++)
					{
						if(member_list[i].name().equals(user))
=======
					//Repeated username checker
					for(int i=0;i<count;i++)
					{
						if(member_list[i].getName().equals(user))
>>>>>>> 1b3ea11 (Added comments and changed formatting)
						{
							System.out.println("Username already in use");
							repeat=true;
							break;
						}
					}
<<<<<<< HEAD
					if(!repeat)
=======
					if(!repeat)	//For all normal cases
>>>>>>> 1b3ea11 (Added comments and changed formatting)
					{
						reader=new Member(user,pass,restriction);
						member_list[count]=reader;
						count++;
					}
				}
				catch (InputMismatchException e)
				{ 
					System.out.println("Invalid input run the program again");
<<<<<<< HEAD
					inp=6;
				}
				break;
			case 3:
				System.out.println("Users");
				for(int i=0;i<count;i++)
				{
					System.out.println(member_list[i].name());
				}
				break;
			case 4:
				lib.list_books();
				break;
			case 5:
=======
					inp=7;
				}
				break;
			case 3:		//View members
				System.out.println("Users");
				for(int i=0;i<count;i++)
				{
					System.out.println(member_list[i].getName());
				}
				break;
			case 4:		//View all books
				lib.list_books();
				break;
			case 5:		//Rent a book
>>>>>>> 1b3ea11 (Added comments and changed formatting)
				if(logged)
				{
					try
					{
						System.out.println("pick a book to rent out");
						lib.list_books();
						book_index=kb.nextInt();
						tmp_book=lib.remove_book(book_index);
						reader.add_book(tmp_book);
						System.out.println("You have successfully added a book");
					}
					catch (InputMismatchException e)
					{ 
						System.out.println("Invalid input run the program again");
<<<<<<< HEAD
						inp=6;
=======
						inp=7;
>>>>>>> 1b3ea11 (Added comments and changed formatting)
						break;
					}
				}
				else
					System.out.println("you have not logged in yet please log in");
				break;
<<<<<<< HEAD
			case 6:
=======
			case 6:		//Return a book
>>>>>>> 1b3ea11 (Added comments and changed formatting)
				if(logged)
				{
					System.out.println("Which book do you want to return");
					reader.list_books();
					try
					{
						book_index=kb.nextInt();
					}
					catch (InputMismatchException e)
					{ 
						System.out.println("Invalid input run the program again");
<<<<<<< HEAD
						inp=6;
=======
						inp=7;
>>>>>>> 1b3ea11 (Added comments and changed formatting)
						break;
					}
					lib.add_book(reader.remove_book(book_index));
					System.out.println("You have successfully returned a book");
				}
				else
					System.out.println("you have not logged in yet please log in");
				break;
<<<<<<< HEAD
			case 7:
				bool=false;
				break;
			case 8:
=======
			case 7:		//Exit
				bool=false;	//changes bool (for loop) to false
				break;
			case 8:		//Add a book to library
>>>>>>> 1b3ea11 (Added comments and changed formatting)
				if(logged &&(reader.permission()>=1))
				{
					try
					{
					tmp_book=new Book();
					System.out.println("what is the name of the book you want to add");
					tmp_book.name=kb.next();
					System.out.println("what is the author of the book you want to add");
					tmp_book.author=kb.next();
					System.out.println("what is the serial number of the book you want to add");
					tmp_book.serialNumber=kb.nextInt();
					System.out.println("what is the genre of the book you want to add");
					tmp_book.genre=kb.next();
					System.out.println("what is the restriction level of the book you want to add");
					tmp_book.restriction=kb.nextInt();
					lib.add_book(tmp_book);
					}
					catch (InputMismatchException e)
					{ 
<<<<<<< HEAD
						System.out.println("Invalid input run the program again");
						inp=6;
=======
						System.out.println("Invalid input run the program again in 8");
						inp=7;
>>>>>>> 1b3ea11 (Added comments and changed formatting)
						break;
					}
				}
				else
					System.out.println("Incorrect input please try again");	
				break;
<<<<<<< HEAD
			case 9:
=======
			case 9:		//Remove a book from library
>>>>>>> 1b3ea11 (Added comments and changed formatting)
				if(logged && (reader.permission()>=1))
				{
					try
					{
<<<<<<< HEAD
					System.out.println("which book do you want to remove please provide the index that the book is at");
=======
					System.out.println("Which book do you want to remove? Please provide the index that the book is at.");
>>>>>>> 1b3ea11 (Added comments and changed formatting)
						lib.list_books();
						book_index=kb.nextInt();
						lib.remove_book(book_index);
					}
					catch (InputMismatchException e)
					{ 
<<<<<<< HEAD
						System.out.println("Invalid input run the program again");
						inp=6;
=======
						System.out.println("Invalid input run the program again in 9");
						inp=7;
>>>>>>> 1b3ea11 (Added comments and changed formatting)
						break;
					}
				}
				else 
<<<<<<< HEAD
					System.out.println("Incorrect input please try again");	
				break;
			default:
				System.out.println("Incorrect input please try again");	
=======
					System.out.println("Incorrect input please try again ()");	
				break;
			default:	//Incorrect initial choice
				System.out.println("Incorrect input please try again (OUT OF LOOP)");	
>>>>>>> 1b3ea11 (Added comments and changed formatting)
			}
		}
	}
}
