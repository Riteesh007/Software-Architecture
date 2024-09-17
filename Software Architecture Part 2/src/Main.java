import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CompetitorList competitorList = new CompetitorList();

        try {
            // Read competitors from the file
            Scanner scanner = new Scanner(new File("C:/Users/user/Downloads/RunCompetitor.csv"));
            competitorList.readCompetitorsFromFile(scanner);

            // Close the scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred.");
            e.printStackTrace();
        }

        // Initialize the GUI after reading competitors from the file
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CompetitorGUI(competitorList);
            }
        });
    }
}


