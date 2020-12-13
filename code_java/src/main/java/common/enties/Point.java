package common.enties;

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Point)) return false;
//
//        Point point = (Point) o;
//
//        if (x != point.x) return false;
//        return y == point.y;
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = x;
//        result = 31 * result + y;
//        return result;
//    }
}
