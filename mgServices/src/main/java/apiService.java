import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;


import org.codehaus.jackson.map.ObjectMapper;

public class apiService {

    public static void get(String urlString) throws IOException {
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
    public static void post() throws IOException {
        URL url = new URL("https://reqres.in/api/login");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestMethod("POST");

        User user = new User();
        user.setEmail("eve.holt@reqres.in");
        user.setPassword("pistol");
        ObjectMapper mapper = new ObjectMapper();

        //String request = "";
        OutputStreamWriter out = new OutputStreamWriter(
                connection.getOutputStream());
        out.write(mapper.writeValueAsString(user));
        out.close();

        //System.out.println(connection.getResponseMessage());
        //System.out.println(mapper.writeValueAsString(user));

        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()));
        String decodedString;
        String output="";
        while ((decodedString = in.readLine()) != null) {
            output+=decodedString;
        }
        in.close();
        System.out.println(output);
        UserReturn newUser=mapper.readValue(output,UserReturn.class);
        System.out.println(newUser.toString());
    }
}
