import javax.swing.*;
import java.awt.*;

public class andyButton extends JButton{  
    public andyButton(String initializer, TicTacToe eventListener, String actionCommand){
       super(initializer);
       this.setActionCommand(actionCommand);
       this.addActionListener(eventListener);
    }

    public andyButton(String initializer){
       super(initializer);
    }
  }
