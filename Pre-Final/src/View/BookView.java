package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BookView {

    private JFrame frame;
    private JPanel all_panel, name_panel, price_panel, type_panel, arrow_panel, button_panel;
    private JLabel name_lb, price_lb, type_lb;
    private JTextField name_tf, price_tf, page_tf;
    private JComboBox type_cb;
    private JButton left_button, right_button, add_button, update_button, delete_button;

    public BookView(){
        createComponents();
        setComponents();
    }

    public void createComponents(){

        frame = new JFrame();

        all_panel = new JPanel();
        name_panel = new JPanel();
        price_panel = new JPanel();
        type_panel = new JPanel();
        arrow_panel = new JPanel();
        button_panel = new JPanel();

        name_lb = new JLabel("Name");
        price_lb = new JLabel("Price");
        type_lb = new JLabel("Type");

        name_tf = new JTextField();
        price_tf = new JTextField();
        page_tf = new JTextField("0", 5);

        type_cb = new JComboBox();

        left_button = new JButton("<<<");
        right_button = new JButton(">>>");
        add_button = new JButton("Add");
        update_button = new JButton("Update");
        delete_button = new JButton("Delete");

    }

    public void setComponents(){

        all_panel.setLayout(new GridLayout(5,1));
        all_panel.add(name_panel);
        all_panel.add(price_panel);
        all_panel.add(type_panel);
        all_panel.add(arrow_panel);
        all_panel.add(button_panel);

        name_panel.setLayout(new GridLayout(1, 2));
        name_panel.setBorder(new EmptyBorder(5,10,0,5));
        name_panel.add(name_lb);
        name_panel.add(name_tf);

        price_panel.setLayout(new GridLayout(1, 2));
        price_panel.setBorder(new EmptyBorder(5,10,0,5));
        price_panel.add(price_lb);
        price_panel.add(price_tf);

        type_cb.setFocusable(false);
        type_cb.addItem("General");
        type_cb.addItem("Computer");
        type_cb.addItem("Math&Sci");
        type_cb.addItem("Photo");

        type_panel.setLayout(new GridLayout(1, 2));
        type_panel.setBorder(new EmptyBorder(5,10,0,5));
        type_panel.add(type_lb);
        type_panel.add(type_cb);

        left_button.setFocusable(false);
        right_button.setFocusable(false);
        page_tf.setEnabled(false);
        
        arrow_panel.setLayout(new FlowLayout());
        arrow_panel.setBorder(new EmptyBorder(5,0,-20,0));
        arrow_panel.add(left_button);
        arrow_panel.add(page_tf);
        arrow_panel.add(right_button);

        add_button.setFocusable(false);
        update_button.setFocusable(false);
        delete_button.setFocusable(false);

        button_panel.setLayout(new FlowLayout());
        button_panel.add(add_button);
        button_panel.add(update_button);
        button_panel.add(delete_button);

        frame.getContentPane().add(all_panel);
        frame.setSize(225, 225);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void refreshView(String name, String price, String type, int page_now){
        name_tf.setText(name);
        price_tf.setText(price);
        type_cb.setSelectedItem(type);
        page_tf.setText(String.valueOf(page_now));
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTextField getName_tf() {
        return name_tf;
    }

    public void setName_tf(JTextField name_tf) {
        this.name_tf = name_tf;
    }

    public JTextField getPrice_tf() {
        return price_tf;
    }

    public void setPrice_tf(JTextField price_tf) {
        this.price_tf = price_tf;
    }

    public JTextField getPage_tf() {
        return page_tf;
    }

    public void setPage_tf(JTextField page_tf) {
        this.page_tf = page_tf;
    }

    public JComboBox getType_cb() {
        return type_cb;
    }

    public void setType_cb(JComboBox type_cb) {
        this.type_cb = type_cb;
    }

    public JButton getLeft_button() {
        return left_button;
    }

    public void setLeft_button(JButton left_button) {
        this.left_button = left_button;
    }

    public JButton getRight_button() {
        return right_button;
    }

    public void setRight_button(JButton right_button) {
        this.right_button = right_button;
    }

    public JButton getAdd_button() {
        return add_button;
    }

    public void setAdd_button(JButton add_button) {
        this.add_button = add_button;
    }

    public JButton getUpdate_button() {
        return update_button;
    }

    public void setUpdate_button(JButton update_button) {
        this.update_button = update_button;
    }

    public JButton getDelete_button() {
        return delete_button;
    }

    public void setDelete_button(JButton delete_button) {
        this.delete_button = delete_button;
    }
}
