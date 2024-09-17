public class EmergencyResponse extends Competitor {
    private int[] scores; // Add scores field to EmergencyResponse

    public EmergencyResponse(int number, String name, int age, String gender, String country, int[] scores) {
        super(number, name, age, gender, country, scores);
        // Set the scores for EmergencyResponse
        this.scores = scores;
    }

    @Override
    public String getFullDetails() {
        // Implement the details you want to display for EmergencyResponse
        // You can use the existing get methods to retrieve information
        // Example: Return a string containing EmergencyResponse details
        return "Competitor number " + getNumber() +
                ", name " + getName() +
                ", age " + getAge() +
                ", gender " + getGender() +
                ", country " + getCountry() +
                ", overall score " + getOverallScore();
    }

    @Override
    public String getShortDetails() {
        return super.getShortDetails(); // You can customize this if needed
    }
    @Override
    public String getLevel() {
        return "Emergency Responder";
    }
}
