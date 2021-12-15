package io.javabrains.book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    private final String COVER_IMAGE_ROOT = "http://covers.openlibrary.org/b/id/";

    @GetMapping(value = "/books/{bookId}")
    public String getBookById(@PathVariable String bookId, Model model) {

        Optional<Book> bookOpt = bookRepository.findById(bookId);

        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            List<String> coverIds = book.getCoverIds();
            if (!coverIds.isEmpty()) {
                for (int i = 0; i < coverIds.size(); i++) {
                    String cover = coverIds.get(i);
                    cover = COVER_IMAGE_ROOT + cover + "-M.jpg";
                    coverIds.set(i, cover);
                }
            } else {
                coverIds.add("/images/no-cover.jpg");
            }

            book.setCoverIds(coverIds);

            model.addAttribute("book", book);
            return "book";

        } else {
            return "book-not-found.html";
        }

    }
}
