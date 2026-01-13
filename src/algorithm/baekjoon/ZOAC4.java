public class ZOAC4 {
    //https://www.acmicpc.net/problem/23971
    public static void main(String[] args) {
        int result = zoac4(5,4,1,1);
    }

    private static int zoac4(double h, double w, double n, double m) {
        double d1 = Math.ceil(h/(n+1));
        double d2 = Math.ceil(w/(m+1));
        return (int) Math.ceil(d1*d2);
    }
}
