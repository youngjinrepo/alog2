package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

//https://www.acmicpc.net/problem/1764
public class OffBrand {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> ob = new HashMap<>();
        String Key;
        for (int i = 0 ; i < N+M; i++) {
            Key = br.readLine();
            Integer val = ob.get(Key);
            if (val == null) {
                val = 0;
            }
            ob.put(Key, val+1);
        }

        Set<String> keys = ob.keySet();
        List<String> sortedList = keys.stream().sorted().collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (String s : sortedList) {
            Integer val = ob.get(s);
            if (val > 1) {
                cnt++;
                sb.append(s).append("\n");
            }
        }
        sb.insert(0, cnt+ "\n");

        System.out.println(sb);
    }
}
