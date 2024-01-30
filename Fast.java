import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import s2.Point;

import java.util.Arrays;
import java.util.Comparator;

public class Fast {
    private static Point[] points;
    private static Point[] pointSort;
    private static int pIndex = 0;
    private static Point[][] retArr;
    private static int retArrIndex = 0;
    private static int segCount = 0;

    public static void sort(Point p) {
        Arrays.sort(pointSort, pIndex + 1, pointSort.length, new Comparator<Point>() {
            public int compare(Point q1, Point q2) {
                Double res = p.slopeTo(q1) - p.slopeTo(q2);
                if (res < 0) {
                    return -1;
                }
                else if (res > 0) {
                    return 1;
                }
                return q1.compareTo(q2);
            }
        });
    }

    public static void findPattern(Point p) {
        Point[] tempArr = new Point[points.length - 1];
        int arrIndex = 1;
        for (int i = pIndex + 1; i < points.length - 2; i++) {
            Point q1 = pointSort[i + 1];
            Point q2 = pointSort[i + 2];
            tempArr[0] = p;
            if (p.slopeTo(q1) == p.slopeTo(q2)) {
                tempArr[arrIndex] = q1;
                arrIndex++;
                if (i == points.length - 1) {
                    tempArr[arrIndex] = q2;
                }
            }
            else {
                tempArr[arrIndex] = q1;
                if (arrIndex >= 3) {
                    Arrays.sort(tempArr, 0, arrIndex);
                    retArr[retArrIndex] = tempArr;
                    retArrIndex++;
                    segCount++;
                }
                arrIndex = 1;
                tempArr = new Point[points.length - 1];
            }
        }
    }

    public static void findAllPatterns() {
        for (int i = 1; i < points.length - 2; i++) {
            Point p = points[pIndex];
            pointSort = points;
            sort(p);
            findPattern(p);
            pIndex++;
        }
    }

    public static void printArr() {
        for (int i = 0; i < segCount; i++) {
            String temp = "";
            for (int j = 0; j < 4; j++) {
                if (j > 0) {
                    temp += " -> ";
                    if (retArr[i][j] == null) {
                        break;
                    }
                }
                temp += retArr[i][j].toString();
            }
            StdOut.println(temp);
        }
    }

    public static void main(String[] args) {
        In in = new In();
        int n = in.readInt();
        points = new Point[n];
        pointSort = new Point[n];
        retArr = new Point[n][n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt(), y = in.readInt();
            points[i] = new Point(x, y);
            pointSort[i] = new Point(x, y);
        }
        findAllPatterns();
        printArr();
    }
}
