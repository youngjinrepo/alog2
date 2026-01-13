public class Balmer {
    //https://www.acmicpc.net/problem/27496
    public static void main(String[] args) {

        int N = 5;
        int L = 3;

        //int[] ach = new int[N];
        int[] ach = {45,44,44,43,40};
    
        int cnt = checkTestHourCnt(L,ach);
        System.out.println(cnt);
    }
    
    private static int checkTestHourCnt(int L, int[] ach) {
        int cnt = 0, num=0;
        for(int i=0; i<L; i++) {
            num+=ach[i];
        }
        if (num>=129&&num<=138) cnt++;
        
        num=0;

        for(int i=0; i<ach.length; i++) {
            
        }
        

        return cnt;
    }
}
