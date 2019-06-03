package final_fight.rss_reader.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public interface INetworkHelper {
    class NetworkHelper implements INetworkHelper {
        public static void main(String[] args) throws IOException {
            URL address = new URL("https://www.championat.com/rss/news/football/");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(address.openStream())
            );

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
        }
    }
}

