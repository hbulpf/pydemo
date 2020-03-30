public class UTFValidation {

    public boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; ) {
            int n = data[i], size;

            if (n >>> 7 == 0) {
                size = 1;
            } else if (n >>> 5 == 0x6) {
                size = 2;
            } else if (n >>> 4 == 0xe) {
                size = 3;
            } else if (n >>> 3 == 0x1e) {
                size = 4;
            } else {
                return false;
            }

            if (i + size > data.length) {
                return false;
            }

            for (i++, size--; size > 0; size--, i++) {
                if (data[i] >>> 6 != 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
