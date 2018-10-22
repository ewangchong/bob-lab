package com.codergray.lab;

import java.io.IOException;
import java.util.*;

public class CountGroups {
    public static void main(String[] args) throws IOException {
        CountGroups cg = new CountGroups();
        List<List<Integer>> m = new ArrayList<List<Integer>>();
        m.add(Arrays.asList(0, 1, 1, 0, 1, 1));
        m.add(Arrays.asList(1, 1, 1, 0, 1, 1));
        m.add(Arrays.asList(0, 0, 0, 0, 1, 1));
        m.add(Arrays.asList(0, 1, 1, 0, 0, 0));
        m.add(Arrays.asList(0, 0, 0, 0, 1, 1));
        m.add(Arrays.asList(0, 1, 1, 0, 0, 0));

        List<Integer> t = Arrays.asList(1, 2, 5, 6);
//        List<Integer> result = cg.countGroups(m, t);
        List<Integer> result = cg.countGroupsDFS(m, t);
        result.stream().forEach(i -> System.out.print(i + " "));
    }

    /*
     * Complete the 'countGroups' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY m
     *  2. INTEGER_ARRAY t
     */
    public List<Integer> countGroupsDFS(List<List<Integer>> m, List<Integer> t){
        List<Integer> result = new ArrayList<>();
        if (m == null || m.size() == 0 || m.get(0) == null || m.get(0).size() == 0) {
            return result;
        }
        int n = m.size();

        Map<Integer, Integer> sizeToCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (m.get(i).get(j) == 1) {
                    int count = getSize(m, i, j);
                    if (!sizeToCount.containsKey(count)){
                        sizeToCount.put(count, 0);
                    }
                    sizeToCount.put(count, sizeToCount.get(count) + 1);
                }
            }
        }

        for (Integer i: t) {
            if (sizeToCount.containsKey(i)) 
                result.add(sizeToCount.get(i));
            else
                result.add(0);
        }
        
        return result;
    }
    
    private int getSize(List<List<Integer>> m, int i, int j){
        if(i < 0 || i >= m.size() || j < 0 || j >=m.get(0).size() || m.get(i).get(j) == 0){
            return 0;
        }
        List<Integer> list = m.get(i);
        list.set(j, 0);
        m.set(i, list);
        
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        int size = 0;
        for (int k = 0; k < 4; k++) {
            size += getSize(m, i + dx[k], j + dy[k]);
        }
        return size + 1;
    }
    
    public static List<Integer> countGroups(List<List<Integer>> m, List<Integer> t) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        if (m == null || m.size() == 0 || m.get(0).size() == 0) {
            return result;
        }
        int n = m.size();

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        int[] root = new int[n * n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (m.get(i).get(j) == 1) {
                    root[i * n + j] = i * n + j;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (m.get(i).get(j) == 1) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];

                        if (x >= 0 && x < n && y >= 0 && y < n && m.get(x).get(y) == 1) {
                            int cRoot = getRoot(root, i * n + j);
                            int nRoot = getRoot(root, x * n + y);
                            if (nRoot != cRoot) {
                                root[cRoot] = nRoot;
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < root.length; i++) {
            root[i] = getRoot(root, i);
        }

        Map<Integer, Integer> rootToSize = new HashMap<Integer, Integer>();
        for (Integer i : root) {
            if (i == 0) {
                continue;
            }
            if (!rootToSize.containsKey(i)) {
                rootToSize.put(i, 0);
            }
            rootToSize.put(i, rootToSize.get(i) + 1);
        }

        Map<Integer, Integer> sizeToCount = new HashMap<Integer, Integer>();
        for (Integer key : rootToSize.keySet()) {
            int size = rootToSize.get(key);
            if (!sizeToCount.containsKey(size)) {
                sizeToCount.put(size, 0);
            }
            sizeToCount.put(size, sizeToCount.get(size) + 1);
        }

        for (Integer size : t) {
            if (!sizeToCount.containsKey(size)) {
                result.add(0);
            } else {
                result.add(sizeToCount.get(size));
            }
        }

        return result;
    }

    private static int getRoot(int[] arr, int i) {
        while (arr[i] != i) {
            i = arr[arr[i]];
        }
        return i;
    }
}

