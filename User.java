import java.util.*;
// implements Comparable<User>

public class User {
	private int id;
    private String username;
    private String password;
    public HashMap <String, Double> actionMultipliers;
    public HashMap <String, Double> comedyMultipliers;
    public HashMap <String, Double> dramaMultipliers;
    public PriorityQueue<Movie> ratedMovies;

    public User() {
        this.id = -1;
        this.username = "";
        this.password = "";
        this.actionMultipliers = new HashMap<>();
        this.comedyMultipliers = new HashMap<>();
        this.dramaMultipliers = new HashMap<>();
        this.ratedMovies = new PriorityQueue();
    }

    public User(int inputId, String inputUsername, String inputPassword) {
        this.id = inputId;
        this.username = inputUsername;
        this.password = inputPassword;
        this.actionMultipliers = new HashMap<>();
        this.comedyMultipliers = new HashMap<>();
        this.dramaMultipliers = new HashMap<>();
        this.ratedMovies = new PriorityQueue();
    }

}