package gui;

import java.awt.*;

public class JCanvas extends Canvas {
    private int x;
    private int y;
    private final int R = 50;

    public void drawCircle(int dx, int dy) {
        this.x += dx;
        this.y += dy;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.fillOval(x - R/2, y - R/2, R, R);
    }
}
