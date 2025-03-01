import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameBoardGUI extends JFrame {
    int cellSize;
    GameLogic game;
    JButton[][] buttons;
    int row,col;
    String theTitle;
    JLabel message;
    JButton restart;
    public GameBoardGUI(int row,int col,String title){
        cellSize=20;
        this.row=row;
        this.col=col;
        this.theTitle=title;
        restart=new JButton("");
        restart.setContentAreaFilled(false);
        restart.setFocusPainted(false);
        restart.setBorderPainted(false);

        setTitle("MINESWEEPER:"+title);
        setSize(30*cellSize,30*cellSize+10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        JPanel topPanel=new JPanel(new BorderLayout());
        topPanel.add(restart,BorderLayout.WEST);

        message=new JLabel("<html><center>Minesweeper</center></html>");
        topPanel.add(message,BorderLayout.CENTER);

        JButton previous=new JButton("⬅\uFE0F");
        topPanel.add(previous,BorderLayout.EAST);

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

                int x=i,y=j;
                buttons[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if(SwingUtilities.isRightMouseButton(e)){
                            game.flagIt(x,y);
                            updateBoard(false);
                        }else{
                            if(game.revealCell(x,y)){
                                updateBoard(false);
                            }else{
                                updateBoard(true);
                                endGame();
                            }
                        }
                        if(haveWon()){
                            updateBoard(false);
                            makeWin();
                            return;
                        }
                    }
                });
                mainPanel.add(buttons[i][j]);
            }
        }
        add(mainPanel,BorderLayout.CENTER);

        SwingUtilities.invokeLater(() -> updateBoard(false));
        //System.out.println("CHECKPOINT: Board got updated!");

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void makeWin() {
        removeEvents();
        message.setText("You have won✨!");
        JOptionPane.showMessageDialog(this,"<html><div " +
                "style='text-align:center;" +
                "font-size:16px; color:#6A1B9A;'><b>CONGRATULATIONS!</b><br></div>🎉" +
                "You have won the game!🏆</html>");
        makeRestartAppear();
    }

    private boolean haveWon() {
        //System.out.println(game.fetchSafe());
        if(game.fetchSafe()==0){
            return true;
        }
        return false;
    }

    private void updateBoard(Boolean end) {
        String[][] board=game.getBoard();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                String cellValue=board[i][j];
                buttons[i][j].setIcon(getImageIcon(cellValue, buttons[i][j], end));
                buttons[i][j].setContentAreaFilled(false);
            }
        }
    }

    public ImageIcon getImageIcon(String val, JButton button,Boolean end){
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
        if(end && val.equals("M")){
            path="src/9.png";
        }
        return new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(button.getWidth(),button.getHeight(),Image.SCALE_SMOOTH));
    }

    public void endGame(){
        removeEvents();
        message.setText("<html><center>U LANDED IN A MINE💣!</center></html>");
        makeRestartAppear();
    }

    private void makeRestartAppear() {
        restart.setText("Restart");
        restart.setFocusPainted(true);
        restart.setBorderPainted(true);
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameBoardGUI(row,col,theTitle);
            }
        });
    }

    private void removeEvents() {
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                for(MouseListener ml:buttons[i][j].getMouseListeners()){
                    buttons[i][j].removeMouseListener(ml);
                }
            }
        }
    }
}
