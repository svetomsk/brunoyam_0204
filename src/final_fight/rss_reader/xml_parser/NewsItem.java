package final_fight.rss_reader.xml_parser;

import java.time.LocalDateTime;

public class NewsItem {
    private String title;
    private String description;
    private String link;
    private LocalDateTime pubDate;

    public NewsItem(String title, String description, String link, LocalDateTime pubDate) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public LocalDateTime getPubDate() {
        return pubDate;
    }

    public void setPubDate(LocalDateTime pubDate) {
        this.pubDate = pubDate;
    }
}
