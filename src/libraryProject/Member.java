package libraryProject;
import java.util.Scanner;

public class Member {
	Scanner kb = new Scanner(System.in);
	
	/*
	 * Reads txt file to check if prompted member is authorized
	 */
	public void login() {
		System.out.println("Enter username:");
		String user = kb.nextLine();
		System.out.println("Enter pass:");
		String pass = kb.nextLine();
		
		
		
		
	}
	
	public static void main(String[] args) {
		
		
		System.out.println("Welcome to the library!");
		System.out.println("Press 1 to login, 2 to register, 3 to exit");
		int inp = kb.nextInt();
		
		
		
		/*
		switch (inp) {
		case 1:
			();
			break;
		case 2:
			
			break;
		case 3:
			break;
		}
		*/
	}
}
