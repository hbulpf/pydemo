public class RectangleArea {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int leftX = Math.max(A, E), leftY = Math.max(B, F);
        int rightX = Math.min(C, G), rightY = Math.min(D, H);
        int sum = (C - A) * (D - B) + (G - E) * (H - F);
        if (rightX > leftX && rightY > leftY) {
            sum -= (rightY - leftY) * (rightX - leftX);
        }
        return sum;
    }
}
