package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guitest extends JFrame {
    private static final long serialVersionUID = 1L;

    public guitest() {
        // 普通按钮控件
        JFrame jf = new JFrame("main");
        Toolkit tk = this.getToolkit();// 得到窗口工具条
        int width = 650;
        int height = 500;
        Dimension dm = tk.getScreenSize();
        jf.setSize(300, 200);// 设置程序的大小
        jf.setLocation((int) (dm.getWidth() - width) / 2,
                (int) (dm.getHeight() - height) / 2);// 显示在屏幕中央
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);
        JPanel contentPane = new JPanel();
        jf.setContentPane(contentPane);

        // 创建两个按钮，并且将按钮添加到内容面板中

        JButton another = new JButton("另起页面");

        JButton close = new JButton("关闭");

        contentPane.add(another);

        contentPane.add(close);

        another.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                new exit();
            }
        });

        close.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
//                System.exit(0);
                jf.dispose();
            }
        });
    }

    public static void main(String[] args)

    {
        new guitest();

    }
}
