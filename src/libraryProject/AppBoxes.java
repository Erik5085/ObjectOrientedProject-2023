

import javafx.application.Application;
import javafx.application.Platform;
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

/**
 * App
 * @author Erik Vaughn, Thomas Truong, 
 *
 */
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
    Button rentBookButton = new Button("Rent Book");
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
		lib.add_book(new Book("The Hunger Games","Suzanne Collins","Young adult"));
		lib.add_book(new Book("Harry Potter and the Order of the Phoenix","J.K. Rowling","Fantasy"));
		lib.add_book(new Book("Pride and Prejudice","Jane Austen","Classics"));
		lib.add_book(new Book("Industrial society and its future","Ted Kazynski","Nonfiction"));
		lib.add_book(new Book("A Game of Thrones","George R. R. Martin","Fantasy"));
    }
    
    /*
     * Main method for launching JavaFX
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /*
     * Loads main screen that contains all the buttons
     */
    public VBox loadMainScreen() {
    	VBox vbox = new VBox();
    	vbox.getChildren().clear();
    	prompt.setText("Pick an action");
    	// redefine nav buttons everytime go back to main screen
        submit = new Button("Submit");
        home = new Button("Home");
        hub = new HBox(submit, home);
        usernameField.clear();
        passwordField.clear();
        restrictionField.clear();
        indexField.clear();
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
            	Platform.exit();
            }
        });
        
        vbox.getChildren().addAll(prompt,loginButton,registerButton, listBooks);
        
        // Check for buttons to show when logged in
        if(logged){
        	// Shows books in user's library
            userBooksButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    userBooksButton.getScene().setRoot(loadUserBooks());
                }
            });
            
            // Shows books to be rented
            rentBookButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    rentBookButton.getScene().setRoot(loadRentBook());
                }
            });
            
            // Shows books to be returned from user's library
            returnBookButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    returnBookButton.getScene().setRoot(loadReturnBook());
                }
            });
            vbox.getChildren().addAll(userBooksButton,rentBookButton,returnBookButton);
            
            // Buttons for if user is restriction level = 1
            if(reader.permission()>=1)
            {
            	// For adding books to the library
                addBookLibButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        addBookLibButton.getScene().setRoot(loadAddLibBook());
                    }
                });
                
                // For removing books from the library
                removeBookLibButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        removeBookLibButton.getScene().setRoot(loadRemLibBook());
                    }
                });
                vbox.getChildren().addAll(addBookLibButton,removeBookLibButton);
            }   
        }   
        vbox.getChildren().addAll(exitButton,message); //Shows exit button at the very bottom under all the other buttons
    	return vbox;
    }
    
    /*
     * Loads screen for logins
     */
    public VBox loadLoginScreen() {
    	VBox vbox = new VBox();
        prompt.setText("Put in a username and password");
        vbox.getChildren().add(prompt);
		// Home button goes back home
    	home.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	home.getScene().setRoot(loadMainScreen());
            }
        });
    	
    	// On 
    	submit.setOnAction(new EventHandler<ActionEvent>() {
    		@Override
    		public void handle(ActionEvent event) {
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
 					message.setText("Your username or password was incorrect");
 				}
    		}
    	});
    	
        usernameField.clear();
        passwordField.clear();
        // Add the username and password fields to the VBox
        vbox.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, hub,message);
    	
    	return vbox;
    }
    
    /*
     * Loads screen for account register
     */
	public VBox loadRegScreen() {
		VBox vbox = new VBox();
        prompt.setText("Create a username and password for yourself");
        vbox.getChildren().add(prompt);
		// Home button goes back home
		home.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	home.getScene().setRoot(loadMainScreen());
            }
        });
    	
    	submit.setOnAction(new EventHandler<ActionEvent>() {
    		@Override
    		public void handle(ActionEvent event) {
                repeat=false;
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
                    }
                }
                if(!repeat)	//For successful 
				{
                    message.setText("Account created successfully");
					member_list[count] = new Member(user,pass,restriction);
					count++;
					submit.getScene().setRoot(loadMainScreen());
				}
    		}
    	});
        indexField.clear();
        restrictionField.clear();
        usernameField.clear();
        passwordField.clear();
        restrictionField.clear();
        
        // Add the username and password fields to the VBox
        vbox.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField,restrictionLabel, restrictionField, hub,message);
    	return vbox;
	}
	
	public VBox loadViewBooks() {
		VBox vbox = new VBox();
        prompt.setText("Here is a list of all the books in the library");
        vbox.getChildren().add(prompt);
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
        prompt.setText("Which book do you want to rent from the library (give the index of the book)");
        vbox.getChildren().add(prompt);
		lib.list_books(vbox);
		
		vbox.getChildren().addAll(indexLabel,indexField);
		
		// Home button goes back home
		home.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	home.getScene().setRoot(loadMainScreen());
            }
        });
		
		// Runs submit to rent books
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	try
                {
                    book_index=Integer.parseInt(indexField.getText());
                    tmp_book=lib.remove_book(book_index);
                    if(tmp_book==null)
                        message.setText("Invalid Book Choice");
                    else{
                    reader.add_book(tmp_book);
                    message.setText("You have successfully added a book");
                    submit.getScene().setRoot(loadMainScreen());
                    }
                }
            	catch (NullPointerException e)
            	{
            		System.out.println("bad.");
            		message.setText("Invalid input run the program again");
            	}
                catch (NumberFormatException e)
                { 
                	System.out.println("BAD.");
                    message.setText("Invalid input run the program again");
                }
            	catch (InputMismatchException e)
                { 
                    message.setText("Non integer entered");
                }
                catch(IndexOutOfBoundsException e)
                {
                    message.setText("Index out of range");
                }
            }
        });
        vbox.getChildren().addAll(hub,message);
        return vbox;
	}
	
	/*
	 * Screen for returning books
	 */
	public VBox loadReturnBook() {
		VBox vbox = new VBox();
        prompt.setText("Which book do you want to return (give an index for the book you wish to remove)");
        vbox.getChildren().addAll(prompt);
        
		reader.list_books(vbox);
		
        vbox.getChildren().addAll(indexLabel,indexField,hub,message);
        
        // Home button goes back home
        home.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	home.getScene().setRoot(loadMainScreen());
            }
        });
        
        // Submit button runs return submission
    	submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    try
                    {
                        book_index=Integer.parseInt(indexField.getText());
                        tmp_book=reader.remove_book(book_index);
                        if(tmp_book==null)
                            message.setText("invalid input");
                        else{
                            lib.add_book(tmp_book);
                            submit.getScene().setRoot(loadMainScreen());
                        }
                    }
                    catch (NumberFormatException e)
                    { 
                        message.setText("Non integer entered");
                    }
                    catch (NullPointerException e)
                	{
                		message.setText("Invalid input run the program again");
                	}
                    catch(ArrayIndexOutOfBoundsException e)
                    {
                        message.setText("Index out of range");
                    }
                    indexField.clear();
            }
        });
		return vbox;
	}

    public VBox loadUserBooks(){
        VBox vbox = new VBox();
        prompt.setText("Here is all of the books you have");
        vbox.getChildren().add(prompt);
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
        prompt.setText("Give information on the book you want to add to the library");
        vbox.getChildren().addAll(prompt,nameBookLabel,nameBookField,authorBookLabel,authorBookField,genreBookLabel,genreBookField,hub);
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
                    tmp_book=new Book(nameBookField.getText(),authorBookField.getText(),genreBookField.getText());
                    lib.add_book(tmp_book);
                    message.setText("You have successfully added a book to the library");
                    submit.getScene().setRoot(loadMainScreen());
                }  
                catch (NullPointerException |NumberFormatException|InputMismatchException |IndexOutOfBoundsException e)
            	{
            		message.setText("Invalid input please try again");
                    nameBookField.clear();
                    authorBookField.clear();
                    genreBookField.clear();
            	}
            }
        });
		return vbox;
	}
	public VBox loadRemLibBook() {
		VBox vbox = new VBox();
        prompt.setText("Which book do you want to remove from the library");
        vbox.getChildren().addAll(prompt);
		lib.list_books(vbox);
        vbox.getChildren().addAll(indexLabel,indexField,hub,message);
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
                        tmp_book = lib.remove_book(book_index);
                        if(tmp_book==null){
                            indexField.clear();
                            message.setText("Out of range or invalid input");
                        }
                        else{
                            message.setText("you have successfully removed a book from the library");
                            submit.getScene().setRoot(loadMainScreen());
                        }
                    }
                    catch (NumberFormatException e)
                    { 
                        message.setText("Non integer entered");
                        indexField.clear();
                    }
            }
        });
		return vbox;
	}
}
