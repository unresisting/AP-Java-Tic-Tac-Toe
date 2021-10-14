import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class TicTacToe extends JFrame implements ActionListener {
  JButton piece;
  Border blackline = BorderFactory.createLineBorder(Color.black);
  JPanel header;
  andyButton resetGame;
  JButton exitGame;
  JButton userTurn;
  Integer[] xPieces = new Integer[9];
  Integer[] yPieces = new Integer[9];
  boolean isXMove = true;

  public TicTacToe() {
    createGui();
  }

  public void createGui() {
    Container contentPane = getContentPane();
    setSize(450,450);
    setTitle("ANDY'S TICTACTOE BOARD!");
    setLayout(new BorderLayout());
    header = new JPanel();
    resetGame = new andyButton("RESET GAME", this, "Reset");
    userTurn = new andyButton(String.format("USER %s TURN", (isXMove == true ? "X" : "Y")));
    exitGame = new andyButton("EXIT", this, "Exit");
    header.add(resetGame);header.add(userTurn);header.add(exitGame);
    contentPane.add(header, BorderLayout.NORTH);

    JPanel gamePane = new JPanel();
    gamePane.setLayout(new GridLayout(3, 3));
    contentPane.add(gamePane, BorderLayout.CENTER);

    for (int i = 0; i < 9; i++) {
      piece = new JButton();
      piece.setBackground(Color.white);
      piece.setBorder(blackline);
      piece.addActionListener(this);
      piece.setActionCommand("Piece" + String.valueOf(i));
      gamePane.add(piece);
    }
  }

  public void actionPerformed(ActionEvent event) {
    if (event.getActionCommand().equals("Exit")) {
      System.exit(0);
    }
    if (event.getActionCommand().equals("Reset")) {
      System.exit(0);
    }

    if(event.getActionCommand().substring(0,5).equals("Piece")){
       int pieceIndex = Integer.parseInt(event.getActionCommand().split("Piece")[1]);
       if(Arrays.asList(xPieces).indexOf(pieceIndex) == -1 && Arrays.asList(yPieces).indexOf(pieceIndex) == -1){
         if(isXMove == true){
           xPieces[pieceIndex] = pieceIndex;
           isXMove = false;
           checkWin.checkBoard(xPieces, yPieces);
         } else {
           yPieces[pieceIndex] = pieceIndex;
           checkWin.checkBoard(xPieces, yPieces);
         }
       } else {
         System.out.print("Invalid move.");
       }
    }
  }
}
