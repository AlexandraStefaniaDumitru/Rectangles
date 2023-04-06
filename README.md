# Rectangles

This is a Java program that counts the number of rectangles parallel with the X, Y axes that can be formed using a set of coordinates provided by the user. 
The program reads from the console the coordinates as pairs of (x, y) separated by space and prints the found number of rectangles, with time complexity of O(n^2).
The algorithm is based on the idea that knowing the ends if one diagonal of a rectangle, P1(x1, y1) and P2(x2, y1), we can easily determine the ends of the other 
diagonal as being P3(x1, y2), P4(x2, y2), supposing that x1 is not equal to x2 and y1 is not equal to y2 (the ends of the rectangle's diagonal can not be on the same axix).

- Sample Input: (1, 1) (1, 3) (2, 1) (2, 3) (3, 1) (3, 3)  
Sample Output: 3  
- Sample Input: (1, 1) (1, 3) (2, 3) (3, 1) (3, 3)  
Sample Output: 1  
(tests have been written)

![image](https://user-images.githubusercontent.com/126579537/230212956-4ee656a9-612e-4f62-bc60-ddfc2093722b.png)
  

- Solution:  

I have defined a Coordinate class that represents a point on a two-dimensional plane, with an abscissa and an ordinate value, that overrides the "hashCode" and "equals"
methods.  

The Main class contains a "readCoordinates" function that reads the coordinates from the console as pairs of abscissa and ordinate values separeted by space,
and returns an ArrayList of Coordinate objects.
The "numberOfRectangles" function takes an ArrayList of Coordinate objects as input, initializes a hash set with the given coordinates, 
and then loops over all pairs of points in the set. 
For each pair of points, the function checks if they could form a diagonal by comparing their abscissa and ordinate values. 
If the values are different and the points could form a diagonal, the function calculates the coordinates of the other two points that would form a rectangle 
with the diagonal points, and checks if they are present in the input set. If they are, the function increments a counter for the number of rectangles.

Finally, the function returns the number of rectangles divided by four, since each group of 4 points is counted 4 times (once for each possible diagonal).

The main function of the Main class reads the coordinates from the console using the "readCoordinates" function, passes them to the "numberOfRectangles" function, 
and prints the result to the console.
