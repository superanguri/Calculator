package calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame{

    private static Calculator instance = null;
    private Dimension fSize = new Dimension(235, 329);
    
    private JPanel result = new JPanel(null);
    private JTextField input = new JTextField();
    
    private Calculator(){
        
        
        super.setLayout(new BorderLayout(20, 20));
        super.setTitle("Calculator");
        super.setSize(fSize);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
        
    }
    
    public static Calculator getInstance(){
        
        if(instance == null)
            instance = new Calculator();
        
        return instance;
    }
}
