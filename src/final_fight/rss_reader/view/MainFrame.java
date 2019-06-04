package final_fight.rss_reader.view;

import final_fight.rss_reader.controller.Controller;
import final_fight.rss_reader.controller.IController;
import final_fight.rss_reader.xml_parser.NewsItem;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainFrame extends JFrame {
    private IController cntl;
    private JList newsList;
    private JButton updateNewsButton;
    private JButton addButton;
    private JButton delButton;
    private JPanel newsPanel;
    private JPanel linkPanel;
    private JList linkList;
    private JPanel rootPanel;

    public MainFrame(IController cntl) {
        this.cntl = cntl;
        this.add(rootPanel);
        this.setTitle("RSS Reader");
        this.setBounds(150, 100, 600, 700);
        this.setMinimumSize(new Dimension(600, 700));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setContentPane(rootPanel);

        DefaultListModel news = new DefaultListModel();
        for (int i = 0; i < 7; i++) {
            news.addElement("Новость" + i);
        }
        newsList.setModel(news);

        DefaultListModel link = new DefaultListModel();
        int i = 0;
        for (i = 0; i < 30; i++) {
            link.addElement("Сайт" + i);
        }
        linkList.setModel(link);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String element = JOptionPane.showInputDialog(this,"Введите ссылку на RSS канал");
                link.addElement(element);
//                int index = link.size() - 1;
//                linkList.getSelectedIndex(index);
//                linkList.ensureIndexIsVisible(index);
            }
        });
        delButton.addActionListener(e -> link.remove(linkList.getSelectedIndex()));

//        delButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                link.remove(linkList.getSelectedIndex());
//            }
//        });

        linkList.addListSelectionListener(e -> {
            if (linkList.getSelectedIndex() >= 0) {
                delButton.setEnabled(true);
            } else {
                delButton.setEnabled(false);
            }
        });
//        linkList.addListSelectionListener(new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent e) {
//                if (linkList.getSelectedIndex() >= 0) {
//                    delButton.setEnabled(true);
//                } else {
//                    delButton.setEnabled(false);
//                }
//            }
//        });
        updateNewsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

//        updateNewsButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
    }

    void addChanel(){
        String chanelName = "";
        cntl.addChanel(chanelName);
    }

    void removeChanels(List<String> chanel) {
        String chanelName = "";
        cntl.removeChanel(chanelName);
    }

    void updateNews(List<NewsItem> news) {
        String newsItem = "";
        cntl.updateNews(newsItem);
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
