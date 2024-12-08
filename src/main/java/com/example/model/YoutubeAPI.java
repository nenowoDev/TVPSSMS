import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;

public class YoutubeAPI {
    private static final String API_KEY = "YOUR_API_KEY";
    private static final String CHANNEL_ID = "YOUR_CHANNEL_ID";

    public static void main(String[] args) throws Exception {
        fetchChannelVideos();
    }

    public static void fetchChannelVideos() throws Exception {
        String url = String.format(
            "https://www.googleapis.com/youtube/v3/search?part=snippet&channelId=%s&maxResults=20&order=date&type=video&key=%s",
            CHANNEL_ID, API_KEY
        );

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .GET()
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            JSONObject jsonResponse = new JSONObject(response.body());
            JSONArray videos = jsonResponse.getJSONArray("items");

            System.out.println("Channel Videos:");
            for (int i = 0; i < videos.length(); i++) {
                JSONObject video = videos.getJSONObject(i);
                String videoId = video.getJSONObject("id").getString("videoId");
                String title = video.getJSONObject("snippet").getString("title");
                System.out.println("Video ID: " + videoId + ", Title: " + title);
            }
        } else {
            System.out.println("Error: " + response.statusCode() + " - " + response.body());
        }
    }
}
