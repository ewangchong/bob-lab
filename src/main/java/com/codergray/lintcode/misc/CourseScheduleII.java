package com.codergray.lintcode.misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by cwang on 2/24/17.
 */
public class CourseScheduleII {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here
        List<Integer>[] edges = new ArrayList[numCourses];
        int[] degrees = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            degrees[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        int[] order = new int[numCourses];
        while (!queue.isEmpty()) {
            int course = (int) queue.poll();
            order[count] = course;
            count++;
            int size = edges[course].size();
            for (int i = size - 1; i >= 0; i--) {
                int pointer = edges[course].get(i);
                degrees[pointer]--;
                if (degrees[pointer] == 0) {
                    queue.add(pointer);
                }
            }
        }
        if (count == numCourses)
            return order;

        return new int[0];
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}, {4, 3}, {4, 5}, {7, 5}, {6, 4}, {7, 6}};
        int[] order = findOrder(8, prerequisites);
        for (int i = 0; i < 8; i++) {
            System.out.println(order[i]);
        }

    }

}
