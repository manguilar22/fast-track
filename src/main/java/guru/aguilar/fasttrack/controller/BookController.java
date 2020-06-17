package guru.aguilar.fasttrack.controller;


import guru.aguilar.fasttrack.dao.Book;
import guru.aguilar.fasttrack.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;


    @GetMapping("/")
    public String getBooks() {
        return bookRepository.findAll().toString();
    }


    @PostMapping("/")
    public String postBook(@RequestBody Book book) {
        try {
            bookRepository.save(book);
            return "200";
        } catch (Exception e) {
            return "500";
        }
    }


}
