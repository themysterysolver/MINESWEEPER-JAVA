import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MineSweeperGUI extends JFrame {
    public MineSweeperGUI(){
        initialize_homepage();
    }

    private void initialize_homepage() {
        setTitle("Minesweeper");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        JLabel header=new JLabel("Minesweeper");
        header.setHorizontalAlignment(SwingConstants.CENTER);
        add(header,BorderLayout.NORTH);

        JPanel ceneterPanel=new JPanel();
        ceneterPanel.setLayout(new GridLayout(3,1));
        JButton easy=new JButton("<html><center>EASY<br>9x9</center></html>");
        JButton medium=new JButton("<html><center>MEDIUM<br>16x16</center></html>");
        JButton hard=new JButton("<html><center>HARD<br>30x30</center></html>");
        ceneterPanel.add(easy);
        ceneterPanel.add(medium);
        ceneterPanel.add(hard);

        add(ceneterPanel,BorderLayout.CENTER);

        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameBoardGUI(9,9,"EASY");
                dispose();
            }
        });

        medium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameBoardGUI(16,16,"MEDIUM");
                dispose();
            }
        });
        hard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameBoardGUI(30,30,"HARD");
                dispose();
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
