package view;

import model.Logcheck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private Dimension dimension;
//    登录界面
    private LoginPanel loginPanel;
//    主页面
    private HomePanel homePanel;
    public void initMainWindow(){
        this.setTitle("五子棋");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dimension=new Dimension(960,700);
        this.setSize(dimension);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
//        登陆界面
        loginPanel=new LoginPanel();
        this.add(loginPanel);
//        主页面
        homePanel=new HomePanel();
        this.add(homePanel);

        this.loginPanel.getLogJb().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String acc=loginPanel.getAccJtf().getText();
                String pwd=loginPanel.getPwdJtf().getText();
                Logcheck logcheck=new Logcheck();
                if (logcheck.check(acc,pwd)){
                    loginPanel.setVisible(false);
                    homePanel.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"","密码错误",JOptionPane.ERROR_MESSAGE);
                    System.out.println("密码错误！");
                }
            }
        });

        this.setVisible(true);
    }
    public MainWindow() throws HeadlessException {
        initMainWindow();
    }
}
