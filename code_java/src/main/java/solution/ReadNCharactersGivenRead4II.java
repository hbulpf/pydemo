package solution;

public abstract class ReadNCharactersGivenRead4II {

    private char[] mTmp = new char[4];
    private int mIndex = 0, mSize = 0;

    public int read(char[] buf, int n) {
        int i = 0;
        for (; i < n; ) {
            if (mIndex < mSize) {
                buf[i++] = mTmp[mIndex++];
            } else {
                mIndex = 0;
                mSize = read4(mTmp);
                if (mSize <= 0) {
                    break;
                }
            }
        }
        return i;
    }

    abstract int read4(char[] buf);
}
