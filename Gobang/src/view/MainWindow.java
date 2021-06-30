package view;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private Dimension dimension;
    public MainWindow() throws HeadlessException {
        this.setTitle("Îå×ÓÆå");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dimension=new Dimension(960,700);
        this.setSize(dimension);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
    }
}
