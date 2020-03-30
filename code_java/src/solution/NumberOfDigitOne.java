public class NumberOfDigitOne {

    /**
     * 下面要注意所有局部变量都是long的，因为factor*10可能会溢出
     */
    public int countDigitOne(int n) {
        long count = 0, factor = 1;
        long low = 0, cur = 0, high = 0;

        while (n / factor > 0) {
            low = n % factor;
            cur = (n / factor) % 10;
            high = n / (factor * 10);

            switch ((int) cur) {
                case 0:
                    count += high * factor;
                    break;
                case 1:
                    count += high * factor + low + 1;
                    break;
                default:
                    count += (high + 1) * factor;
                    break;
            }

            factor *= 10;
        }

        return (int) count;
    }
}
