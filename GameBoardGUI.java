import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
                buttons[i][j].setPreferredSize(new Dimension(cellSize,cellSize));
                buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY));

                mainPanel.add(buttons[i][j]);
            }
        }
        add(mainPanel,BorderLayout.CENTER);

        SwingUtilities.invokeLater(() -> updateBoard());
        System.out.println("CHECKPOINT: Board got updated!");

        setLocationRelativeTo(null);
        setVisible(true);

    }

    private void updateBoard() {
        String[][] board=game.getBoard();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                String cellValue=board[i][j];
                buttons[i][j].setIcon(getImageIcon(cellValue,buttons[i][j]));
                buttons[i][j].setContentAreaFilled(false);
            }
        }
    }
    public ImageIcon getImageIcon(String val, JButton button){
        String path="src/"+switch(val){ //Enhanced Switch in Java 12+
            case "B"->"0.png"; //blank
            case "1"->"1.png";
            case "2"->"2.png";
            case "3"->"3.png";
            case "4"->"4.png";
            case "5"->"5.png";
            case "6"->"6.png";
            case "7"->"7.png";
            case "8"->"8.png";
            //case "M"->"9.png"; //MINE
            case "F"->"11.png"; //for Flag
            default -> "10.png"; //unrevealed mine
        };
        return new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(button.getWidth(),button.getHeight(),Image.SCALE_SMOOTH));
    }
}
