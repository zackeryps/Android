package com.cst236.zacksalzandroid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProvider {

    public static List<Book> books = new ArrayList<>();
    public static Map<String, Book> bookMap = new HashMap<>();

    public static void addBook(Book book) {
        books.add(book);
        bookMap.put(book.getId(), book);
    }

    public static List<String> getItemNames() {
        List<String> list = new ArrayList<>();
        for(Book book : books) {
            list.add(book.getName());
        }
        return list;
    }

    public static List<Book> getFilteredList(String search) {
        List<Book> list = new ArrayList<>();
        for(Book book : books) {
            if(book.getName().contains(search)) {
                list.add(book);
            }
        }
        return list;
    }

    static {
        addBook(new Book(
                "silmarillion",
                "The Silmarillion",
                "A collection of stories from 'The Lord of the Rings' detailing the events that led to the third age.",
                4.99
        ));
        addBook(new Book(
                "hobbit",
                "The Hobbit",
                "There and back again. The tale of Bilbo Baggins, his adventure to The Lonely Mountain, and meeting Smaug",
                5.99
        ));
        addBook(new Book(
                "fellowship",
                "The Lord of the Rings: The Fellowship of the Ring.",
                "Frodo Baggins departs from Bag's End on a mission to overcome the power of Sauron and destroy The One Ring.",
                3.99
        ));
        addBook(new Book(
                "towers",
                "The Lord of the Rings: The Two Towers.",
                "Frodo Baggins continues his journey as war erupts on Middle-Earth. The towers of Orthanc and Minas Morgul are at the forefront.",
                3.99
        ));
        addBook(new Book(
                "king",
                "The Lord of the Rings: The Return of the King.",
                "The culmination of the Adventure that started at Bag's End sees the return of the line of Isildur to the throne.",
                3.99
        ));
    }
}
