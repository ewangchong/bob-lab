package com.codergray.lintcode.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Backpack {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int index = 0, capacity = 0, totalNum = 0;
        List<Integer> priceList = new ArrayList<Integer>();
        List<Integer> sizeList = new ArrayList<Integer>();
        while ((s = in.readLine()) != null) {
            if (!s.contains(" ")) {
                throw new IOException("Invalid input.");
            }
            String[] input = s.split(" ");
            if (index == 0) {
                capacity = Integer.valueOf(input[0]);
                totalNum = Integer.valueOf(input[1]);
            } else {
                priceList.add(Integer.valueOf(input[0]));
                sizeList.add(Integer.valueOf(input[1]));
                if(totalNum==index)
                    break;
            }
            index++;
        }

        int[] f = new int[capacity + 1];
        for (int i = 0; i <= capacity; ++i)
            f[i] = 0;
        for (int i = 0; i < totalNum; i++) {
            for (int j = capacity; j >= sizeList.get(i); j--) {
                if (f[j] < f[j - sizeList.get(i)] + priceList.get(i)) {
                    f[j] = f[j - sizeList.get(i)] + priceList.get(i);
                    System.out.println(f[j]);
                }
            }
        }
        System.out.println("Maximum is " + f[capacity]);
    }
}