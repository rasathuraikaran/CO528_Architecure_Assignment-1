package comco528.assignment_1.service;


import comco528.assignment_1.exception.ResourceNotFoundException;
import comco528.assignment_1.model.Book;
import comco528.assignment_1.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    // Automatically injects an instance of BookRepository into this service
    @Autowired
    private BookRepository bookRepository;

    // Retrieves and returns a list of all books from the repository
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Retrieves and returns an Optional containing the book with the specified ID, if found
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    // Adds a new book to the repository and returns the saved book instance
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // Updates an existing book in the repository with new details and returns the updated book
    public Book updateBook(Long id, Book bookDetails) {
        // Fetches the book by ID, throws a ResourceNotFoundException if not found
        Book book = bookRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Book not found for this id :: " + id));

        // Updates the book's details
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setIsbn(bookDetails.getIsbn());

        // Saves the updated book back to the repository and returns it
        return bookRepository.save(book);
    }

    // Deletes the book with the specified ID from the repository
    public void deleteBook(Long id) {
        // Fetches the book by ID, throws a ResourceNotFoundException if not found
        Book book = bookRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Book not found for this id :: " + id));

        // Deletes the book from the repository
        bookRepository.delete(book);
    }
}