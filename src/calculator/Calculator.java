package calculator;

import javax.swing.JFrame;

public class Calculator extends JFrame{

    private static Calculator instance = null;
    
    private Calculator(){
        
        
    }
    
    public static Calculator getInstance(){
        
        if(instance == null)
            instance = new Calculator();
        
        return instance;
    }
}
