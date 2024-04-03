package com.wjm.question.lc75;

import java.util.*;

public class Q17 {
    Map<Character, List<Character>> map;
    StringBuilder sb = new StringBuilder();
    List<String> ret = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        map = new HashMap<>();
        map.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        map.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        map.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        map.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        map.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        map.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        map.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        map.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));
        char[] ss = digits.toCharArray();
        if (ss.length > 0)
            dfs(ss, 0);
        return ret;
    }

    void dfs(char[] ss, int p) {
        if (p == ss.length) {
            ret.add(sb.toString());
            return;
        }
        List<Character> characters = map.get(ss[p]);
        for (Character c : characters) {
            sb.append(c);
            dfs(ss, p + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Q17 q = new Q17();
        List<String> strings = q.letterCombinations("");
        System.out.println(strings);
    }
}
