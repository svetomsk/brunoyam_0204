package gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private int x;
    private int y;

    public MainFrame(int width, int height, String title) {
        super(title);
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
//        setResizable(false);
        init();
    }

    private void init() {
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.setPreferredSize(new Dimension(400, 70));
        topPanel.setBackground(Color.WHITE);
        JLabel text = new JLabel("Here is some text value");
        text.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(4)));
        text.setPreferredSize(new Dimension(getWidth() / 3, 50));

        JButton ok = new JButton("OK");
        ok.setPreferredSize(new Dimension(getWidth() / 4, 50));


        topPanel.add(ok);
        topPanel.add(text);

        add(topPanel);
        int rows = 3;
        int columns = 4;
        JPanel bottomPanel = new JPanel(new GridLayout(rows, columns));
        bottomPanel.setPreferredSize(new Dimension(500, 300));
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                JLabel label = new JLabel("" + (i + j));
                label.setPreferredSize(new Dimension(70, 70));
                bottomPanel.add(label);
            }
        }

        add(bottomPanel);
    }

    public void drawCircle(int dx, int dy) {
        this.x += dx;
        this.y += dy;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
//        g.setColor(Color.WHITE);
//        g.fillRect(0, 0, getWidth(), getHeight());
//
//        g.setColor(Color.RED);
//        g.drawLine(0, 0, getWidth(), getHeight());
//        g.setColor(Color.BLUE);
//        g.drawLine(0, getHeight(), getWidth(), 0);
//
//        g.setColor(Color.YELLOW);
//        g.fillOval(x - 25, y - 25, 50, 50);

    }
}
