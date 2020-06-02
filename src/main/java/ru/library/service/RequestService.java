package ru.library.service;
import ru.library.model.Book;

import java.util.*;

public class RequestService {
    private final DomParser parser;

    public RequestService(DomParser parser) {
        this.parser = parser;
    }

    public Collection<Book> getAllBooksUniqAuthor() {
        Map<Integer, Book> tmp = new HashMap<>();
        Set<Book> rsl = new HashSet<>();
        List<Book> books = parser.getAllBooks();
        for (Book book : books) {
            for (Integer author : book.getAuthors()) {
                if (tmp.containsKey(author)) {
                    break;
                }
                tmp.put(author, book);
            }
            rsl.add(book);
        }
        return rsl;
    }
}
