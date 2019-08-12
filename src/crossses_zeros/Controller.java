package crossses_zeros;

import java.awt.*;

public class Controller {
    /*
        распечатать поле
        попросить ввести координаты
        получить введенные координаты
        установить значение в ячейку
        проверить поле на выигрыш
        установить игрока с ноликом

        распечатать поле
        попросить ввести координаты
        получить введенные координаты
        установить значение в ячейку
        проверить поле на выигрыш
        установить игрока с крестиком
    */

    public void play() {
        Field field = new Field();
        Player cross = new HumanPlayer("X", Field.CROSS);
        Player zero = new ComputerPlayer("0", Field.ZERO);
        View view = new View(field);
        System.out.println(field);
        Player player = cross;
        while(true) {
            view.displayField();
            System.out.println("Введите координаты: ");
            Point coords = player.makeTurn(field);

            if(!field.set(coords.x, coords.y, player.getSign())) {
                System.out.println("Повтори ход");
                continue;
            }

            if(field.checkField()) {
                System.out.println("Выиграл " + player.getName());
                break;
            }

            if(player.getSign() == Field.CROSS) {
                player = zero;
            } else {
                player = cross;
            }
            System.out.println(field);
        }
        view.displayField();
    }
}
