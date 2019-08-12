package gui;

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class UIExample {
    public static void main(String[] args) {
//        JFrame frame = new JFrame("My first window");
//        frame.setSize(400, 400);
//        frame.setLocationRelativeTo(null);
//        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        frame.setLayout(null);
//        frame.setResizable(false);
        MainFrame frame = new MainFrame(700, 700, "Hello world!");
//        frame.setUndecorated(true);
        JButton button = new JButton("Push");
        button.setSize(80, 80);
        button.setBounds(100, 150, 80, 80);
//        frame.add(button);

        button.addActionListener(e -> System.out.println("Button clicked at " + e.getWhen()));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("mouseClicked");
//                System.out.println(e.getX());
//                System.out.println(e.getY());
//                System.out.println("----");
//                System.out.println(e.getXOnScreen());
//                System.out.println(e.getYOnScreen());
//                System.out.println("----");
//                System.out.println(e.getButton());
//                System.out.println("----");

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Random r = new Random();
//                button.setBounds(r.nextInt(400), r.nextInt(400), 70, 70);
            }
        });

        JCanvas canvas = new JCanvas();
        canvas.setSize(frame.getWidth(), frame.getHeight());
//        frame.add(canvas);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("keyTyped");
                System.out.println(e.getKeyChar());
                System.out.println(e.getKeyCode());
                System.out.println(e.getExtendedKeyCode());
                System.out.println("----");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("keyPressed");
                int x = button.getX();
                int y = button.getY();
                switch (e.getExtendedKeyCode()) {
                    case KeyEvent.VK_LEFT: {
                        button.setBounds(x - 10, y, 70, 70);
                        canvas.drawCircle(-10, 0);
                        break;
                    }
                    case KeyEvent.VK_RIGHT: {
                        button.setBounds(x + 10, y, 70, 70);
                        canvas.drawCircle(10, 0);
                        break;
                    }
                    case KeyEvent.VK_UP: {
                        button.setBounds(x, y - 10, 70, 70);
                        canvas.drawCircle(0, -10);
                        break;
                    }
                    case KeyEvent.VK_DOWN: {
                        button.setBounds(x, y + 10, 70, 70);
                        canvas.drawCircle(0, 10);
                        break;
                    }
                }
            }
        });
        frame.setFocusable(true);

        frame.setVisible(true);
    }
}
