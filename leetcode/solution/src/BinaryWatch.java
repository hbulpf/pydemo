import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

    public List<String> readBinaryWatch(int num) {
        int[] f = new int[] {
                1, 2, 4, 8, 1, 2, 4, 8, 16, 32
        };

        List<String> list = new ArrayList<String>();
        readBinaryWatch(num, f, 0, 0, 0, list);

        return list;
    }

    public void readBinaryWatch(int num, int[] f, int index, int hour, int minute, List<String> list) {
        if (num == 0 && hour < 12 && minute < 60) {
            list.add(String.format("%d:%02d", hour, minute));
            return;
        }

        if (index >= f.length) {
            return;
        }

        int nextHour = index <= 3 ? hour + f[index] : hour;
        int nextMinute = index > 3 ? minute + f[index] : minute;
        readBinaryWatch(num - 1, f, index + 1, nextHour, nextMinute, list);
        readBinaryWatch(num, f, index + 1, hour, minute, list);
    }
}
