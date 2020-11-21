package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class BookModel {

    private static int count;
    private int page_now;
    private Book book;
    private ArrayList<Book> books;

    public BookModel(){

        count = 0;
        page_now = 0;
        books = new ArrayList<Book>();
        books.add(new Book());

    }

    public void addArray(String name, String price, String type){
        books.add(new Book(name, Double.parseDouble(price), type));
        count++;
    }

    public void deleteArray(){
        books.remove(page_now);
        page_now--;
        count--;
    }

    public void updateArray(String name, String price, String type){
        books.get(page_now).setName(name);
        books.get(page_now).setPrice(Double.parseDouble(price));
        books.get(page_now).setType(type);
    }

    public void toRightPage(){
        page_now++;
    }

    public void toLeftPage(){
        page_now--;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        BookModel.count = count;
    }

    public int getPage_now() {
        return page_now;
    }

    public void setPage_now(int page_now) {
        this.page_now = page_now;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
