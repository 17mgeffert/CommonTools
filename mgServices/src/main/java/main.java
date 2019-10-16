import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class main{

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        apiService service = new apiService();
        service.get("https://pokeapi.co/api/v2/pokemon/ditto/");
    }


}