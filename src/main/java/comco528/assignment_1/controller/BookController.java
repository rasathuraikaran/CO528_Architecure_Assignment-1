package comco528.assignment_1.controller;




import comco528.assignment_1.exception.ResourceNotFoundException;
import comco528.assignment_1.model.Book;
import comco528.assignment_1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    // Automatically injects an instance of BookService into this controller
    @Autowired
    private BookService bookService;

    // Handles HTTP GET requests to /api/books, returning a list of all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // Handles HTTP GET requests to /api/books/{id}, returning the book with the specified ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        // Fetches the book by ID, throws a ResourceNotFoundException if not found
        Book book = bookService.getBookById(id).orElseThrow(() ->
                new ResourceNotFoundException("Book not found for this id :: " + id));
        // Returns the book in the response body with a status of 200 OK
        return ResponseEntity.ok().body(book);
    }

    // Handles HTTP POST requests to /api/books, creating a new book entry
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        // Adds the book to the repository and returns the created book
        return bookService.addBook(book);
    }

    // Handles HTTP PUT requests to /api/books/{id}, updating the book with the specified ID
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        // Updates the book details and returns the updated book in the response body
        Book updatedBook = bookService.updateBook(id, bookDetails);
        return ResponseEntity.ok(updatedBook);
    }

    // Handles HTTP DELETE requests to /api/books/{id}, deleting the book with the specified ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        // Deletes the book from the repository
        bookService.deleteBook(id);
        // Returns a response with a status of 204 No Content
        return ResponseEntity.noContent().build();
    }
}
