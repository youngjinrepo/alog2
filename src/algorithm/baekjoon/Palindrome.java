import java.util.ArrayList;
import java.util.Arrays;

/*
 * 
 * - 문자열의 모든 서로 다른 팰린드롬을 노드로 관리
 * - O(N) 시간에 각 팰린드롬의 등장 횟수를 계산 가능
 */
public class Palindrome {

    static final int ALPHA=26;

    public static void main(String[] args) {

        String line = "ababa";
        String s = line.trim();
        int n = s.length();

        Eertree ert = new Eertree(n);

        // 문자열을 한 글자씩 Eertree에 추가
        for (int i = 0; i < n; i++) {
            ert.addChar(s.charAt(i));
        }

        // suffix link를 이용해 등장 횟수를 전파
        ert.propagateOccurrences();

        // 길이 × 등장횟수의 최댓값 계산
        long ans = 0;
        for (int i = 2; i < ert.tree.size(); i++) { // 루트 0,1 제외
            long len = ert.tree.get(i).len;
            long occ = ert.tree.get(i).occ;
            ans = Math.max(ans, len * occ);
        }

        System.out.println(ans);
        
    }
    // 팰린드롬을 나타내는 노드 클래스
    static class Node {
        int len;
        int link;
        int[] next = new int[ALPHA];
        long occ;
        Node(int len) {
            this.len = len;
            this.link = 0;
            Arrays.fill(next, -1);
            this.occ = 0;
        }
    }

    static class Eertree {
        ArrayList<Node> tree;
        char[] s;
        int pos;
        int last;

        Eertree(int n) {
            tree = new ArrayList<>();
            // 두 개의 가상 루트 노드 생성
            // 0번: 길이 -1 (홀수 팰린드롬 루트)
            tree.add(new Node(-1));
            // 1번: 길이 0 (짝수 팰린드롬 루트)
            tree.add(new Node(0));
            tree.get(0).link = 0; // 자기 자신을 링크 (편의상)
            tree.get(1).link = 0;

            s = new char[n + 5];
            pos = 0;
            last = 1; // 시작은 짝수 루트에서
        }

        // 현재 노드부터 suffix link를 타고 내려가면서,
        // 새로 추가한 문자가 양쪽 끝이 같은 팰린드롬을 찾을 때까지 이동
        private int getLink(int node) {
            while (true) {
                int L = tree.get(node).len;
                if (pos - 1 - L >= 0 && s[pos - 1 - L] == s[pos]) {
                    return node;
                }
                node = tree.get(node).link;
            }
        }

        // 새 문자 하나 추가
        public void addChar(char ch) {
            pos++;
            s[pos] = ch;
            int cur = getLink(last); // 확장 가능한 가장 긴 팰린드롬 노드 찾기
            int c = ch - 'a';

            // 확장한 팰린드롬이 아직 존재하지 않는다면 새 노드 생성
            if (tree.get(cur).next[c] == -1) {
                Node newNode = new Node(tree.get(cur).len + 2); // 길이 +2 확장
                tree.add(newNode);
                int newIdx = tree.size() - 1;

                // 길이가 1이면 suffix link는 짝수 루트(1)로
                if (newNode.len == 1) {
                    newNode.link = 1;
                } else {
                    // 그렇지 않으면 suffix link를 타고 또 확장해본다
                    int linkNode = getLink(tree.get(cur).link);
                    newNode.link = tree.get(linkNode).next[c];
                }

                // 현재 팰린드롬(cur)에서 문자 c를 확장했을 때 새 노드로 가는 간선 설정
                tree.get(cur).next[c] = newIdx;
            }

            // last를 새로 만든 팰린드롬(혹은 기존 팰린드롬)으로 갱신
            last = tree.get(cur).next[c];
            // 이 팰린드롬이 suffix로 한 번 더 등장했다고 기록
            tree.get(last).occ++;
        }
        
        // 등장 횟수를 긴 팰린드롬에서 짧은 팰린드롬으로 전파
        // → suffix link를 따라가면 내부 팰린드롬 등장 횟수를 모두 누적 가능
        public void propagateOccurrences() {
            int m = tree.size();
            Integer[] idx = new Integer[m];
            for (int i = 0; i < m; i++) idx[i] = i;
            // 길이 내림차순 정렬 (긴 것부터 짧은 것 순서)
            Arrays.sort(idx, (a, b) -> Integer.compare(tree.get(b).len, tree.get(a).len));

            for (int id : idx) {
                if (id <= 1) continue; // 두 루트 제외
                int link = tree.get(id).link;
                if (link >= 0) {
                    tree.get(link).occ += tree.get(id).occ;
                }
            }
        }
    }
}
