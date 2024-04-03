package com.wjm.question.lc75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q841 {
    List<List<Integer>> rooms;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        this.rooms = rooms;
        int[] vis = new int[rooms.size()];
        int[] keys = new int[rooms.size()];
        keys[0] = 1;
        func(vis, keys);
        for (int i : vis) {
            if (i == 0) return false;
        }
        return true;
    }

    void func(int[] vis, int[] keys) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] > 0 && vis[i] == 0) {
                visit(vis, keys, i);
            }
        }
    }

    void visit(int[] vis, int[] keys, int id) {
        List<Integer> newKeys = rooms.get(id);
        for (int newKey : newKeys) {
            keys[newKey]++;
            if (vis[newKey] == 0) visit(vis, keys, newKey);
        }
        vis[id] = 1;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list0 = new ArrayList<>(Arrays.asList(1, 3));
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(3, 0, 1));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(2));
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(0));
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(list0);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        Q841 q = new Q841();
        q.canVisitAllRooms(lists);
    }
}
