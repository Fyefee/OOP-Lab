package Controller;

import Model.Book;
import Model.BookModel;
import View.BookAdd;
import View.BookView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BookController implements ActionListener, WindowListener {

    private BookView bookView;
    private BookAdd bookAdd;
    private BookModel bookModel;

    public BookController(){
        bookView = new BookView();
        bookAdd = new BookAdd();
        bookModel = new BookModel();
        setListener();
    }

    public void setListener(){

        bookView.getAdd_button().addActionListener(this);
        bookView.getDelete_button().addActionListener(this);
        bookView.getUpdate_button().addActionListener(this);
        bookView.getLeft_button().addActionListener(this);
        bookView.getRight_button().addActionListener(this);

        bookAdd.getInsert_button().addActionListener(this);

        bookView.getFrame().addWindowListener(this);

    }

    public void turntoLeftPage(){
        if (bookModel.getPage_now() == 0){
            bookView.refreshView("", "", "General", bookModel.getPage_now());
        } else {
            bookView.refreshView(bookModel.getBooks().get(bookModel.getPage_now()).getName(), String.valueOf(bookModel.getBooks().get(bookModel.getPage_now()).getPrice()), bookModel.getBooks().get(bookModel.getPage_now()).getType(), bookModel.getPage_now());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(bookView.getAdd_button())){
            bookAdd.getFrame().setVisible(true);
        } else if (e.getSource().equals(bookView.getDelete_button())){
            if (bookModel.getPage_now() != 0) {
                bookModel.deleteArray();
                turntoLeftPage();
                JOptionPane.showMessageDialog(bookView.getFrame(), "Done it.", "Delete Command", JOptionPane.PLAIN_MESSAGE);
            }
        } else if (e.getSource().equals(bookView.getUpdate_button())){
            if (bookModel.getPage_now() != 0) {
                try {
                    bookModel.updateArray(bookView.getName_tf().getText(), bookView.getPrice_tf().getText(), String.valueOf(bookView.getType_cb().getSelectedItem()));
                    JOptionPane.showMessageDialog(bookView.getFrame(), "Done it.", "Update Command", JOptionPane.PLAIN_MESSAGE);
                } catch (NumberFormatException ex){
                    System.out.println("Please Enter Number!!");
                } catch (Exception ex){
                    System.out.println(ex);
                }
            }
        } else if (e.getSource().equals(bookAdd.getInsert_button())){
            try {
                bookModel.addArray(bookAdd.getName_tf().getText(), bookAdd.getPrice_tf().getText(), String.valueOf(bookAdd.getType_cb().getSelectedItem()));
                JOptionPane.showMessageDialog(bookAdd.getFrame(), "Done it.", "Insert Command", JOptionPane.PLAIN_MESSAGE);
                bookAdd.getFrame().setVisible(false);
                bookAdd.clearTextField();
            } catch (NumberFormatException ex){
                System.out.println("Please Enter Number!!");
            } catch (Exception ex){
                System.out.println(ex);
            }
        } else if (e.getSource().equals(bookView.getRight_button())){
            if (bookModel.getPage_now() < BookModel.getCount()){
                bookModel.toRightPage();
                bookView.refreshView(bookModel.getBooks().get(bookModel.getPage_now()).getName(), String.valueOf(bookModel.getBooks().get(bookModel.getPage_now()).getPrice()), bookModel.getBooks().get(bookModel.getPage_now()).getType(), bookModel.getPage_now());
            }
        } else if (e.getSource().equals(bookView.getLeft_button())){
            if (bookModel.getPage_now() > 0){
                bookModel.toLeftPage();
                turntoLeftPage();
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        try(FileInputStream fis = new FileInputStream("Book.data")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            bookModel.setBooks((ArrayList<Book>) ois.readObject());
            BookModel.setCount(bookModel.getBooks().size()-1);
            ois.close();
            fis.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try(FileOutputStream fos = new FileOutputStream("Book.data")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(bookModel.getBooks());
            oos.close();
            fos.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
