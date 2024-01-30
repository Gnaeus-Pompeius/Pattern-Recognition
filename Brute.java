/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import s2.Point;

import java.util.Arrays;
import java.util.Comparator;

public class Brute {
    private static int size;
    private static int end = size % 4;
    private static Point[] points;
    private static Point[][] retArr;
    private static int segCount = 0;


    public static void findSegments() {
        for (int h = 0; h < size - end; h++) {
            Point p = points[h];
            for (int i = h + 1; i < size - (end - 1); i++) {
                Point q = points[i];
                for (int j = i + 1; j < size - (end - 2); j++) {
                    Point r = points[j];
                    int slopeqr = p.SLOPE_ORDER.compare(q, r);
                    if (slopeqr == 0) {
                        for (int k = j + 1; k < size; k++) {
                            Point s = points[k];
                            int slopers = p.SLOPE_ORDER.compare(r, s);
                            if (slopers == 0) {
                                Point[] segment = new Point[] { p, q, r, s };
                                Arrays.sort(segment);
                                retArr[segCount] = segment;
                                segCount++;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void printSegments() {
        for (int i = 0; i < segCount; i++) {
            String temp = "";
            for (int j = 0; j < 4; j++) {
                if (j > 0) {
                    temp += " -> ";
                }
                temp += retArr[i][j].toString();
            }
            StdOut.println(temp);
        }
    }

    public static void main(String[] args) {
        In in = new In();
        int n = in.readInt();
        retArr = new Point[n][4];
        points = new Point[n];
        size = n;
        end = (n % 4);
        for (int i = 0; i < n; i++) {
            int x = in.readInt(), y = in.readInt();
            points[i] = new Point(x, y);
        }
        findSegments();
        Arrays.sort(retArr, 0, segCount, new Comparator<Point[]>() {
            public int compare(Point[] line1, Point[] line2) {
                for (int i = 0; i < 4; i++) {
                    int res = line1[i].compareTo(line2[i]);
                    if (res != 0) {
                        return res;
                    }
                }
                return 0;
            }
        });
        printSegments();
    }
}
