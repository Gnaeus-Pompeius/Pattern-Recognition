/* Brute.java examines 4 points at a time and checks whether they all lie on the same line
segment, printing out any such line segments to standard output. To check whether the 4 points p, q, r, and s
are collinear, check whether the slopes between p and q, between p and r, and between p and s are all equal.
The order of growth of the running time of your program should be O(N 4) in the worst case and it should
use space proportional to N.*/



/**********************************************************************
 *  Step 1.  Explain *briefly* how you implemented brute force.
 *           Describe how you implemented compareTo() and the
 *           slopeTo() methods in the Point data type.
 **********************************************************************/

By using 4x For loops. In the first for loop we initialize (int h as 0) and set the point 'p' to equal points[h] (the first x,y we got as input). in the second for loop we set 'q' to equal points[h + 1]. The third for loop we set 'r' equal to points[h + 2] we then compare the slopes of 'pq' and 'pr' to check if the slopes are equal, if they are not equal 'q' and 'r' go up by +1 until they finish checking every points then p goes up by +1 and it repeats until every combination of 4 points have been checked. If the slopes of 'pq' and 'pr' are equal we go to the fourth loop which has 's' equal to points[h + 3] and it check if 'pr' (third slope value) and 'ps' (fourth slope value) are equal, if it finds a match it adds these four points to a Point array and then sorts the array.

slopeTo() was implemented by getting 2 poins(x, y) and following the given formula that if x0 - x1 was equal to 0 and y0 - y1 was equal to zero it would return negative infinity (We would have a degenerate line). if y0 = y1 then it would return 0 since we would have a horizontal line. if x0 = x1 then it would return positive infinity since we would have a vertical line.

compareTo() was implemented by following the given formula that if and only if either y0 < y1 or if y0 = y1 and x0 < x1 meaning if either y0 was less than y1 or if y0 was equal to y1 and x0 was less than x1 it would return 1 otherwise it would return -1



/**********************************************************************
 *  Step 2.  Explain *briefly* how you implemented the sorting solution.
 *           What steps did you do to avoid printing permutations
 *           and subsegments?
 **********************************************************************/

We called Arrays.sort on the (2D) array that contained the that contained the arrays which each had 4 points which were collinear, from 0 to how many arrays the (2D) array contained essentially from 0 to how many sets of 4 collinear points we have and compared each value inside these sets and sorted in default order.



/**********************************************************************
 *  Empirical    Fill in the table below with actual running times in
 *  Analysis     seconds when reasonable (say 180 seconds or less).
 *               You can round to the nearest tenth of a second.
 *
 *  Estimate (using tilde notation) the running time (in seconds) of
 *  your two main functions as a function of the number of points N.
 *
 *  Explain how you derive any exponents.
 **********************************************************************/

    
      N       brute       sorting
 ---------------------------------
    150
    200
    300
    400
    800
   1600
   3200
   6400
  12800


Brute:    ~

Sorting:  ~




/**********************************************************************
 *  Theoretical   Give the order of growth of the worst-case running
 *                time of your programs as a function of N. Justify
 *                your answer briefly.
 **********************************************************************/

Brute:

for (int h = 0; h < size - end; h++) {                   -------------> O(N)        
   for (int i = h + 1; i < size - (end - 1); i++) {      -------------> O(N) 
       for (int j = i + 1; j < size - (end - 2); j++) {  -------------> O(N) 
           if (slopeqr == 0) {                            
               for (int k = j + 1; k < size; k++) {      -------------> O(N) 
                   if (slopers == 0) {                     
                                
 The worst-case running time for Brute is O(N^4)     

Sorting:

Arrays.sort(retArr, 0, segCount, new Comparator<Point[]>() {
            public int compare(Point[] line1, Point[] line2) {
                for (int i = 0; i < 4; i++) {                  -------------> O(N)
                    int res = line1[i].compareTo(line2[i]);
                    if (res != 0) {
                        return res;
                    }
                }
                return 0;
            }
        });

Worst case is O(N)

/**********************************************************************
 *  Known bugs / limitations. For example, if your program prints
 *  out different representations of the same line segment when there
 *  are 5 or more points on a line segment, indicate that here.
 **********************************************************************/



/**********************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 **********************************************************************/



/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/




/**********************************************************************
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 **********************************************************************/

Work was evenly split between the two group members.






/**********************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 **********************************************************************/
