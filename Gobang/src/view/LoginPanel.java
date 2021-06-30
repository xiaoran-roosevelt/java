package view;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    private JLabel accLable;
    private JLabel pwdLable;
    private JTextField accJtf;
    private JTextField pwdJtf;
    private JButton logJb;
    public LoginPanel() {
        this.setSize(320,700);
        this.setBackground(Color.white);
        this.setLocation(640,0);
        this.setLayout(null);
        accLable=new JLabel("ÕËºÅ");
        pwdLable=new JLabel("ÃÜÂë");
        accJtf=new JTextField(20);
        pwdJtf=new JTextField(20);
        logJb=new JButton("µÇÂ¼");
        this.add(accLable);
        this.add(accJtf);
        this.add(pwdLable);
        this.add(pwdJtf);
        this.add(logJb);
    }
}
