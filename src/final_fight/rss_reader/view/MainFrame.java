package final_fight.rss_reader.view;

import final_fight.rss_reader.controller.IController;
import final_fight.rss_reader.xml_parser.NewsItem;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainFrame extends JFrame {
    private IController cntl;
    private JPanel rootPanel;
    private JList newsList;
    private JButton updateNewsButton;
    private JPanel newsPanel;
    private JPanel linkPanel;
    private JScrollBar scrollBar1;
    private JButton addButton;
    private JButton removeButton;
    private JList listLink;

    public MainFrame() {
        this.add(rootPanel);
        this.setTitle("RSS Reader");
        this.setBounds(150, 100, 600, 800);
        this.setMinimumSize(new Dimension(600, 800));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void updateNews(List<NewsItem> news) {

    }

    void updateChanels(List<String> chanels) {

    }
}

class StuckController implements IController {

    @Override
    public void updateNews(String chanel) {
        System.out.println("called updated news");

    }

    @Override
    public void addChanel(String url) {

    }

    @Override
    public void removeChanel(String url) {

    }

    @Override
    public void refreshNews(String lastChanel) {

    }

    @Override
    public void openOriginSource(String title) {

    }
}
