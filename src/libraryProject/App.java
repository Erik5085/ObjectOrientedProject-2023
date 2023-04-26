import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.*;
public class App extends Application {
    public int count=0;
    public int state=0;
    public boolean logged=false; //checks if user is logged in
    public Member reader= new Member();	//Instantiate member object
    public Member member_list[]=new Member[50];	//Create array of max 50 members
    public Library lib=new Library("The Library", 50);	//initiate Library with max size 50
    @Override
    public void start(Stage primaryStage) throws Exception {
		//Adding books to Book array
		lib.add_book(new Book("The Hunger Games","Suzanne Collins",0,"Young adult"));
		lib.add_book(new Book("Harry Potter and the Order of the Phoenix"," J.K. Rowling",1,"Fantasy"));
		lib.add_book(new Book("Pride and Prejudice","Jane Austen",2,"Classics"));
		lib.add_book(new Book("Industrial society and its future","Ted Kazynski",3,"Nonfiction"));
		lib.add_book(new Book("A Game of Thrones","George R. R. Martin",4,"Fantasy"));
		
		int book_index;	//stores index of chosen book
		Book tmp_book;	//stores temp index of chosen book
        // Create the buttons
        Button loginButton = new Button("Login");
        Button registerButton = new Button("Register");
        Button listBooks = new Button("List Books in library");
        Button addBookButton = new Button("Rent Book");
        Button returnBookButton = new Button("Return Book");
        Button exitButton = new Button("Exit");
        Button addBookLibButton = new Button("Add Book to library");
        Button removeBookLibButton = new Button("Add remove a book from the library");
        Button submit = new Button("Submit");

        // Create the text fields for the login button
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        TextField passwordField = new TextField();
        Label restrictionLabel = new Label("restriction:");
        TextField restrictionField = new TextField();
        // Create the text fields for the rent a book
        Label indexLabel = new Label("Index ");
        TextField indexField = new TextField();
        // Create the text fields for the add to library
        Label nameBookLabel = new Label("Book: ");
        TextField nameBookField = new TextField();
        Label authorBookLabel = new Label("Author: ");
        TextField authorBookField = new TextField();
        Label serialBookLabel = new Label("Serial Number: ");
        TextField serialBookField = new TextField();
        Label genreBookLabel = new Label("Genre: ");
        TextField genreBookField = new TextField();
        VBox vbox = new VBox();

        Label message= new Label("Message");
        // Add event handlers for the buttons
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Clear the previous contents of the VBox, usernameField, and passwordField
                vbox.getChildren().clear();
                usernameField.clear();
                passwordField.clear();
                // Add the username and password fields to the VBox
                vbox.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, submit);
                state=1;
            }
        });
        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Clear the previous contents of the VBox, usernameField, and passwordField
                vbox.getChildren().clear();
                usernameField.clear();
                passwordField.clear();
                restrictionField.clear();
                // Add the username and password fields to the VBox
                vbox.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField,restrictionLabel, restrictionField, submit);
                state=2;
            }
        });
        listBooks.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vbox.getChildren().clear();
                lib.list_books(vbox);
                submit.setText("Return");
                vbox.getChildren().add(submit);
                state=3;
            }
        });

        addBookButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                state=4;
                vbox.getChildren().clear();
                if(logged)
                {
                    lib.list_books(vbox);

                }
                else
                {
                    message.setText("Please log in before renting a book");
                }
            }
        });

        returnBookButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Return Book button clicked");
                state=5;
            }
        });

        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });
        addBookLibButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                state=7;
                if(!logged)
                {
                    submit.fire();
                    message.setText("Not logged in please log in");
                }
                else{
                // Clear the previous contents of the VBox
                vbox.getChildren().clear();
                vbox.getChildren().addAll(nameBookLabel,nameBookField,authorBookLabel,authorBookField,serialBookLabel,serialBookField,genreBookLabel,genreBookField);
                }
            }
        });

        submit.setOnAction(new EventHandler<ActionEvent>() {
         @Override
            public void handle(ActionEvent event) {
            boolean bool=true; //bool set to true to keep while loop on
            String user;	//local inputted username
            String pass;	//local inputted password
            int restriction;	//Stores restriction of user
            int inp;		//Value storage for case choice
            
            boolean repeat=false; //Used for register event
            //Adding books to Book array
            
            int book_index;	//stores index of chosen book
            Book tmp_book;	//stores temp index of chosen book
            switch (state) {
                
               case 1:
                try
				{
					user=usernameField.getText();
                    pass=passwordField.getText();
				}
				catch (InputMismatchException e)
				{ 
					message.setText("Invalid input run the program again");
					state=7;
					break;
				}
				for(int i=0;i<count;i++)
				{
					if(member_list[i].getName().equals(user))
					{
                        System.out.println(user+pass);
						if(member_list[i].password_cmp(pass))
						{
							logged=true;
							message.setText("you have successfully logged in");
						}
						break;
					}
				}
				if(!logged)
				{
					message.setText("your username or password was incorrect");
				}
				break;
               case 2:
                    try
                    {
                    user=usernameField.getText();
                    pass=passwordField.getText();
                    restriction=Integer.parseInt(restrictionField.getText());
                    }
                    catch(NumberFormatException e)
                    {
                        user=usernameField.getText();
                        pass=passwordField.getText();
                        restriction=0;
                    }
                    for(int i=0;i<count;i++)
                    {
                        if(member_list[i].getName().equals(user))
                        {
                            message.setText("Username already in use");
                            repeat=true;
                            break;
                        }
                    }
                    if(!repeat)	//For all normal cases
					{
                        System.out.println(user+pass);
						reader=new Member(user,pass,restriction);
						member_list[count]=reader;
						count++;
					}
                    break;
               case 3:
                    submit.setText("Submit");
                    break;
               case 4:
                    nameBookField.getText();
                    break;
               case 5:
                    
                    break;
               default:
                  
                  break;
            }
            vbox.getChildren().clear();
            vbox.getChildren().addAll(loginButton,registerButton,listBooks,addBookButton,returnBookButton,exitButton,message);
         }
     });
         
        // Create a VBox to hold the buttons
        vbox.getChildren().addAll(loginButton,registerButton,listBooks,addBookButton,returnBookButton,exitButton,message);

        // Create a scene and set it on the stage
        Scene scene = new Scene(vbox, 800, 800);
        primaryStage.setScene(scene);

        // Set the stage title and show it
        primaryStage.setTitle("Button Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        
        launch(args);
    }
}
