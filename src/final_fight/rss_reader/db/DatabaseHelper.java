package final_fight.rss_reader.db;

import final_fight.rss_reader.xml_parser.NewsItem;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseHelper implements IDatabaseHelper {

    static int i = 0;
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss.SSS");
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm.ss.SSS");
    // "PRAGMA foreign_keys=on;"
    private final String SQL_CREATE_TABLE_NEWS = "CREATE TABLE IF NOT EXISTS news (" +
            "news_id integer PRIMARY KEY AUTOINCREMENT," +
            "title text NOT NULL," +
            "description text NOT NULL," +
            "link text NOT NULL," +
            "publish_date text NOT NULL," +
            "channel_id integer NOT NULL," +
            "FOREIGN KEY (channel_id) REFERENCES channels (id));";
    private final String SQL_CREATE_TABLE_CHANNELS = "CREATE TABLE IF NOT EXISTS channels (" +
            "id integer PRIMARY KEY," +
            "name text NOT NULL);";
    private final String SQL_SELECT_ALL_NEWS = "SELECT * FROM news INNER JOIN channels ON channels.name = ? AND channels.id = news.channel_id;";
    private final String SQL_SELECT_ALL_CHANNELS = "SELECT * FROM channels;";
    private final String SQL_SELECT_CHANNEL_BY_NAME = "SELECT id FROM channels WHERE name = ?;";
    private final String SQL_ADD_NEWS = "INSERT INTO news (title, description, link, publish_date, channel_id) VALUES (?, ?, ?, ?, ?)";
    private final String SQL_DELETE_NEWS = "DELETE FROM news WHERE channel_id = ?";
    private final String SQL_ADD_CHANNEL = "INSERT INTO channels (id, name) VALUES (?, ?)";
    private final String SQL_DELETE_CHANNEL = "DELETE FROM channels WHERE name = ?";
    private final String SQL_SELECT_DATE_BY_CHANNEL = "SELECT MAX(id), publish_date FROM news INNER JOIN channels ON channels.name = ? AND channels.id = news.channel_id GROUP BY publish_date;";
    private PreparedStatement preparedStatement = null;
    private Connection connection = null;
    private Statement statement = null;

    public DatabaseHelper() {
        init();
    }

    @Override
    public void init() {
        String url = "jdbc:sqlite:C:/Users/Stud2/Desktop/db/database.db";
        try {
            connection = DriverManager.getConnection(url);
            System.out.println("Соединение установлено.");

            statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE_CHANNELS);
            statement.execute(SQL_CREATE_TABLE_NEWS);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    public List<NewsItem> selectAllNews(String chanel) {
        List<NewsItem> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_NEWS);
            preparedStatement.setString(1, chanel);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                NewsItem newsItem = new NewsItem(resultSet.getString("title"), resultSet.getString("description"), resultSet.getString("link"), simpleDateFormat.parse(resultSet.getString("publish_date")).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
                list.add(newsItem);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return list;
    }

    @Override
    public List<String> selectAllChanels() {
        List<String> list = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_CHANNELS);
            while (resultSet.next()) {
                list.add(resultSet.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void addNews(List<NewsItem> items) {
        try {
            preparedStatement = connection.prepareStatement(SQL_ADD_NEWS);
            for (int j = 0; j < items.size(); j++) {
                preparedStatement.setString(1, items.get(j).getTitle());
                preparedStatement.setString(2, items.get(j).getDescription());
                preparedStatement.setString(3, items.get(j).getLink());
                preparedStatement.setString(4, items.get(j).getPubDate().format(formatter));
                preparedStatement.setInt(5, 1);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addNewsByChannel(List<NewsItem> items, String channel) {
        try {

            int channelId = getChannelId(channel);

            preparedStatement = connection.prepareStatement(SQL_ADD_NEWS);
            for (int j = 0; j < items.size(); j++) {
                preparedStatement.setString(1, items.get(j).getTitle());
                preparedStatement.setString(2, items.get(j).getDescription());
                preparedStatement.setString(3, items.get(j).getLink());
                preparedStatement.setString(4, items.get(j).getPubDate().format(formatter));
                preparedStatement.setInt(5, channelId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addChanel(String chanel) {
        try {
            preparedStatement = connection.prepareStatement(SQL_ADD_CHANNEL);
            i++;
            preparedStatement.setInt(1, i);
            preparedStatement.setString(2, chanel);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eraseNews(String chanel) {
            try {
                int channelId = getChannelId(chanel);
                preparedStatement = connection.prepareStatement(SQL_DELETE_NEWS);
                preparedStatement.setInt(1, channelId);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void eraseChanel(String chanel) {
            try {
                preparedStatement = connection.prepareStatement(SQL_DELETE_CHANNEL);
                preparedStatement.setString(1, chanel);
                preparedStatement.executeUpdate();
            }catch (SQLException e) {
                e.printStackTrace();
            }
    }

    @Override
    public LocalDateTime getLastUpdateTime(String chanel) {
        LocalDateTime dateTime = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_DATE_BY_CHANNEL);
            preparedStatement.setString(1, chanel);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                dateTime = simpleDateFormat.parse(resultSet.getString("publish_date")).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return dateTime;
    }

    private int getChannelId(String name) throws SQLException {
        preparedStatement = connection.prepareStatement(SQL_SELECT_CHANNEL_BY_NAME);
        preparedStatement.setString(1, name);
        return preparedStatement.executeQuery().getInt("id");
    }


}
