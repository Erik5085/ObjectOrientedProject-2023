import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
   public int state=0;
   public String username;
   public String password;
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create the buttons
        Button loginButton = new Button("Login");
        Button registerButton = new Button("Register");
        Button addBookButton = new Button("Add Book");
        Button returnBookButton = new Button("Return Book");
        Button exitButton = new Button("Exit");
         Button submit = new Button("Submit");

        // Create the text fields for the login button
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        TextField passwordField = new TextField();
        VBox vbox = new VBox();

        // Add event handlers for the buttons
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               username=usernameField.getText();
               password=passwordField.getText();
                // Clear the previous contents of the VBox
                vbox.getChildren().clear();
                // Add the username and password fields to the VBox
                vbox.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, submit);
                System.out.println(username+"\n"+password);
                state=1;
            }
        });
        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Register button clicked");
                state=2;
            }
        });

        addBookButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Add Book button clicked");
                state=3;
            }
        });

        returnBookButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Return Book button clicked");
                state=4;
            }
        });

        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });

        submit.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent event) {
            switch (state) {
               case 1:
                    reader.
                    break;
               case 2:

                    break;
               case 3:
                  
                  break;
               case 4:
                  
                  break;
               case 5:

                    break;
               default:
                  
                  break;
            }
            vbox.getChildren().clear();
            vbox.getChildren().addAll(loginButton,registerButton,addBookButton,returnBookButton,exitButton);
         }
     });
         
        // Create a VBox to hold the buttons
        vbox.getChildren().addAll(loginButton,registerButton,addBookButton,returnBookButton,exitButton);

        // Create a scene and set it on the stage
        Scene scene = new Scene(vbox, 300, 250);
        primaryStage.setScene(scene);

        // Set the stage title and show it
        primaryStage.setTitle("Button Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
