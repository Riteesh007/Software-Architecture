public class Category {
    private int awardCategoryId;
    private String categoryName;
    private String criteria;

    public Category(int awardCategoryId, String categoryName, String criteria) {
        this.awardCategoryId = awardCategoryId;
        this.categoryName = categoryName;
        this.criteria = criteria;
    }

    public void evaluateCompetitors() {
        // Your implementation for evaluating competitors in this category
    }

    public void announceWinners() {
        // Your implementation for announcing winners in this category
    }

    // Add other methods as needed
}
