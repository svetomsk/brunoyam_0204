package final_fight.rss_reader.db;

import final_fight.rss_reader.xml_parser.NewsItem;

import java.util.List;

public interface IDatabaseHelper {
    void init();

    List<NewsItem> selectAllNews(String chanel);

    List<String> selectAllChanels();

    void addNews(List<NewsItem> items);

    void addChanel(String chanel);

    void eraseNews(String chanel);

    void eraseChanel(String chanel);

    void getLastUpdateTime(String chanel);
}
