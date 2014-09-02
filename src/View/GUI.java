package View;

import Controller.FileReaderClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Данный класс предназначен для пользовательского интерфейса
 */

public class GUI {

    private static JFrame frame;
    private static JLabel label, isGuessed, label2;
    private static JPanel mainPanel, buttonPanel;
    private static JButton exitButton, checkButton, nextWordButton;
    private static JTextField userInput, shuffledWordField;


    public GUI() {

        frame = new JFrame("Anagram");

        label = new JLabel("Задуманное слово: ");
        label2 = new JLabel("Ваш вариант:");

        shuffledWordField = new JTextField(20);
        shuffledWordField.setText("Для начала нажмите \"Следующее\"");
        shuffledWordField.setEditable(false);

        isGuessed = new JLabel("");

        mainPanel = new JPanel();
        buttonPanel = new JPanel();

        userInput = new JTextField(20);

        exitButton = new JButton("Выход");
        checkButton = new JButton("Проверка");
        nextWordButton = new JButton("Следующее");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setSize(330, 200);
        frame.setLocationRelativeTo(null);
    }

    public void go() {

        mainPanel.add(label);
        mainPanel.add(shuffledWordField);

        buttonPanel.add(checkButton);
        buttonPanel.add(exitButton);
        buttonPanel.add(nextWordButton);


        mainPanel.add(label2);
        mainPanel.add(userInput);
        mainPanel.add(isGuessed);

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);

        FileReaderClass.fileReader();

        checkButton.addActionListener(new Controller.Listeners.CheckButtonListener());

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        nextWordButton.addActionListener(new Controller.Listeners.NextButtonListener());
    }

    //получение версий пользователя
    public static String getUserInput() {
        return userInput.getText();
    }

    // уведомление игрока о правильности/неправильности
    public static void setIsGuessed(String s) {
        GUI.isGuessed.setText(s);
    }
}
