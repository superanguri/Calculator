package calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame {

    private int halt;

    private static Calculator instance = null;
    private Dimension fSize = new Dimension(235, 329);

    private JTextField input = new JTextField();

    private JButton[] numbers = new JButton[10];
    private GridLayout grid = new GridLayout(3, 3, 2, 5);
    private JPanel container = new JPanel(grid);

    private JPanel eastCon = new JPanel(new GridLayout(6, 1));
    private JButton[] operations = new JButton[5];

    private JPanel northCon = new JPanel(new GridLayout(1, 1));

    private Calculator() {

        initCenter();
        initEast();
        initNorth();

        //Additions
        super.add(container, BorderLayout.CENTER);
        super.add(eastCon, BorderLayout.EAST);
        super.add(northCon, BorderLayout.NORTH);

        //Frame-Settings
        super.setTitle("Calculator");
        super.setSize(fSize);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        super.setFocusable(true);
        super.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Function.isNumber(e.getKeyChar())) {
                    input.setText(input.getText() + e.getKeyChar());
                } 
                
                else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

                    String text = input.getText();
                    if (text.length() > 0) {
                        String teil = text.substring(0, text.length() - 1);
                        input.setText(teil);
                    }
                }
                //working on it
                else if(keyChar == 42 || keyChar == 43 || keyChar == 45 || keyChar == 47)
                    input.setText(input.getText()+keyChar);
            }
        });

    }

    //Use Sing.-Pattern to proof that there's just one Calculator-Obj
    public static Calculator getInstance() {

        if (instance == null) {
            instance = new Calculator();
        }

        return instance;
    }

    //Fct is here to init. the buttons with the numbers on it
    private void initCenter() {

        for (int i = 1; i < numbers.length; i++) {

            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    input.setText(input.getText() + ((JButton) e.getSource()).getActionCommand());

                }

            });
            numbers[i].setFocusable(false);
            container.add(numbers[i]);

        }

        container.setFocusable(false);

    }

    private void initEast() {

        for (int i = 0; i < operations.length; i++) {

            if (i == 0) {
                operations[i] = new JButton("+");
            }

            if (i == 1) {
                operations[i] = new JButton("-");
            }

            if (i == 2) {
                operations[i] = new JButton("*");
            }

            if (i == 3) {
                operations[i] = new JButton("/");
            }

            if (i == 4) {
                operations[i] = new JButton("=");
            }

            operations[i].addActionListener(e -> input.setText(input.getText() + ((JButton) e.getSource()).getActionCommand()));

            eastCon.add(operations[i]);
            operations[i].setFocusable(false);
        }

        numbers[0] = new JButton("0");
        numbers[0].addActionListener(e -> input.setText(input.getText() + "0"));

        eastCon.add(numbers[0]);
    }

    private void initNorth() {

        input.setBounds(0, 0, (int) fSize.getWidth(), 25);
        input.setEditable(false);
        input.setFocusable(false);
        northCon.add(input);
        northCon.setFocusable(false);
    }

}
