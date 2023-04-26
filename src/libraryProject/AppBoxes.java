
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.*;

public class App extends Application {
    public int count=0;	//stores count for For loops
    public int state=0;	//stores current state of event
    public boolean logged=false; //checks if user is logged in
    
    public Member reader;	//Instantiate member object
    public Member member_list[]=new Member[50];	//Create array of max 50 members
    public Library lib=new Library("The Library", 50);	//initiate Library with max size 50
    
    Button submit = new Button("Submit");
    Button home = new Button("Home");
    HBox hub = new HBox(submit, home);
    
    
 // Create the buttons
    Button loginButton = new Button("Login");
    Button registerButton = new Button("Register");
    Button listBooks = new Button("List Books in library");
    Button addBookButton = new Button("Rent Book");
    Button returnBookButton = new Button("Return Book");
    Button exitButton = new Button("Exit");
    Button userBooksButton = new Button("View user's books");
    // Buttons for restrict lvl 1
    Button addBookLibButton = new Button("Add Book to library");
    Button removeBookLibButton = new Button("Remove a book from the library");
    

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
    
    Label prompt = new Label("Pick an action");
    Label message= new Label("Please log in/register an account");
    boolean bool=true; //bool set to true to keep while loop on
    String user;	//local inputted username
    String pass;	//local inputted password
    int restriction;	//Stores restriction of user
    int inp;		//Value storage for case choice
    

    boolean repeat=false; //Used for register event
    //Adding books to Book array
    
    int book_index;	//stores index of chosen book
    Book tmp_book;	//stores temp index of chosen book


    @Override
    
    /*
     * Start method stores main program
     */
    public void start(Stage primaryStage) throws Exception {
    	// Create a scene and set it on the stage
    	
        Scene scene = new Scene(loadMainScreen(), 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
        
		//Adding books to Book array
		lib.add_book(new Book("The Hunger Games","Suzanne Collins",0,"Young adult"));
		lib.add_book(new Book("Harry Potter and the Order of the Phoenix","J.K. Rowling",1,"Fantasy"));
		lib.add_book(new Book("Pride and Prejudice","Jane Austen",2,"Classics"));
		lib.add_book(new Book("Industrial society and its future","Ted Kazynski",3,"Nonfiction"));
		lib.add_book(new Book("A Game of Thrones","George R. R. Martin",4,"Fantasy"));
		
		int book_index;	//stores index of chosen book
		Book tmp_book;	//stores temp index of chosen book
		
        
        
        VBox vbox = new VBox();
    }
    
    /*
     * Main method for launching JavaFX
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /*
     * Main screen
     */
    public VBox loadMainScreen() {
    	VBox vbox = new VBox();
    	vbox.getChildren().clear();
    	prompt.setText("Pick an action");
    	// redefine nav buttons everytime go back to main screen
        submit = new Button("Submit");
        home = new Button("Home");
        hub = new HBox(submit, home);
        
        // user login button
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	loginButton.getScene().setRoot(loadLoginScreen());
            }
        });
        // user register button
        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	registerButton.getScene().setRoot(loadRegScreen());
            }
        });
        
        // list books from library
        listBooks.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	listBooks.getScene().setRoot(loadViewBooks());
            }
        });
        // exit program
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        vbox.getChildren().addAll(prompt,loginButton,registerButton);
        if(logged){
            userBooksButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    userBooksButton.getScene().setRoot(loadUserBooks());
                }
            });
            addBookButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    addBookButton.getScene().setRoot(loadRentBook());
                }
            });
            returnBookButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    returnBookButton.getScene().setRoot(loadReturnBook());
                }
            });
            vbox.getChildren().addAll(userBooksButton,listBooks,addBookButton,returnBookButton);
            if(reader.permission()>=1)
            {
                addBookLibButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        addBookLibButton.getScene().setRoot(loadAddLibBook());
                    }
                });
                removeBookLibButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        removeBookLibButton.getScene().setRoot(loadRemLibBook());
                    }
                });
                vbox.getChildren().addAll(addBookLibButton,removeBookLibButton);
            }   
        }   
        vbox.getChildren().addAll(exitButton,message);
    	return vbox;
    }
    
    public VBox loadLoginScreen() {
    	VBox vbox = new VBox();
		vbox.getChildren().clear();

    	home.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	home.getScene().setRoot(loadMainScreen());
            }
        });
    	
    	submit.setOnAction(new EventHandler<ActionEvent>() {
    		@Override
    		public void handle(ActionEvent event) {
    			System.out.println("This worked!");
    			 user=usernameField.getText();
                 pass=passwordField.getText();
                 System.out.println(user + " " + pass);
 				for(int i=0;i<count;i++)
 				{
 					if(member_list[i].getName().equals(user))
 					{
 						if(member_list[i].password_cmp(pass))
 						{
 							logged=true;
                            reader=member_list[i];
 							message.setText("you have successfully logged in");
 							submit.getScene().setRoot(loadMainScreen());
 						}
 					}
 				}
 				if(!logged)
 				{
 					submit.getScene().setRoot(loadMainScreen());
 					message.setText("Your username or password was incorrect");
 				}
    		}
    	});
    	
        usernameField.clear();
        passwordField.clear();
        // Add the username and password fields to the VBox
        vbox.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, hub);
    	
    	return vbox;
    }
    
	public VBox loadRegScreen() {
		VBox vbox = new VBox();
		vbox.getChildren().clear();

		home.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	home.getScene().setRoot(loadMainScreen());
            }
        });
    	
    	submit.setOnAction(new EventHandler<ActionEvent>() {
    		@Override
    		public void handle(ActionEvent event) {
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
                        submit.getScene().setRoot(loadMainScreen());
                    }
                }
                if(!repeat)	//For all normal cases
				{
                    System.out.println(user+pass);
					member_list[count] = new Member(user,pass,restriction);
					count++;
					submit.getScene().setRoot(loadMainScreen());
				}
    		}
    	});
    	
    	vbox.getChildren().clear();
        indexField.clear();
        restrictionField.clear();
        usernameField.clear();
        passwordField.clear();
        restrictionField.clear();
        
        // Add the username and password fields to the VBox
        vbox.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField,restrictionLabel, restrictionField, hub);
    	return vbox;
	}
	
	public VBox loadViewBooks() {
		VBox vbox = new VBox();
		vbox.getChildren().clear();
		lib.list_books(vbox);
		
		home.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	home.getScene().setRoot(loadMainScreen());
            }
        });
		
        vbox.getChildren().addAll(home);
		return vbox;
	}
	
	public VBox loadRentBook() {
		VBox vbox = new VBox();
		lib.list_books(vbox);
		
		vbox.getChildren().addAll(indexLabel,indexField);
		
		home.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	home.getScene().setRoot(loadMainScreen());
            }
        });
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	try
                {
                    book_index=Integer.parseInt(indexField.getText());
                    tmp_book=lib.remove_book(book_index);
                    reader.add_book(tmp_book);
                    message.setText("You have successfully added a book");
                    submit.getScene().setRoot(loadMainScreen());
                }
                catch (NumberFormatException e)
                { 
                    message.setText("Invalid input run the program again");
                    submit.getScene().setRoot(loadMainScreen());
                }
            }
        });
        vbox.getChildren().addAll(hub);
        return vbox;
	}
	public VBox loadReturnBook() {
		VBox vbox = new VBox();
        prompt.setText("Which book do you want to return");
        vbox.getChildren().addAll(prompt);
		reader.list_books(vbox);
        vbox.getChildren().addAll(indexLabel,indexField,hub);
        home.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	home.getScene().setRoot(loadMainScreen());
            }
        });
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    try
                    {
                        book_index=Integer.parseInt(indexField.getText());
                        lib.add_book(reader.remove_book(book_index));
                    }
                    catch (InputMismatchException e)
                    { 
                        message.setText("Non integer entered");
                    }
                    catch(IndexOutOfBoundsException e)
                    {
                        message.setText("Index out of range");
                    }
                submit.getScene().setRoot(loadMainScreen());
            }
        });
		return vbox;
	}

    public VBox loadUserBooks(){
        VBox vbox = new VBox();
        vbox.getChildren().clear();
        reader.list_books(vbox);
        vbox.getChildren().addAll(home);
        home.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	home.getScene().setRoot(loadMainScreen());
            }
        });
        return vbox;
    }
	public VBox loadAddLibBook() {
		VBox vbox = new VBox();
        vbox.getChildren().addAll(nameBookLabel,nameBookField,authorBookLabel,authorBookField,serialBookLabel,serialBookField,genreBookLabel,genreBookField,hub);
		home.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	home.getScene().setRoot(loadMainScreen());
            }
        });
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try 
                {
                    tmp_book=new Book(nameBookField.getText(),authorBookField.getText(),Integer.parseInt(serialBookField.getText()),genreBookField.getText());
                    lib.add_book(tmp_book);
                } 
                catch (NumberFormatException e) 
                {
                    message.setText("Error Occurred please try again");
                }
            	submit.getScene().setRoot(loadMainScreen());
            }
        });
		return vbox;
	}
	public VBox loadRemLibBook() {
		VBox vbox = new VBox();
        prompt.setText("Which book do you want to remove from the library");
        vbox.getChildren().addAll(prompt);
		lib.list_books(vbox);
        vbox.getChildren().addAll(indexLabel,indexField,hub);
        home.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	home.getScene().setRoot(loadMainScreen());
            }
        });
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    try
                    {
                        book_index=Integer.parseInt(indexField.getText());
                        lib.remove_book(book_index);
                    }
                    catch (InputMismatchException e)
                    { 
                        message.setText("Non integer entered");
                    }
                    catch(IndexOutOfBoundsException e)
                    {
                        message.setText("Index out of range");
                    }
                submit.getScene().setRoot(loadMainScreen());
            }
        });
		return vbox;
	}
}
