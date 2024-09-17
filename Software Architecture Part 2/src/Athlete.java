import java.util.Arrays;

public class Athlete extends Competitor{

    private int competitorNumber;
    private String name;
    private String country;
    private String level;
    private int age;
    private int[] scores;

    // Constructor


    public Athlete(int number, String name, int age, String gender, String country, String level, int[] scores) {
        super(number, name, age, gender, country, scores);
        this.level = level;
        this.scores = scores;
        calculateOverallScore(); // Calculate overall score after setting scores
    }





    // Getter and Setter methods

    public int getCompetitorNumber() {
        return competitorNumber;
    }

    public void setCompetitorNumber(int competitorNumber) {
        this.competitorNumber = competitorNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String getLevel() {
        return ""; // You need to implement this method based on your Athlete class structure
    }



    public void setLevel(String level) {
        this.level = level;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Method to get the array of scores
    public int[] getScoreArray() {
        return scores;
    }




    // Method to get full details including scores
    @Override
    public String getFullDetails() {
        // Implement the details you want to display for the competitor
        // You can use the existing get methods to retrieve information
        // Example: Return a string containing competitor details
        return "Competitor number " + getNumber() +
                ", name " + getName() +
                ", age " + getAge() +
                ", gender " + getGender() +
                ", country " + getCountry() +
                ", overall score " + getOverallScore();
    }


    // Helper method to extract initials from the name
    private String getInitials() {
        String[] nameParts = name.split(" ");
        StringBuilder initials = new StringBuilder();
        for (String part : nameParts) {
            initials.append(part.charAt(0));
        }
        return initials.toString().toUpperCase();
    }
    @Override
    public String getShortDetails() {
        return super.getShortDetails() +
                ", level " + level;
    }
    @Override
    public double getOverallScore() {
        if (scores != null && scores.length > 0) {
            int sum = 0;
            for (int score : scores) {
                sum += score;
            }
            return (double) sum / scores.length;
        } else {
            return 0.0;
        }
    }

}
