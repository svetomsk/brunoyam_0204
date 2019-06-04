package final_fight.rss_reader.xml_parser;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class IXMLParser {

    public static LocalDateTime stringToLocalDateTime(String time) {
        LocalDateTime localDateTime = LocalDateTime.parse(time);
        return localDateTime;
    }

    // строку -> в файл XML
    public static ArrayList<NewsItem> parseMXL(String xmlString) {
        try {
            PrintWriter writer = new PrintWriter(new File("file.xml"));
            writer.print(xmlString);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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


            boolean isItem = false;
            while (reader.hasNext()) {       // while not end of XML
                int event = reader.next();   // read next event
                if (event == XMLEvent.START_ELEMENT &&
                        "item".equals(reader.getLocalName())) {
                    isItem = true;
                }
                if (event == XMLEvent.END_ELEMENT &&
                        "/item".equals(reader.getLocalName())) {
                    isItem = false;
                }
                if (isItem) {
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
                        newsItem.setPubDate(LocalDateTime.now());
                    }
                    newsItem.setPubDate(LocalDateTime.now());
                    newsItem.setDescription("");
                    newsItem.setLink("");
                    // TODO: fix elements filter
                    outputDatas.add(newsItem);
                }

            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<NewsItem> filters = (ArrayList<NewsItem>) outputDatas.stream()
                .filter(x -> x.getTitle() != null)
                .collect(Collectors.toList());
        return filters;
    }

}

