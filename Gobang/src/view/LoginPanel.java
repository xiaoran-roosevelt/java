package view;

import javax.swing.*;
import java.awt.*;
public class LoginPanel extends JPanel {
    private JLabel accLable;
    private JLabel pwdLable;
    private JTextField accJtf;

    public JLabel getAccLable() {
        return accLable;
    }

    public JLabel getPwdLable() {
        return pwdLable;
    }

    public JTextField getAccJtf() {
        return accJtf;
    }

    public JPasswordField getPwdJtf() {
        return pwdJtf;
    }

    public JButton getLogJb() {
        return logJb;
    }

    private JPasswordField pwdJtf;
    private JButton logJb;
    public void initLoginPanel(){
        this.setSize(320,700);
        this.setBackground(Color.white);
        this.setLocation(640,0);
        this.setLayout(null);
        Font font =new Font("ËÎÌå",Font.BOLD,14);

        accLable=new JLabel("ÕËºÅ");
        accLable.setBounds(40,160,60,40);
        accLable.setFont(font);

        accJtf=new JTextField(20);
        accJtf.setBounds(120,160,120,40);
        accJtf.setFont(font);

        pwdLable=new JLabel("ÃÜÂë");
        pwdLable.setBounds(40,300,60,40);
        pwdLable.setFont(font);

        pwdJtf=new JPasswordField(20);
        pwdJtf.setBounds(120,300,120,40);
        pwdJtf.setFont(font);

        logJb=new JButton("µÇÂ¼");
        logJb.setBounds(130,380,80,40);
        logJb.setFont(font);
        logJb.setBackground(Color.CYAN);

        this.add(accLable);
        this.add(accJtf);
        this.add(pwdLable);
        this.add(pwdJtf);
        this.add(logJb);
        System.out.println(accLable.getSize());
        this.setVisible(true);
    }
    public LoginPanel() {
        initLoginPanel();
    }
}
