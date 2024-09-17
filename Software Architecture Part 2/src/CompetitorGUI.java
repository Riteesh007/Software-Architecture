import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CompetitorGUI {
    private CompetitorList competitorList;

    public CompetitorGUI(CompetitorList competitorList) {
        this.competitorList = competitorList;
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Competitor GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);

        JButton viewDetailsButton = new JButton("View Details");
        JButton editDetailsButton = new JButton("Edit Details");
        JButton removeCompetitorButton = new JButton("Remove Competitor");

        panel.add(viewDetailsButton);
        panel.add(editDetailsButton);
        panel.add(removeCompetitorButton);

        viewDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int competitorNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter Competitor Number:"));
                Competitor competitor = competitorList.findCompetitor(competitorNumber);
                if (competitor != null) {
                    System.out.println(competitor.getFullDetails());  // Add this line for debugging
                    JOptionPane.showMessageDialog(null, competitor.getFullDetails());
                } else {
                    JOptionPane.showMessageDialog(null, "Competitor not found.");
                }
            }
        });


        editDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int competitorNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter Competitor Number:"));
                Competitor competitor = competitorList.findCompetitor(competitorNumber);
                if (competitor != null) {
                    String newName = JOptionPane.showInputDialog("Enter New Name:");
                    competitor.setName(newName);
                    JOptionPane.showMessageDialog(null, "Competitor details updated.");
                } else {
                    JOptionPane.showMessageDialog(null, "Competitor not found.");
                }
            }
        });

        removeCompetitorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int competitorNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter Competitor Number:"));
                competitorList.removeCompetitor(competitorNumber);
                JOptionPane.showMessageDialog(null, "Competitor removed.");
            }
        });

        // Make the JFrame visible
        frame.setVisible(true);
    }

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
