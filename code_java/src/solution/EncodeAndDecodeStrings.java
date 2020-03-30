package solution;

import java.util.LinkedList;
import java.util.List;

public class EncodeAndDecodeStrings {

    /**
     * 非常巧妙，字符串长度 + '/' + 字符串
     * @param strs
     * @return
     */
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("/").append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> list = new LinkedList<String>();
        for (int i = 0; i < s.length(); ) {
            int index = s.indexOf("/", i);
            int size = Integer.parseInt(s.substring(i, index));
            i = index + 1 + size;
            list.add(s.substring(index + 1, i));
        }
        return list;
    }
}
