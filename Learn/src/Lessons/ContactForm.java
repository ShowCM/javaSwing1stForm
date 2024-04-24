package Lessons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {

    JTextField name_field;
    JTextField telegramTag;
    JRadioButton male;
    JRadioButton female;
    JCheckBox check;

    public ContactForm() {
        super("Contact Form");
        super.setBounds(100, 100, 500, 250);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(5, 2, 2, 10));

        JLabel name = new JLabel("Введите имя");
        name_field = new JTextField("", 1);

        JLabel telegram = new JLabel("Введите тег");
        telegramTag = new JTextField("@", 1);

        container.add(name);
        container.add(name_field);
        container.add(telegram);
        container.add(telegramTag);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        check = new JCheckBox("Согласен отдать квартиру?", false);
        JButton send_button = new JButton("Согласен");

        male.setSelected(true);
        container.add(male);
        container.add(female);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(male);
        buttonGroup.add(female);

        container.add(check);
        container.add(send_button);

        send_button.addActionListener(new ButtonEventManager());
    }

    class ButtonEventManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
             String name = name_field.getText();
             String telegram = telegramTag.getText();

             String isMale = "Male";
             if (!male.isSelected()) {
                 isMale = "Female";
             }

             boolean checkBox = check.isSelected();

             JOptionPane.showMessageDialog(null,
               "Ваш телеграм : " + telegram + "\nВаш пол: " + isMale +
               "\nВы согласны? " + checkBox, "Zdarova " + name,
               JOptionPane.PLAIN_MESSAGE);
        }
    }
}
