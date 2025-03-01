import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoardGUI extends JFrame {
    int cellSize;
    public GameBoardGUI(int row,int col,String title){
        cellSize=20;

        setTitle("MINESWEEPER:"+title);
        setSize(30*cellSize,30*cellSize+10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        JPanel topPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton previous=new JButton("⬅\uFE0F");
        topPanel.add(previous);

        add(topPanel,BorderLayout.NORTH);

        previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MineSweeperGUI();
                dispose();
            }
        });







        setLocationRelativeTo(null);
        setVisible(true);

    }
}
