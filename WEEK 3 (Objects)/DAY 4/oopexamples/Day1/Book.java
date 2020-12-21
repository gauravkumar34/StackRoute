import java.util.Scanner;

public class Book{
    //identity
    //instance variables
    int ISBNNo;
    String bookName;
    String authorName;
    float bookPrice;
    
    
    //get the values from the user -> books that I am going to have in the store
    public static Book[] acceptBookValues()
    {
        Book[] books = new Book[5];// contains objects of type Book -> 5
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values : ");
        for(int i =0;i<books.length;i++){
            int isNo = sc.nextInt();
            String bName = sc.next();
            String author = sc.next();
            float price = sc.nextFloat();    
            Book book = new Book (isNo,bName,author,price);
            books[i] = book;//book[0] => , book[1] =>.....
        }  
       


        return books;

    }
    // //parameterized constructors
    public Book(int ISBNNo, String bookName, String authorName, float bookPrice) {
        this.ISBNNo = ISBNNo;
        //instance variable = variable being passed
        this.bookName = bookName;
        this.authorName = authorName;
        this.bookPrice = bookPrice;
    }
    //behaviour
    public void displayBookDetails()
    {
        System.out.println(ISBNNo+":"+bookName+":"+authorName+":"+bookPrice);
    }

    
}