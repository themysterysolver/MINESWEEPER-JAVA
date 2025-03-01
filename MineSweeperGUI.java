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

        JPanel ceneterPanel=new JPanel();
        ceneterPanel.setLayout(new GridLayout(3,1));
        JButton easy=new JButton("EASY\n9x9");
        JButton medium=new JButton("MEDIUM\n16*16");
        JButton hard=new JButton("HARD\n30x30");
        ceneterPanel.add(easy);
        ceneterPanel.add(medium);
        ceneterPanel.add(hard);

        add(ceneterPanel,SwingConstants.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
