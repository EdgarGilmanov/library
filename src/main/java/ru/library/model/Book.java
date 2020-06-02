package ru.library.model;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@XmlType(name = "book")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {
    @XmlElement(name = "title")
    private String title;

    @XmlElementWrapper(name="authors")
    @XmlElement(name="id")
    private List<Integer> authors;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Integer> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Integer> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) &&
                Objects.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, authors);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                '}';
    }
}
