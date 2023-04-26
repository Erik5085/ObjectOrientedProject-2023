package application;

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

/**
 * Library class stores Books as arrays and adds/removes books
 * @author Erik Vaughn, Thomas Truong
 *
 */
public class Library {
    private Book []books;	//Book array to contain Book values/params
    private int amount;		//amount of books stored in Library
    private int max;			//maximum amount of books to be stored in Library
    private String name;		//Name of library, mostly for Member name
        
    /*
     * Library constructor for length
     */
    public Library(String name, int length)
    {
        this.name=name;
        books=new Book[length];	//set the book array with length 
        amount=0;				//
        this.max=length;		//set the max library to length
    }
    
    /*
     * Library constructor for Book array
     */
    public Library(String name, Book books[])
    {
        this.name=name;
        this.books=books;	//sets books to given Book array
        amount=0;
        this.max=50;		//sets max library to 50
    }
    
    /*
     * Prints out the list of books
     */
    public void list_books()
    {
        System.out.println("Index\tName\tAuthor\tGenre");
        for(int i=0;i<amount;i++)
        {
            System.out.printf("%d\t%s\t%s\t%d\t%s\n",i,books[i].getName(),books[i].getAuthor(),books[i].getGenre());
        }
    }
    /*
     *  Adds books to vBox
     */
    public void list_books(VBox vbox)
    {
        vbox.getChildren().add(new Label("Index\t\tName\t\tAuthor\t\tGenre"));
        for(int i=0;i<amount;i++)
        {
            vbox.getChildren().addAll(new Label(i+"\t\t" + books[i].getName()+ "\t\t" + books[i].getAuthor()+ "\t\t" + books[i].getGenre()));
        }
    }
    /*
     * Adds book to Book array
     */
    public int add_book(Book book_inp)
	{
        if(max<=amount)
        {
            return 0;
        }
        books[amount]=book_inp;
        amount++;
        return 1;
	}
    
    /*
     * Removes book from Book array
     */
    public Book remove_book(int index)
    {
        Book tmp=books[index];
        for(int i = index;i<(amount-1);i++)
        {
            books[i]=books[i+1];
        }
        amount--;
        return tmp;
    }
    /*
     *  Getter methods
     */
    public Book[] getBooks(){
        return books;
    }
    public int getAmount(){
        return amount;
    }
    public int getMax(){
        return max;
    }
    public String getName(){
        return name;
    }
    /*
     *  Setter methods
     */
    public void setBooks(Book books[]){
        this.books=books;
    }
    public void setAmount(int amount){
        this.amount=amount;
    }
    public void setMax(int max){
        this.max=max;
    }
    public void setName(String name){
        this.name=name;
    }
}
