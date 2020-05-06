package exam2;

import javafx.event.EventHandler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Collection;


public class CompareHandler implements EventHandler<ActionEvent> {
    Label label1;
    private TextField num1field,num2field;
    @Override
    public void handle(ActionEvent event) {
        String tf1 = num1field.getText();
        String tf2 = num2field.getText();
        try{
            int n1 = Integer.valueOf(tf1);
            int n2 = Integer.valueOf(tf2);
            if(n2 == 0){
                label1.setText("The number at the bottom should not be zero");
                return;
            }
            if(n1%n2 ==0) label1.setText("It is divisible");
            else label1.setText("It is not divisible");

        }catch (NumberFormatException e){
              label1.setText("Please enter integers");
        }
    }
}
