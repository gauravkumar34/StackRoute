public class BookStore {
    //identity
    String storeName;
    //has-a -> composition relationship
    Book[] books;

    //behaviour
   public float discountOnTheBook(Book book, float discount)
    {
        float bookPrice = book.bookPrice;
        return bookPrice - (bookPrice*discount/100);
    }

}
