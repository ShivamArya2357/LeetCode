package Practice.src.warmup;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LeetCode535 {

    private Map<String, String> tinyUrlToLongUrlMap = new HashMap<>();

    private Random random = new Random();

    public static void main(String[] args) {


    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {

        String tinyUrl = "http://tinyurl.com/" + random.nextInt();
        tinyUrlToLongUrlMap.put(tinyUrl, longUrl);
        return tinyUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return tinyUrlToLongUrlMap.get(shortUrl);
    }
}
