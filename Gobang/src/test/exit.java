package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * called another JFrame close this JFrame write by Jimmy.li time:2016/4/6 22:55
 */

public class exit {

    private static final int WIDTH = 300;

    private static final int HEIGHT = 200;

    public exit() {
        // 普通按钮控件
        final JFrame jf = new JFrame("exit");
        jf.setSize(WIDTH, HEIGHT);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);
        JPanel contentPane = new JPanel();
        jf.setContentPane(contentPane);

        // 创建两个按钮并添加到内容面板

        JButton close1 = new JButton("关闭");
        contentPane.add(close1);

        close1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                // System.exit(0);
                jf.dispose();
            }
        });
    }

    public static void main(String[] args)

    {
        new exit();
    }

}