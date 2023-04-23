package libraryProject;
import java.util.Scanner;
public class Member {
	static private Scanner kb = new Scanner(System.in);
	static private int SIZE=20;
	public static Member[] member_list=new Member[SIZE];
	private String user;
	private String pass;
	/*
	 * Reads txt file to check if prompted member is authorized
	 */
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
		System.out.println("Welcome to the library!");
		boolean bool=true;
		String user;
		String pass;
		while(bool)
		{
			System.out.println("Press 1 to login, 2 to register, 3 to view members,4 to exit,");
			int inp = kb.nextInt();
			int count=0;
			Member member_list[]=new Member[50];
			switch (inp) {
			case 1:
				System.out.println("Enter username:");
				user = kb.nextLine();
				System.out.println("Enter pass:");
				pass = kb.nextLine();
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
				System.out.println("Enter username:");
				user = kb.next();
				System.out.println("Enter pass:");
				pass = kb.next();
				
				Member tmp=new Member(user,pass);
				member_list[count]=tmp;
				count++;
				System.out.printf("Hello %s , %d\n",member_list[count-1].name(),count);
				break;
			case 3:
				System.out.println("Users");
				for(int i=0;i<count;i++)
				{
					System.out.println(i);
					System.out.println(member_list[i]);
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
