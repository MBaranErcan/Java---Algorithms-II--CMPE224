package nil;

import java.util.*;

class Book {
    private String author;
    private String title;
    private int quantity;

    public Book(String author, String title, int quantity) {
        this.author = author;
        this.title = title;
        this.quantity = quantity;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void decreaseQuantity() {
        quantity--;
    }
}