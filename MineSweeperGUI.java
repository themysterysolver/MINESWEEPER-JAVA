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

        JLabel N=new JLabel("NORTH");
        N.setBackground(new Color(70, 239, 11));
        add(N,BorderLayout.NORTH);
        N.setOpaque(true);
        N.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel E=new JLabel("EAST");
        E.setBackground(new Color(214, 5, 5));
        add(E,BorderLayout.EAST);
        E.setOpaque(true);
        E.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel W=new JLabel("WEST");
        W.setBackground(new Color(4, 223, 132));
        add(W,BorderLayout.WEST);
        W.setOpaque(true);
        W.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel S=new JLabel("SOUTH");
        S.setBackground(new Color(246, 87, 2));
        add(S,BorderLayout.SOUTH);
        S.setOpaque(true);
        S.setHorizontalAlignment(SwingConstants.CENTER);


        setVisible(true);
    }
}
