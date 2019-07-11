package com.adidas;


import com.adidas.exceptions.MinimumWidthException;
import org.junit.jupiter.api.Test;

/**
 * @author rkomaristova
 */
public class AdidasAsciiLogo {

    /**
     * This field is only left for {@link this#test()} method, to be able to
     * print and see columns. When running {@link this#test()} method
     * {@link this#numberOfColumns} field can be changed to print as many
     * columns as you wish
     */
    private int width = 10;

    /**
     * This parameter allows to print as many columns as needed, not limiting to
     * three. {@link this#createAdidasAsciiLogo(int)} method could be refactored
     * to accept it as parameter, but then tests should be refactored too. Thus
     * it is left here as a field.
     */
    private int numberOfColumns = 3;

    /**
     * Same value used for the height of first column and for spaces between
     * columns, so one field is used for both
     */
    private int heightOfFirstColumnAndspaceValue;

    StringBuilder sb = new StringBuilder();

    public String createAdidasAsciiLogo(int width) throws MinimumWidthException {
        if (width < 2) {
            throw new MinimumWidthException("Expected width of 2, received: " + Integer.toString(width));
        }
        heightOfFirstColumnAndspaceValue = (int) Math.round(Math.sqrt(width));

        for (int cycle = 0; cycle < numberOfColumns; cycle++) {

            for (int i = 0; i < heightOfFirstColumnAndspaceValue; i++) {
                int frontSpaces = width * (numberOfColumns - cycle - 1) + i;

                sb.append(printColumn(width, frontSpaces));

                for (int j = 0; j < cycle; j++) {
                    sb.append(printColumn(width, heightOfFirstColumnAndspaceValue));
                }

                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /**
     * Helper method to print one piece of line, consisting of given number of spaces and symbols
     * 
     * @param spaces
     *            indicated how many spaces should be printed
     * @param width
     *            indicated how many symbols should be printed
     * @return piece of line, consisting of given number of spaces and symbols
     */
    private String printColumn(int width, int spaces) {
        StringBuilder sb = new StringBuilder();

        sb.append(new String(new char[spaces]).replace('\0', ' '));
        sb.append(new String(new char[width]).replace('\0', '@'));

        return sb.toString();
    }
    
    /**Test to enjoy the result of {@link this#createAdidasAsciiLogo(int)} method, especially with more than 3 columns printed :) */
    @Test
    public void test() throws MinimumWidthException {
        System.out.println(createAdidasAsciiLogo(width));
    }

    
    
    /* First thoughts variant */
//    public String createAdidasAsciiLogo(int width) throws MinimumWidthException {
//        if (width < 2) {
//            throw new MinimumWidthException("Expected width of 2, received: " + Integer.toString(width));
//        }
//        heightOfFirstColumnAndspaceValue = (int) Math.round(Math.sqrt(width));
//
//        widthOfLogo = width * 3 + heightOfFirstColumnAndspaceValue * 2 + heightOfFirstColumnAndspaceValue - 1;
//        backSpaces = heightOfFirstColumnAndspaceValue * 3 - 1;
//
//        for (int i = 0; i < heightOfFirstColumnAndspaceValue; i++) {
//            int currentPosition = 1;
//            int frontSpaces = width*2 + i;
//            while (currentPosition <= widthOfLogo - backSpaces) {
//                String symbol = currentPosition <= frontSpaces ? " " : "@";
//                sb.append(symbol);
//                currentPosition++;
//            }
//            backSpaces -= 1;
//            sb.append("\n");
//        }
//
//        for (int i = 0; i < heightOfFirstColumnAndspaceValue; i++) {
//            int currentPosition = 1;
//            int frontSpaces = width + i;
//            while (currentPosition <= widthOfLogo - backSpaces) {
//                String symbol = currentPosition <= frontSpaces || currentPosition > frontSpaces + width
//                        && currentPosition <= frontSpaces + width + heightOfFirstColumnAndspaceValue ? " " : "@";
//                sb.append(symbol);
//                currentPosition++;
//            }
//            backSpaces -= 1;
//            sb.append("\n");
//        }
//
//        for (int i = 0; i < heightOfFirstColumnAndspaceValue; i++) {
//            int currentPosition = 1;
//            int frontSpaces = 0 + i;
//            while (currentPosition <= widthOfLogo - backSpaces) {
//                String symbol = currentPosition <= frontSpaces
//                        || currentPosition > frontSpaces + width
//                                && currentPosition <= frontSpaces + width + heightOfFirstColumnAndspaceValue
//                        || currentPosition > frontSpaces + width * 2 + heightOfFirstColumnAndspaceValue
//                                && currentPosition <= frontSpaces + 2 * width + heightOfFirstColumnAndspaceValue * 2
//                                        ? " " : "@";
//                sb.append(symbol);
//                currentPosition++;
//            }
//            backSpaces -= 1;
//            sb.append("\n");
//        }
//        return sb.toString();
//
//    }

}
