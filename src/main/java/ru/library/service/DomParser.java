package ru.library.service;

import org.w3c.dom.*;
import ru.library.model.Author;
import ru.library.model.Book;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DomParser {
    private final String path;
    private final DocumentBuilderFactory factory;
    private final DocumentBuilder builder;

    public DomParser(String path) {
        try {
            this.path = path;
            this.factory = DocumentBuilderFactory.newInstance();
            this.builder = factory.newDocumentBuilder();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public List<Book> getAllBooks() {
        List<Book> rsl = new ArrayList<>();
        try {
            Document document = builder.parse(new File(path));
            NodeList elements = document.getElementsByTagName("book");
            for (int i = 0; i < elements.getLength(); i++) {
                JAXBContext context = JAXBContext.newInstance(Book.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                Book book = (Book) unmarshaller.unmarshal(elements.item(i));
                rsl.add(book);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rsl;
    }

    public List<Author> getAllAuthors() {
        List<Author> rsl = new ArrayList<>();
        try {
            Document document = builder.parse(new File(path));
            NodeList elements = document.getElementsByTagName("author");
            for (int i = 0; i < elements.getLength(); i++) {
                JAXBContext context = JAXBContext.newInstance(Author.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                Author author = (Author) unmarshaller.unmarshal(elements.item(i));
                rsl.add(author);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rsl;
    }
}
