package com.codergray.lintcode.heap;

import java.util.*;

/**
 * Created by cwang on 2/24/17.
 */
public class HighFive {
    public static Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        Map<Integer, Double> highFiveMap = new HashMap<Integer, Double>();
        Map<Integer, List<Integer>> resultMap = new HashMap<Integer, List<Integer>>();
        for (Record rec : results) {
            if (resultMap.get(rec.id) == null) {
                LinkedList<Integer> resultList = new LinkedList<Integer>();
                resultList.add(rec.score);
                resultMap.put(rec.id, resultList);
            } else {
                LinkedList<Integer> resultList = (LinkedList<Integer>)resultMap.get(rec.id);
                resultList.add(rec.score);
                for(int score : resultList){
                    System.out.print(rec.id+":"+score+"->");
                }
                System.out.println();
                Collections.sort(resultList);

                for(int score : resultList){
                    System.out.print(rec.id+":"+score+"->");
                }
                System.out.println();
                if (resultList.size()>5)
                    resultList.removeFirst();
                resultMap.put(rec.id, resultList);
            }
        }
        for(Integer id : resultMap.keySet()){
            List<Integer> scores = resultMap.get(id);
            int sum = 0;
            for(int score : scores){
                sum += score;
            }
            double avg = (double)sum/scores.size();
            highFiveMap.put(id, avg);
        }
        return highFiveMap;
    }

    public static void main(String[] args){
        /**
         * [[1,91],[1,92],[2,93],[2,99],[2,98],[2,97],[1,60],[1,58],[2,100],[1,61]]
         */
        Map<Integer, Double> highFiveMap = highFive(new Record[]{new Record(1, 91),new Record(1, 92),new Record(2, 93),new Record(2, 99),new Record(2, 98),new Record(2, 97),new Record(1, 60),new Record(1, 58),new Record(2, 100), new Record(1, 61)});

        for(Integer id : highFiveMap.keySet()){
            System.out.println(id+":"+highFiveMap.get(id));
        }

    }
}

class Record {
    public int id, score;

    public Record(int id, int score) {
        this.id = id;
        this.score = score;
    }
}
