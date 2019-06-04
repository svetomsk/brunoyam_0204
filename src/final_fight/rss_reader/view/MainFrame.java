package final_fight.rss_reader.view;

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

    private JFrame frame;
    private JPanel contents;
    private ImageIcon linkIcon;
    private DefaultListModel model;

    public MainFrame() {
        this.add(rootPanel);
        this.setTitle("RSS Reader");
        this.setBounds(150, 100, 600, 700);
        this.setMinimumSize(new Dimension(600, 700));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setVisible(true);

        this.setContentPane(rootPanel);

        model = new DefaultListModel();
//        for (int i = 0; i < 7; i++) {
//            model.addElement("Новость" + i);
//        }
        newsList.setModel(model);

        DefaultListModel link = new DefaultListModel();
        int i = 0;
        for (i = 0; i < 35; i++) {

            link.addElement("Сайт" + i);
        }
        linkList.setModel(link);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String element = JOptionPane.showInputDialog(this);
                link.addElement(element);
//                int index = link.size() - 1;
//                linkList.getSelectedIndex(index);
//                linkList.ensureIndexIsVisible(index);
            }
        });

        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                link.remove(linkList.getSelectedIndex());
            }
        });
        linkList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (linkList.getSelectedIndex() >= 0) {
                    delButton.setEnabled(true);
                } else {
                    delButton.setEnabled(false);
                }
            }
        });
    }

    public void updateNews(List<NewsItem> news) {
        for (NewsItem item : news) {
            model.addElement(item.getTitle());
        }
    }

    void updateChanels(List<String> chanels) {
    }


}
