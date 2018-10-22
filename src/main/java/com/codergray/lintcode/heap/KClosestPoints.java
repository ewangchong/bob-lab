package com.codergray.lintcode.heap;

import com.codergray.lintcode.share.Point;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by cwang on 2/24/17.
 */
public class KClosestPoints {

    private Point global_origin = null;

    public Point[] kClosest(Point[] points, Point origin, int k) {
        // Write your code here
        global_origin = origin;
        PriorityQueue<Point> pq = new PriorityQueue<Point>(k, new Comparator<Point>() {
            public int compare(Point a, Point b) {
                int diff = getDistance(b, global_origin) - getDistance(a, global_origin);
                if (diff == 0) {
                    if(b.x-a.x!=0)
                        return b.x - a.x;
                    else
                        return b.y - a.y;
                }else
                    return diff;
            }
        });

        for (int i = 0; i < points.length; i++) {
            pq.offer(points[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }

        Point[] ret = new Point[k];
        for (int i = k-1; i >=0; i--) {
            ret[i]=pq.poll();
        }

        return ret;
    }

    private int getDistance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
}
