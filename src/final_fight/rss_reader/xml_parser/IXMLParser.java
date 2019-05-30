package final_fight.rss_reader.xml_parser;

import java.util.List;

public interface IXMLParser {
    List<NewsItem> parseXML(String xmlString);
}
