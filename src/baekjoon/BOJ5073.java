import java.util.Arrays;
import java.util.Scanner;

public class BOJ5073 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] input = new int[3];
        StringBuilder sb = new StringBuilder(); 
        while (true) {
            input[0] = sc.nextInt();
            input[1] = sc.nextInt();
            input[2] = sc.nextInt();
            
            if (input[0]+input[1]+input[2] == 0) break;

            Arrays.sort(input);

            if (input[2] >= input[0]+input[1]) {
                sb.append("Invalid\n");
            } else if (input[0]==input[1] && input[1]==input[2]) {
                sb.append("Equilateral\n");
            } else if (input[0]==input[1] || input[1]==input[2]) {
                sb.append("Isosceles\n");
            } else {
                sb.append("Scalene\n");
            }
        }
        sc.close();

        System.out.println(sb.toString());

    }    
}
