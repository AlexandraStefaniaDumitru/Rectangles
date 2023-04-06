import org.example.Coordinate;
import org.example.Main;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void numberOfRectangles() {
        ArrayList<Coordinate> coordinates1 = new ArrayList<>();
        coordinates1.add(new Coordinate(1, 1));
        coordinates1.add(new Coordinate(1, 3));
        coordinates1.add(new Coordinate(2, 1));
        coordinates1.add(new Coordinate(2, 3));
        coordinates1.add(new Coordinate(3, 1));
        coordinates1.add(new Coordinate(3, 3));
        int result1 = Main.numberOfRectangles(coordinates1);
        assertEquals (3, result1);


        ArrayList<Coordinate> coordinates2 = new ArrayList<>();
        coordinates2.add(new Coordinate(1, 1));
        coordinates2.add(new Coordinate(1, 3));
        coordinates2.add(new Coordinate(2, 3));
        coordinates2.add(new Coordinate(3, 1));
        coordinates2.add(new Coordinate(3, 3));
        int result2 = Main.numberOfRectangles(coordinates2);
        assertEquals (1,result2);
    }
}