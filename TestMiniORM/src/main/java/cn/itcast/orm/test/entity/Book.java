package cn.itcast.orm.test.entity;

import cn.itcast.orm.annotation.ORMColumn;
import cn.itcast.orm.annotation.ORMId;
import cn.itcast.orm.annotation.ORMTable;

import java.util.*;

@ORMTable(name = "t_book")
public class Book {
    @ORMId
    @ORMColumn(name = "bid")
    private long id;
    @ORMColumn(name = "bname")
    private String name;
    @ORMColumn(name = "author")
    private String author;
    @ORMColumn(name = "price")
    private double price;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
