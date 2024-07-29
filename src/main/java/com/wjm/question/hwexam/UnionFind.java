package com.wjm.question.hwexam;

import java.util.*;
import static java.lang.System.out;

public class UnionFind {
    
    static int[] fa = new int[(int)2e5 + 7];
    static int cnt, ans = Integer.MAX_VALUE;
    
    public static int findset(int x, ArrayList<Integer> list) {
        cnt++;  // 记录遇到了多少个节点，如果形成了环，就是环的长度
        if(x == fa[x]) return x;
        return findset(fa[x], list);  // 不带路径压缩
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n + 1];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        
        // 初始化
        for(int i = 0; i < n; i++) fa[i] = i;
        
        // 判断每一个节点 
        for(int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            cnt = 0;  // 记得每次都清0
            int x = findset(arr[i], list);
            if(x == i) {  // 如果形成环
                ans = Math.min(cnt, ans);
            } else {
                fa[i] = arr[i];  // 不构成环就把边连上 
            }
        } 
        
        out.println(ans);
    }   
}
