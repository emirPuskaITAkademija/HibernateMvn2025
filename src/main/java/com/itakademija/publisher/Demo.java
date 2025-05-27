package com.itakademija.publisher;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        PublisherDao dao = new PublisherDao();
        List<Publisher> publishers = dao.getAll();
        for(Publisher publisher : publishers) {
            System.out.println(publisher);
//            System.out.println("---Books-------");
//            publisher.getBooks().forEach(System.out::println);
//            System.out.println("--------------");
        }
    }
}
