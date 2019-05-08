import java.util.ArrayList;
import java.util.List;

public class PolymorphismExample {
    public static void main(String[] args) {
        ColoredPrinter colored = new ColoredPrinter();
        colored.printPage("Hello");
//        System.out.println(colored.checkPaper(0));

        BlackAndWhitePrinter bw = new BlackAndWhitePrinter();
        bw.printPage("Goodbye");

        List<Object> printers = new ArrayList<>();
        printers.add(colored);
        printers.add(bw);

//        for (Object pr : printers) {
//            if (pr instanceof ColoredPrinter) {
//                ColoredPrinter printer = (ColoredPrinter) pr;
//                printer.printPage("sdafsdf");
//            } else if (pr instanceof BlackAndWhitePrinter) {
//                BlackAndWhitePrinter printer = (BlackAndWhitePrinter) pr;
//                printer.printPage("sdafssdfsdfdf");
//            } else if (pr instanceof OneMorePrinter) {
//                OneMorePrinter printer = (OneMorePrinter) pr;
//                printer.printPage("asdfsdf");
//            } else {
//                System.out.println("ha ha ne smeshno");
//            }
//        }
//        System.out.println(bw.checkPaper(0));
//
        List<Printer> printes = new ArrayList<>();
        printes.add(colored);
        printes.add(bw);

        for (Printer pr : printes) {
            pr.printPage("smth");
        }
    }
}

class Printer {
    public boolean checkPaper(int cnt) {
        return cnt != 0;
    }

    public boolean checkIncLevel(int level) {
        return level > 1;
    }

    public void printPage(String msg) {
        System.out.println("Just do nothing");
    }
}

class ColoredPrinter extends Printer {
    //    @Override
    public void printPage(String msg) {
        System.out.println("Printing in colors");
    }
}

class BlackAndWhitePrinter extends Printer {
    //    @Override
    public void printPage(String msg) {
        System.out.println("Printing in black and white");
    }
}

class OneMorePrinter extends Printer {
    //    @Override
    public void printPage(String msg) {
        System.out.println("one more sout");
    }
}


