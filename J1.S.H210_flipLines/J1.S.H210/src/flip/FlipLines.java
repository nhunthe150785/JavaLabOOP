/*
 * Copyright(C) 2005, FPT University
 * J1.S.H210
 * LAB211 Assignment J1.S.H210
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 2021-09-13                   1.0            NguyenThiNhu                  First Implement
 */
package flip;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class contains methods for data input and printing results on demand.
 *
 * @author NguyenThiNhu
 */
public class FlipLines {

    /**
     * This method accepts as its parameter a Scanner for an input file and that
     * writes to the console the same file's contents with successive pairs of
     * lines reversed in order. An input file can have an odd number of lines,
     * then in which case the last line is printed in its original position
     *
     * @param file to flip
     */
    private void flipLines(Scanner file) {
        while (file.hasNextLine()) {  //Stop when there is no next line
            String line1 = file.nextLine();
            if (file.hasNextLine()) {
                System.out.println(file.nextLine());
            }
            System.out.println(line1);
        }
    }

    /**
     * This method checks the file and prints the results to the screen
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FlipLines flip = new FlipLines();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Input file name: ");
                String fileName = scanner.nextLine();  //Input file name
                if (fileName.endsWith(".txt")) {
                    File file = new File(fileName);
                    flip.flipLines(new Scanner(file));  //Print the result after flip lines
                    break;
                } else {  //if the user input is not a txt file, then re-enter it
                    System.out.println("The file is not in the correct format, please input again !");
                }
            } catch (FileNotFoundException e) {//If file not in txt format or file not found, please re-enter it
                System.out.println("File does not exist, please input again !");
            }
        }
    }

}
