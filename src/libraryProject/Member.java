package libraryProject;
import java.util.*;
public class Member {
	private String user;
	private String pass;
	public Member(String user,String pass)
	{
		this.user=user;
		this.pass=pass;
	}
	public String name()
	{
		return user;
	}
	public boolean password_cmp(String pass)
	{
		return this.pass.equals(pass);
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Welcome to the library!");
		boolean bool=true;
		String user;
		String pass;
		int count=0;
		int inp;
		Member member_list[]=new Member[50];
		while(bool)
		{
			System.out.println("Press 1 to login, 2 to register, 3 to view members, 4 to exit");
			try
			{
			inp = kb.nextInt();
			}
			catch (InputMismatchException e)
     	 	{ 
         		System.out.println("Invalid input run the program again");
				break;
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
				}
				catch (InputMismatchException e)
				{ 
					System.out.println("Invalid input run the program again");
					break;
				}
				Member tmp=new Member(user,pass);
				member_list[count]=tmp;
				System.out.printf("Hello %s , %d\n",member_list[count].name(),count);
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
				bool=false;
				break;
			default:
				System.out.println("Incorrect input please try again");	
			}
		}
	}
}

