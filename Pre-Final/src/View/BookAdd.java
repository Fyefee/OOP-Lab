package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BookAdd {

    private JFrame frame;
    private JPanel all_panel, name_panel, price_panel, type_panel, button_panel;
    private JLabel name_lb, price_lb, type_lb;
    private JTextField name_tf, price_tf;
    private JComboBox type_cb;
    private JButton insert_button;

    public BookAdd(){
        createComponents();
        setComponents();
    }

    public void createComponents(){

        frame = new JFrame();

        all_panel = new JPanel();
        name_panel = new JPanel();
        price_panel = new JPanel();
        type_panel = new JPanel();
        button_panel = new JPanel();

        name_lb = new JLabel("Name");
        price_lb = new JLabel("Price");
        type_lb = new JLabel("Type");

        name_tf = new JTextField();
        price_tf = new JTextField();

        type_cb = new JComboBox();

        insert_button = new JButton("Insert");

    }

    public void setComponents(){

        all_panel.setLayout(new GridLayout(4,1));
        all_panel.add(name_panel);
        all_panel.add(price_panel);
        all_panel.add(type_panel);
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

        insert_button.setFocusable(false);

        button_panel.setLayout(new FlowLayout());
        button_panel.setBorder(new EmptyBorder(0,10,5,5));
        button_panel.add(insert_button);

        frame.getContentPane().add(all_panel);
        frame.setSize(225, 150);
        frame.setLocationRelativeTo(null);
        frame.setLocation(frame.getX()-100, frame.getY()-100);
        frame.setResizable(false);

    }

    public void clearTextField(){
        name_tf.setText("");
        price_tf.setText("");
        type_cb.setSelectedItem("General");
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

    public JComboBox getType_cb() {
        return type_cb;
    }

    public void setType_cb(JComboBox type_cb) {
        this.type_cb = type_cb;
    }

    public JButton getInsert_button() {
        return insert_button;
    }

    public void setInsert_button(JButton insert_button) {
        this.insert_button = insert_button;
    }
}
