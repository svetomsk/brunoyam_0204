package final_fight.rss_reader.controller;

public interface IController {
    void updateNews(String chanel);

    void addChanel(String url);

    void removeChanel(String url);

    void refreshNews(String lastChanel);

    void openOriginSource(String title);

    void start();
}
