package hackerrank;


import java.io.*;
import java.util.*;


public class TrieSol {
    static Trie[] tree = new Trie[26];
    public static void addToTrie(String data, int n, Trie[] tree) {
        if (n==data.length()) {
            return;
        }
        char ch = data.charAt(n);
        Trie inst = tree[ch - 'a'];
        if (inst == null) {
            tree[ch - 'a'] = new Trie();
            tree[ch - 'a'].ch = ch;
            tree[ch - 'a'].pointers = new Trie[26];
            if (n == data.length()-1) {
                tree[ch - 'a'].terminate = true;
            }
        }
        addToTrie(data, n+1, tree[ch - 'a'].pointers);
    }

    public static List<Integer> contacts(List<List<String>> queries) {
        List<Integer> list  = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < queries.size(); i++){
            List<String> data =queries.get(i);
            if (data.get(0).equals("add")){
                for (int j = 1; j <= data.get(1).length(); j++){
                    String sub = data.get(1).substring(0, j);
                    if (map.get(sub) == null){
                        map.put(sub, 1);
                    } else {
                        map.put(sub, map.get(sub) + 1);
                    }
                }
            } else { //query matches
                if (map.get(data.get(1)) == null){
                    list.add(map.get(0));
                    System.out.println(0);
                } else {
                    list.add(map.get(data.get(1)));
                    System.out.println(map.get(data.get(1)));
                }

            }
        }
        return list;
    }

    private static int getCounts(String str, Trie[] tree) {
        int i=0;
        Trie instance = new Trie();
        while (i < str.length()) {
            char ch = str.charAt(i);
            instance = tree[ch - 'a'];
            if (instance == null) {
                return 0;
            } else  {
                tree = instance.pointers;
            }
            i++;
        }
        if (instance.count == -1) {
            instance.count =  getCounts(tree);
        }
        return instance.count;


    }

    private static int getCounts(Trie[] tree) {
        if (tree == null) {
            return 0;
        }
        int count = 0;
        for (int i=0; i< tree.length; i++) {
            if (tree[i] != null) {
                if (tree[i].terminate) {
                    count +=1;
                }
                count += getCounts(tree[i].pointers);
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int queriesRows = Integer.parseInt(bufferedReader.readLine().trim());
        List<List<String>> data = new ArrayList<>();
        for (int i =0; i <queriesRows; i++) {
            String    q[] = bufferedReader.readLine().split(" ");
            data.add(Arrays.asList(q[0], q[1]));
        }
        System.out.println(contacts(data));
    }
}

class Trie {
    char ch;
    boolean terminate;
    int count = -1;
    Trie pointers[];
}