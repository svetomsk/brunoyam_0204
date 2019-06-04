package final_fight.rss_reader.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public interface INetworkHelper {
    String getHtml(String url);
}

class NetworkHelper implements INetworkHelper {
    @Override
    public String getHtml(String url) {
        URL address = null;
        try {
            address = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        try {
            in = new BufferedReader(
                    new InputStreamReader(address.openStream())
            );


            String inputLine;
            while ((inputLine = in.readLine()) != null) {
//                System.out.println(inputLine);
                result.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}


