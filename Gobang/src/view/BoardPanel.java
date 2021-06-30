package view;

import model.ChessGame;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {
    private ChessGame chessGame;
    private int i;
    private int j;
    public BoardPanel(ChessGame chessGame1) {
        setBackground(new Color(0xDE, 0xB8, 0x87));
        chessGame=chessGame1;
    }
    public void setChessGame(ChessGame chessGame1) {
        this.chessGame=chessGame1;
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension dimension=getSize();
        int num=dimension.height/16;
        for (int i = 0; i < 15; i++) {
            g.drawLine(num, num+i*num,15*num, num+i*num);
        }
        for (int i = 0; i < 15; i++) {
            g.drawLine(num+i*num, num, num+i*num, 15*num);
        }
        int num2=num/10;
        g.fillOval(4*num-num2,4*num-num2,2*num2,num2*2);
        g.fillOval(12*num-num2,4*num-num2,2*num2,num2*2);
        g.fillOval(4*num-num2,12*num-num2,2*num2,num2*2);
        g.fillOval(12*num-num2,12*num-num2,2*num2,num2*2);
        g.fillOval(8*num-num2,8*num-num2,2*num2,num2*2);
        int [] in;
        int r=num*2/5;
        for (int i = 0; i <chessGame.getChessStack().length; i++) {
            in=chessGame.getChessStack().Getelem(i);
            if (in[2]==-1) {
                g.setColor(Color.BLACK);
            }else {
                g.setColor(Color.WHITE);
            }
            g.fillOval((in[1]-3)*num-r, (in[0]-3)*num-r, 2*r, 2*r);
        }
        if (chessGame.getChessStack().length!=0) {
            in=chessGame.getChessStack().Getelem(chessGame.getChessStack().length-1);
            g.setColor(Color.RED);
            g.fillOval((in[1]-3)*num-r/4, (in[0]-3)*num-r/4, r/2, r/2);
        }
    }
}
