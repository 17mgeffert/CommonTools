import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class main{

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        get("https://pokeapi.co/api/v2/pokemon/ditto/");
    }

    private static void get(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36");
        int responseCode = connection.getResponseCode();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String output="";
        String readerString;
        while ((readerString = in.readLine()) != null)
            output+=readerString;
        in.close();
        System.out.println("Response Code:"+responseCode);
        System.out.println(output);
    }
}