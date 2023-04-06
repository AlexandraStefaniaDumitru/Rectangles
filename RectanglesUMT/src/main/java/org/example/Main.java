package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    // function that reads the coordinates from the console as (x, y), pairs of abscissa and ordinate, separated by space
    static ArrayList<Coordinate> readCoordinates() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter coordinates in the format of (x,y), separated by spaces:");
        String input = scanner.nextLine();

        String[] coordinateStrings = input.split(" ");

        ArrayList<Coordinate> coordinates = new ArrayList<>();

        for (String coordinateString : coordinateStrings) {
            coordinateString = coordinateString.replaceAll("\\s+|\\(|\\)", "");

            String[] values = coordinateString.split(",");
            int abscissa = Integer.parseInt(values[0]);
            int ordinate = Integer.parseInt(values[1]);
            coordinates.add(new Coordinate(abscissa, ordinate));
        }
        return coordinates;
    }

    // function that calculates the number of rectangles that can be created by the given points
    // the algorithm selects 2 points, let them be P1(x1,y1) and P2(x2,y2), that are assumed to be the ends of a diagonal
    // to obtain a rectangle, the other 2 points should have the coordinates P3(x1,y2), P4(x2,y1)
    // the algorithm checks if P3(x1,y2) and P4(x2,y1) are in the input and modifies the numberOfRectangles
    // complexity O(n^2)
    public static int numberOfRectangles(ArrayList<Coordinate> coordinates) {
        Set<Coordinate> set = new HashSet<>(coordinates);
        // initialize the numberOfRectangles with 0
        int numberOfRectangles = 0;

        // select P1(x1,y1) and P2(x2,y2) as the ends of a diagonal
        for (Coordinate p1 : coordinates) {
            for (Coordinate p2 : coordinates) {
                // check if x1 != x2 and y1 != y2 (a rectangle can not have the ends of a diagonal on the same axis)
                if (p1.abscissa != p2.abscissa && p1.ordinate != p2.ordinate) {
                    Coordinate p3 = new Coordinate(p1.abscissa, p2.ordinate);
                    Coordinate p4 = new Coordinate(p2.abscissa, p1.ordinate);
                    // check if P3(x1,y2) and P4(x2,y1) exist and increment the numberOfRectangles if positive
                    if (set.contains(p3) && set.contains(p4)) {
                        numberOfRectangles++;
                    }
                }
            }
        }
        // divide the numberOfRectangles by 4 (each group of 4 points will be taken 4 times into consideration, once for each possible diagonal)
        return numberOfRectangles / 4;
    }

    public static void main(String[] args) {

        ArrayList<Coordinate> coordinates = readCoordinates();
        System.out.print(numberOfRectangles(coordinates));
    }
}