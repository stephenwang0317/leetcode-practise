package com.wjm.autumn;

import java.util.*;
import java.util.stream.Collectors;

public class Question031 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.merge(word, 1, (oldV, newV) -> oldV + 1);
        }

        ArrayList<Map.Entry<String, Integer>> arr = new ArrayList<>(map.entrySet());
        arr.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue() - o1.getValue();
            }
        });
        return arr.stream().limit(k).map(Map.Entry::getKey).collect(Collectors.toList());
    }
}
