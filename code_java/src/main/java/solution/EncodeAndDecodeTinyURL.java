package solution;

import java.util.HashMap;
import java.util.Random;

/**
 * https://leetcode.com/articles/encode-and-decode-tinyurl/
 */

/**
 * 这题有几点注意：
 * 1， 防攻击，所以要完全随机
 * 2， 对同一个url多次encode，是否要新生成还是返回旧的
 * 3，
 */
public class EncodeAndDecodeTinyURL {

    private static final String SRC = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static final String URL_PREFIX = "http://tinyurl.com/";

    private HashMap<String, String> mMap = new HashMap<>();

    private static final int SHORT_URL_LEN = 6;

    private Random mRandom = new Random(System.currentTimeMillis());

    public String encode(String longUrl) {
        String shortUrl = "";
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < SHORT_URL_LEN; i++) {
                sb.append(SRC.charAt(mRandom.nextInt(SRC.length())));
            }
            shortUrl = sb.toString();
        } while (mMap.containsKey(shortUrl));
        mMap.put(shortUrl, longUrl);
        return URL_PREFIX + shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return mMap.get(shortUrl.replaceAll(URL_PREFIX, ""));
    }
}
