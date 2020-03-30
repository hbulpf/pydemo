package solution;

public abstract class ReadNCharactersGivenRead4 {

    public int read(char[] buf, int n) {
        char[] tmp = new char[4];

        int i = 0;
        for ( ; i < n; i++) {
            int size = read4(tmp);
            for (int j = 0; j < size && i < n; ) {
                buf[i++] = tmp[j++];
            }
            if (size < 4) {
                break;
            }
        }

        return i;
    }

    abstract int read4(char[] buf);
}
