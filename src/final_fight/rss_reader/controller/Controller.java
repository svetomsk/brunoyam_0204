package final_fight.rss_reader.controller;

import final_fight.rss_reader.db.DatabaseHelper;
import final_fight.rss_reader.db.IDatabaseHelper;
import final_fight.rss_reader.network.INetworkHelper;
import final_fight.rss_reader.network.NetworkHelper;
import final_fight.rss_reader.view.MainFrame;
import final_fight.rss_reader.xml_parser.IXMLParser;
import final_fight.rss_reader.xml_parser.NewsItem;

import java.util.List;

public class Controller implements IController {

    private INetworkHelper networkHelper;
    private IDatabaseHelper databaseHelper;
    private MainFrame frame;

    @Override
    public void start() {
        frame = new MainFrame();
        networkHelper = new NetworkHelper();
        String xmlData = networkHelper.getHtml("https://www.sports.ru/tribuna/blogs/utkin/rss.xml");
        List<NewsItem> news = IXMLParser.parseMXL(xmlData);
        for (NewsItem item : news) {
            System.out.println(item.getTitle());
        }
        final String testChanel = "https://www.sports.ru/tribuna/blogs/utkin/rss.xml";
        databaseHelper = new DatabaseHelper();
//        databaseHelper.init();
        frame.updateNews(news);
        frame.setVisible(true);
//        databaseHelper.addNewsByChannel(news, testChanel);
//        ixmlParser = new I
//        System.out.println();

//        frame.setVisible(true);


    }

    @Override
    public void updateNews(String chanel) {

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
