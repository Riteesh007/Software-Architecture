import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CompetitorList {
    private ArrayList<Competitor> competitors = new ArrayList<>();

    public void readCompetitorsFromFile(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            try {
                Competitor competitor = Competitor.parseCompetitor(line);
                competitors.add(competitor);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Error parsing data: " + e.getMessage());
            }
        }
        scanner.close();
    }


    public void checkInputFileErrors() {
        // Add your implementation to check for errors in the input file
    }

    public void printShortDetailsForAllCompetitors() {
        for (Competitor competitor : competitors) {
            System.out.println(competitor.getShortDetails());
        }
    }


    public void addCompetitor(Competitor competitor) {
        competitors.add(competitor);
    }

    public Competitor findCompetitor(int competitorNumber) {
        for (Competitor competitor : competitors) {
            if (competitor.getNumber() == competitorNumber) {
                return competitor;
            }
        }
        return null;
    }



    public void removeCompetitor(int competitorNumber) {
        Competitor competitorToRemove = findCompetitor(competitorNumber);
        if (competitorToRemove != null) {
            competitors.remove(competitorToRemove);
        }
    }

    public void generateFinalReport(String outputFileName) {
        // Implement the final report generation here
        // Call methods in this class or other classes as needed
    }
    public String getShortDetailsForCompetitor(int competitorNumber) {
        Competitor competitor = findCompetitor(competitorNumber);
        if (competitor != null) {
            return competitor.getShortDetails();
        } else {
            return "Competitor not found.";
        }
    }
    public void displayCompetitorsInGUI() {
        for (Competitor competitor : competitors) {
            System.out.println(competitor.getFullDetails());
        }
    }


}
