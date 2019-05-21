package swing_example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    private int coordX;
    private int coordY;

    public MainFrame() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(new Dimension(400, 400));
        setTitle("First JFrame!");
        setLayout(null);
        coordX = 0;
        coordY = 0;

        initFrame();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(0, 0, 400, 400);
        g.setColor(Color.YELLOW);
        g.drawString("Hello world!", 100, 200);
        g.fillOval(300, 300, 100, 100);
    }

    private void initFrame() {
        JButton button = new JButton("Hello1!");
//        button.setSize(new Dimension(70, 70));
        button.setBounds(coordX, coordY, 70, 70);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button pressed");
            }
        });

        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("x = " + e.getX());
                System.out.println("y = " + e.getY());
                System.out.println("button = " + e.getButton());
                System.out.println("x_screen = " + e.getXOnScreen());
                System.out.println("y_screen = " + e.getYOnScreen());
                System.out.println("Mouse clicked");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Mouse pressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Mouse released");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                System.out.println("Mouse entered");
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                System.out.println("Mouse exited");
            }
        });

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("keyTyped");
                System.out.println(e.getKeyChar());
                System.out.println(e.getKeyCode());
                System.out.println(KeyEvent.VK_SPACE);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    coordX -= 5;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    coordX += 5;
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    coordY -= 5;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    coordY += 5;
                }
                button.setBounds(coordX, coordY, 70, 70);
                invalidate();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyReleased");
            }
        });

//        JButton button1 = new JButton("Hello2!");
//        button.setSize(new Dimension(70, 70));
////        button.setBounds(100, 100, 70, 70);
//
//                JButton button2 = new JButton("Hello3!");
//        button.setSize(new Dimension(70, 70));
////        button.setBounds(100, 100, 70, 70);
//
//
//        JButton button3 = new JButton("Hello4!");
//        button.setSize(new Dimension(70, 70));
        add(button);
//        add(button1, 1);
//        add(button2, 2);
//        add(button3, 3);
    }
}
