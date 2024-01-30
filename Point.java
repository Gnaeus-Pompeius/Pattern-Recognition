package s2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;

/*************************************************************************
 * Compilation: javac Point.java Execution: Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 * @author Magnus M. Halldorsson, email: mmh@ru.is
 *************************************************************************/
public class Point implements Comparable<Point> {

    public final int x, y;

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new Comparator<Point>() {
        public int compare(Point o1, Point o2) {
            double s1 = slopeTo(o1);
            double s2 = slopeTo(o2);
            return Double.compare(s1, s2);
        }
    };


    // create the point (x, y)
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }


    /*
        Treat the slope
        of a horizontal line segment as positive zero; treat the slope of a vertical line segment as
        positive infinity; treat the slope of a degenerate line segment (between a point and itself)
        as negative infinity.

     */

    // slope between this point and that point
    public double slopeTo(Point that) {

        int xslope = (this.x - that.x);
        int yslope = (this.y - that.y);

        // Degenerate
        // if the points are equal
        if (xslope == 0 && yslope == 0) {
            return Double.NEGATIVE_INFINITY;
        }
        // Horizontal
        // if y0 = y1
        if (yslope == 0) {
            return 0;
        }
        // Vertical
        // if x0 = x1
        if (xslope == 0) {
            return Double.POSITIVE_INFINITY;
        }
        double slope = (double) yslope / xslope;
        return slope;

    }

    /**
     * Is this point lexicographically smaller than that one? comparing
     * y-coordinates and breaking ties by x-coordinates
     */


    /*

        if and only if either y0 < y1 or if y0 = y1 and x0 < x1.
    */
    public int compareTo(Point that) {
        if (that.y < this.y || (that.y == this.y && that.x < this.x)) {
            return 1;
        }
        else {
            return -1;
        }
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    public static void main(String[] args) {
        /*
         * Do not modify
         */
        In in = new In();
        Out out = new Out();
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt(), y = in.readInt();
            points[i] = new Point(x, y);
        }
        out.printf("Testing slopeTo method...\n");
        for (int i = 1; i < points.length; i++) {
            out.println(points[i].slopeTo(points[i - 1]));
        }
        out.printf("Testing compareTo method...\n");
        for (int i = 1; i < points.length; i++) {
            out.println(points[i].compareTo(points[i - 1]));
        }
        out.printf("Testing SLOPE_ORDER comparator...\n");
        for (int i = 2; i < points.length; i++) {
            out.println(points[i].SLOPE_ORDER.compare(points[i - 1],
                                                      points[i - 2]));
        }
    }
}
