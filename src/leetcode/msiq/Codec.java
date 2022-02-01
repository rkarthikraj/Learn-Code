package leetcode.msiq;

import java.util.HashMap;
import java.util.Map;

public class Codec {
    public static void main(String[] args) {
        Codec obj = new Codec();
        String url = "https://leetcode.com/problems/design-tinyurl";
        System.out.println(obj.decode(obj.encode(url)));
    }

    Map<String, String> tinyUrlMap = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        tinyUrlMap.put(longUrl.hashCode() + "", longUrl);
        return longUrl.hashCode() + "";
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        shortUrl = shortUrl.replace("http://tinyurl.com/", "");
        return tinyUrlMap.get(shortUrl);
    }
}
