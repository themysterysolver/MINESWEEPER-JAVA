import javax.swing.*;
import java.awt.*;

public class GameBoardGUI extends JFrame {
    public GameBoardGUI(int row,int col,String title){
        setTitle("MINESWEEPER:"+title);
        setSize(row*col*5,row*col*5);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,1));


        setLocationRelativeTo(null);
        setVisible(true);

    }
}
