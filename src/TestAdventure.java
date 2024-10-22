import java.io.FileNotFoundException;
import java.util.Arrays;

/**
 * This contains testing methods for the Adventure program.
 */
public class TestAdventure {

    /**
     * Uncomment testing methods to have them run.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        testParseCoordinates();
        testParseFields();
        testDetermineLocation();
        //testEnter();

    }

    /**
     * Tests for the parseCoordinates method.
     */
    private static void testParseCoordinates() {
        boolean error = false;

        {   //example test:
            String coordinateString = "20,6";
            int[] expected = new int[]{20, 6};
            int[] actual = Adventure.parseCoordinates(coordinateString);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testParseCoordinates 1) Expected: " + Arrays.toString(expected)
                        + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }
        {   //example test:
            String coordinateString = "10,6";
            int[] expected = new int[]{10, 6};
            int[] actual = Adventure.parseCoordinates(coordinateString);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testParseCoordinates 2) Expected: " + Arrays.toString(expected)
                        + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }

        {   //example test:
            String coordinateString = "200";
            int[] expected = null;
            int[] actual = Adventure.parseCoordinates(coordinateString);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testParseCoordinates 3) Expected: " + Arrays.toString(expected)
                        + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }

        {   //example test:
            String coordinateString = "public";
            int[] expected = null;
            int[] actual = Adventure.parseCoordinates(coordinateString);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testParseCoordinates 4) Expected: " + Arrays.toString(expected)
                        + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }

        {   //example test:
            String coordinateString = "8,  6";
            int[] expected = new int[]{8, 6};
            int[] actual = Adventure.parseCoordinates(coordinateString);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testParseCoordinates 5) Expected: " + Arrays.toString(expected)
                        + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }

        {   //example test:
            String coordinateString = "text,  6";
            int[] expected = null;
            int[] actual = Adventure.parseCoordinates(coordinateString);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testParseCoordinates 5) Expected: " + Arrays.toString(expected)
                        + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }

        {   //example test:
            String coordinateString = "";
            int[] expected = null;
            int[] actual = Adventure.parseCoordinates(coordinateString);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testParseCoordinates 6) Expected: " + Arrays.toString(expected)
                        + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }


        //Additional tests for testParseCoordinates


        if (error) {
            System.out.println("Error in testParseCoordinates.");
        } else {
            System.out.println("All tests in testParseCoordinates passed.");
        }
    }

    private static void testParseFields() {
        boolean error = false;

        {
            String fieldInformation = "size/This is the size of the map//";
            String[] expected = new String[]{"size", "This is the size of the map", "", ""};
            String[] actual = Adventure.parseFields(fieldInformation);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testParseFields 1) Expected: " + Arrays.toString(expected)
                        + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }

        {
            String fieldInformation = " //  /";
            String[] expected = new String[]{"","","",""};
            String[] actual = Adventure.parseFields(fieldInformation);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testParseFields 2) Expected: " + Arrays.toString(expected)
                        + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }

        {
            String fieldInformation = "*";
            String[] expected = new String[]{"*"};
            String[] actual = Adventure.parseFields(fieldInformation);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testParseFields 3) Expected: " + Arrays.toString(expected)
                        + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }

        if (error) {
            System.out.println("Error in testParseFields.");
        } else {
            System.out.println("All tests in testParseFields passed.");
        }
    }

    private static void testDetermineLocation() {
        boolean error = false;

        { //testing d direction
            int[] playerLocation = new int[]{3, 3};
            String[][][] testArray = new String[10][6][3];

            String direction = "d";
            int[] expected = new int[]{3, 4};
            int[] actual = Adventure.determineLocation(testArray, playerLocation, direction);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testDetermineLocation 1) Expected: " + Arrays.toString(expected)
                        + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }

        { //testing a direction
            int[] playerLocation = new int[]{3, 3};
            String[][][] testArray = new String[10][6][3];

            String direction = "a";
            int[] expected = new int[]{3, 2};
            int[] actual = Adventure.determineLocation(testArray, playerLocation, direction);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testDetermineLocation 2) Expected: " + Arrays.toString(expected)
                        + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }

        { //testing s direction
            int[] playerLocation = new int[]{3, 3};
            String[][][] testArray = new String[10][6][3];

            String direction = "s";
            int[] expected = new int[]{4, 3};
            int[] actual = Adventure.determineLocation(testArray, playerLocation, direction);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testDetermineLocation 3) Expected: " + Arrays.toString(expected)
                        + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }

        { //testing w direction
            int[] playerLocation = new int[]{3, 3};
            String[][][] testArray = new String[10][6][3];

            String direction = "w";
            int[] expected = new int[]{2, 3};
            int[] actual = Adventure.determineLocation(testArray, playerLocation, direction);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testDetermineLocation 4) Expected: " + Arrays.toString(expected)
                        + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }

        //the following four tests test wrapping in four directions

        { //testing w wrapping
            int[] playerLocation = new int[]{0, 3};
            String[][][] testArray = new String[10][6][3];

            String direction = "w";
            int[] expected = new int[]{9, 3};
            int[] actual = Adventure.determineLocation(testArray, playerLocation, direction);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testDetermineLocation 5) Expected: " + Arrays.toString(expected)
                        + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }

        { //testing s wrapping
            int[] playerLocation = new int[]{9, 3};
            String[][][] testArray = new String[10][6][3];

            String direction = "s";
            int[] expected = new int[]{0, 3};
            int[] actual = Adventure.determineLocation(testArray, playerLocation, direction);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testDetermineLocation 6) Expected: " + Arrays.toString(expected)
                        + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }

        { //testing d wrapping
            int[] playerLocation = new int[]{3, 5};
            String[][][] testArray = new String[10][6][3];

            String direction = "d";
            int[] expected = new int[]{3, 0};
            int[] actual = Adventure.determineLocation(testArray, playerLocation, direction);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testDetermineLocation 7) Expected: " + Arrays.toString(expected)
                        + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }

        { //testing a wrapping
            int[] playerLocation = new int[]{3, 0};
            String[][][] testArray = new String[10][6][3];

            String direction = "a";
            int[] expected = new int[]{3, 5};
            int[] actual = Adventure.determineLocation(testArray, playerLocation, direction);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testDetermineLocation 8) Expected: " + Arrays.toString(expected)
                        + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }

        if (error) {
            System.out.println("Error in testDetermineLocation.");
        } else {
            System.out.println("All tests in testDetermineLocation passed.");
        }
    }
}
