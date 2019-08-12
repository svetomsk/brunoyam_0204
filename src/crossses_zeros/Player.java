package crossses_zeros;

import java.awt.*;

public abstract class Player {
    private String name;
    private int sign;

    public Player(String name, int sign) {
        this.name = name;
        this.sign = sign;
    }

    public abstract Point makeTurn(Field field);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }
}
