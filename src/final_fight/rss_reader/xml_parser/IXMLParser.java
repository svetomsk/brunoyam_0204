package final_fight.rss_reader.xml_parser;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;


public interface IXMLParser {

    public static LocalDateTime stringToLocalDateTime(String time) {
        LocalDateTime localDateTime = LocalDateTime.parse(time);
        return localDateTime;
    }

    // строку -> в файл XML
    public default ArrayList<NewsItem> parseMXL(String xmlString) {
        ArrayList<NewsItem> outputDatas = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document file = builder.parse(new InputSource(new StringReader(xmlString)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // строку -> в файл XML


        try (StaxStreamProcessor processor = new StaxStreamProcessor((Files.newInputStream(Paths.get("file.xml"))))) {
            XMLStreamReader reader = processor.getReader();

            while (reader.hasNext()) {       // while not end of XML
                int event = reader.next();   // read next event
                NewsItem newsItem = new NewsItem();
                if (event == XMLEvent.START_ELEMENT &&
                        "title".equals(reader.getLocalName())) {
                    newsItem.setTitle(reader.getElementText());
                }
                if (event == XMLEvent.START_ELEMENT &&
                        "description".equals(reader.getLocalName())) {
                    newsItem.setDescription(reader.getElementText());
                }
                if (event == XMLEvent.START_ELEMENT &&
                        "link".equals(reader.getLocalName())) {
                    newsItem.setLink(reader.getElementText());
                }
                if (event == XMLEvent.START_ELEMENT &&
                        "pubDate".equals(reader.getLocalName())) {
                    newsItem.setPubDate(stringToLocalDateTime(reader.getElementText()));
                }
                outputDatas.add(newsItem);
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return outputDatas;
    }

}

