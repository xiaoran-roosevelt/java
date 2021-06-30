package view;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextHitInfo;

public class HomePanel extends JPanel {
    private JButton htomButton;
    private JButton htohButton;
    private JButton reviewButton;

    public HomePanel() {
        setLayout(null);
        setBackground(new Color(0xFF, 0xF0, 0xF5));
        setLocation(650, 0);
        setSize(320, 700);

        htohButton = new JButton("人人对战");
        htohButton.setBounds(0, 200, 100, 40);
        htohButton.setBackground(Color.white);

        htomButton = new JButton("人机对战");
        htomButton.setBounds(0, 300, 100, 40);
        htomButton.setBackground(Color.white);

        reviewButton = new JButton("复        盘");
        reviewButton.setBounds(0, 400, 100, 40);
        reviewButton.setBackground(Color.white);

        this.add(htohButton);
        this.add(htomButton);
        this.add(reviewButton);
        setVisible(false);
    }
}
