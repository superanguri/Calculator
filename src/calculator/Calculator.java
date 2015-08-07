package calculator;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame{

    private static Calculator instance = null;
    
    private JPanel result = new JPanel(null);
    private JTextField input = new JTextField();
    
    private Calculator(){
        
        
        super.setLayout(new BorderLayout(20, 20));
        super.setTitle("Calculator");
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
