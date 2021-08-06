package test;



import java.awt.Color;

import java.awt.Dimension;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;



import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.SwingUtilities;



public class guitest extends JFrame {



    private JPanel panel1 = new JPanel();



    private JPanel panel2 = new JPanel();



    public guitest() {

        this.panel1.setPreferredSize(new Dimension(150, 150));

        this.panel1.setBackground(Color.RED);

        this.panel2.setPreferredSize(new Dimension(50, 50));

        this.panel2.setBackground(Color.BLUE);

        this.panel1.add(this.panel2);

        this.getContentPane().add(this.panel1);



        this.panel1.addMouseListener(new MouseAdapter() {

            @Override

            public void mousePressed(MouseEvent e) {

                super.mousePressed(e);

                System.out.println("panel1 mousePressed");

                MouseEvent e1 = SwingUtilities.convertMouseEvent(panel1, e, panel2);

                panel2.dispatchEvent(e1);

            }

        });

        this.panel2.addMouseListener(new MouseAdapter() {

            @Override

            public void mousePressed(MouseEvent e) {

                super.mousePressed(e);

                System.out.println("panel2 mousePressed");

            }

        });

    }



    /**

     * @param args

     */

    public static void main(String[] args) {

        guitest te = new guitest();

        te.setVisible(true);

        te.pack();

        te.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



}

