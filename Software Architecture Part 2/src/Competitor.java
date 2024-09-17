import java.util.Arrays;

public abstract class Competitor {
    private int number;
    private String name;
    private int age;
    private String gender;
    private String country;
    private double overallScore;
    private int[] scores;

    public Competitor(int number, String name, int age, String gender, String country, int[] scores) {
        this.number = number;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.country = country;
        this.scores = scores;
        calculateOverallScore();
    }

    public static Competitor parseCompetitor(String line) {
        String[] parts = line.split(",");
        int number = Integer.parseInt(parts[0].trim());
        String name = parts[1].trim();
        int age = Integer.parseInt(parts[2].trim());
        String gender = parts[3].trim();
        String country = parts[4].trim();
        // Extract the scores from the array, skipping the first 5 elements
        int[] scores = Arrays.stream(parts).skip(5).mapToInt(Integer::parseInt).toArray();



        Competitor competitor;
        if (parts[5].trim().equals("Professional")) {
            competitor = new Athlete(number, name, age, gender, country, "", Arrays.copyOfRange(scores, 1, scores.length));
        } else {
            competitor = new EmergencyResponse(number, name, age, gender, country, Arrays.copyOfRange(scores, 1, scores.length));
        }

        competitor.calculateOverallScore();
        return competitor;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

    public double getOverallScore() {
        return overallScore;
    }

    void calculateOverallScore() {
        this.overallScore = Arrays.stream(scores).average().orElse(0);
    }
    public int[] getScores() {
        return scores;
    }




    public void setName(String newName) {
    }
    public String getShortDetails() {
        return "Competitor number " + number +
                ", name " + name +
                ", country " + country +
                ". Overall score: " + getOverallScore();
    }



    public String getFullDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Competitor number ").append(getNumber())
                .append(", name ").append(getName())
                .append(", country ").append(getCountry())
                .append(".\n")
                .append(getName()).append(" is a ").append(getLevel()).append(" aged ").append(getAge())
                .append(" and received these scores: ");

        for (int score : getScores()) {
            details.append(score).append(",");
        }

        details.deleteCharAt(details.length() - 1); // Remove the trailing comma
        details.append("\nThis gives him/her an overall score of ").append(String.format("%.1f", getOverallScore()));

        return details.toString();
    }




    public abstract String getLevel();


}




