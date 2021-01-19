import java.util.*;

public class Library {
    // Add the missing implementation to this class
    // Library Hours for each library
//    String LibraryHours = "Open 9 AM to 5 PM daily";

    //Library Address
    String libraryAddress;

    //Array for Books
    ArrayList<Book> books;

 /*   public String getLibraryHours() {
        return LibraryHours;
    }

    public void setLibraryHours(String libraryHours) {
        LibraryHours = libraryHours;
    }

    public String getLibraryAddress() {
        return libraryAddress;
    }*/

/*    public void setLibraryAddress(String libraryAddress) {
        this.libraryAddress = libraryAddress;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }*/



    //Method to address and books
    public Library(String address)
    {
        libraryAddress = address;
        books = new ArrayList<>();
    }

    //Method to add book to books
    public void addBook(Book book)
    {
        books.add(book);
    }

    //Method to print Address
    public void printAddress()
    {
        System.out.println(libraryAddress);
    }

    // Method to print library hours
    public static void printOpeningHours() {
        System.out.println("Libraries are open daily from 9 AM to 5 PM.");
    }

    // Method for borrowing a book
    public String borrowBook( String bookTitle){
        Book libraryBook;
        String libraryBookTitle;

        for ( int i=0; i < books.size(); i++){
            libraryBook = books.get(i);
            libraryBookTitle =libraryBook.getTitle();

            if(libraryBookTitle.equals(bookTitle)){

                if(!(libraryBook.isBorrowed())){
                    libraryBook.borrowed();
                    System.out.println("You successfully borrowed " + libraryBookTitle);
                    return null;
                }

                else {
                    System.out.println("Sorry! This book is already borrowed");
                    return null;
                }
            }
        }
        System.out.println("Your book was not found in the library catalog");
        return null;
    }

    // Method return book to library
    public void returnBook( String bookTitle){
        Book libraryBook;
        boolean found = false;
        String libraryBookTitle;

        for(int i=0; i<books.size(); i++){
            libraryBook = books.get(i);
            libraryBookTitle = libraryBook.getTitle();

            if(libraryBookTitle.equals(bookTitle)){

                if(libraryBook.isBorrowed()){
                    libraryBook.returned();
                    System.out.println("You successfully returned: " + libraryBookTitle);
                    found = true;
                    break;
                }
            }

        }   if(!found){

            System.out.println("Your book was not found in the library catalog");
        }


    }

    // Method to print all available books for a library [borrowed is false]
    private void printAvailableBooks() {
//        System.out.println("printAvailableBooks called");
        Book libraryBook;
        boolean libraryIsEmpty = true;
        for (int i= 0; i < books.size(); i++){
            libraryBook = books.get(i);

            if(!(libraryBook.isBorrowed())){
                System.out.println(libraryBook.getTitle());
                libraryIsEmpty = false;
            }
        }if(libraryIsEmpty){
            System.out.println("No books in catalog");
        }
    }

// ******************




    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petite Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }

}