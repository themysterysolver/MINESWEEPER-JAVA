import javax.swing.*;
import java.awt.*;

public class MineSweeperGUI extends JFrame {
    public MineSweeperGUI(){
        initialize_homepage();
    }

    private void initialize_homepage() {
        setTitle("Minesweeper");
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel header=new JLabel("Minesweeper");
        header.setHorizontalAlignment(SwingConstants.CENTER);
        add(header,BorderLayout.NORTH);


        setLocationRelativeTo(null);
        setVisible(true);
    }
}
