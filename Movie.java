import java.util.*;

public class Movie {

    private int id;
    private double finalRating;
    public static Map<String,Double> ratingsMap;

    // default constructor
    public Movie() {
        this.id = -1;
        this.finalRating = -1;
        categoryMap = new HashMap<>();
    }

    // main constructor
    public Movie(String inputId) {
        this.id = inputId;
        this.finalRating = -1;
        ratingsMap = new HashMap<>();
    }

    public void addRating(String categoryName, Double userRating) {
        this.ratingsMap.put(categoryName, userRating);
    }

    // rating setter and getter
    public void setFinalRating(double inputR) {
        this.rating = inputR;
    }
    public double getFinalRating() {
        return this.rating;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        //result.append(this.name + "\n");
        //result.append(this.year + "\n");
        result.append("Overall Rating:" + this.rating);

        return result.toString();
    }

}