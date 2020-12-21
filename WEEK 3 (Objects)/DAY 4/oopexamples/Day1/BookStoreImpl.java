import java.util.Scanner;

public class BookStoreImpl {

    public static void main(String[] args) {


        //selecting a book

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Isbn No : ");
        int isbnNo = sc.nextInt();
        
        Book b = new Book(isbnNo, "Mocking Bird", "JL Baird", 450);
        //Constructor -> invoked -> allocate memory to the variables
        b.displayBookDetails();

        int [] a = {1,2,34,5};
        a[0] = 2;
        a[1] = 5;

        Book[] arra1 = Book.acceptBookValues();//5
        //book0(isbmno,name,author,price),book1(), book2(), book3(), book 4()
        

        // arra1[0] ->
        // arra1[1] ->
        Book[] arra2 = Book.acceptBookValues();

        Book b1 = new Book(111,"Kite Runner","Paul Coelho",550);
        b1.displayBookDetails();
        //call the calculate to see how much discount for the book

        BookStore bookStore = new BookStore();
        float discountedPrice = bookStore.discountOnTheBook(b, 2.5f); // b-> book object, 2 -> is just a value
        System.out.println("The discounted price on "+b.bookName+" is : "+discountedPrice);
    }
    
}
