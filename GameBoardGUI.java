import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoardGUI extends JFrame {
    int cellSize;
    GameLogic game;
    JButton[][] buttons;
    int row,col;

    public GameBoardGUI(int row,int col,String title){
        cellSize=20;
        this.row=row;
        this.col=col;

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

        /*----------------------------------MAIN PART!----------------------------------------*/
        JPanel mainPanel=new JPanel(new GridLayout(row,col));
        this.buttons=new JButton[row][col];
        this.game=new GameLogic(row,col);

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                buttons[i][j]=new JButton();
                buttons[i][j].setBackground(new Color(115, 110, 110));
                mainPanel.add(buttons[i][j]);
            }
        }
        add(mainPanel);
        updateBoard();

        setLocationRelativeTo(null);
        setVisible(true);

    }

    private void updateBoard() {

    }
}
