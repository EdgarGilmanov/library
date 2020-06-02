package ru.library;

import ru.library.service.DomParser;
import ru.library.service.RequestService;

public class Main {

    public static void main(String[] args) {
        DomParser domParser = new DomParser("lib.xml");
        RequestService service = new RequestService(domParser);

        System.out.println(service.getAllBooksUniqAuthor());
    }
}
