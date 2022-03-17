import java.util.*;

/*
update interface - description
more detail option - put a more detail option in the category objects
decide integral ones
movie object
storing movies
change main character and villain to protagonist and antagonist

add pro user account vs normal, dont ask all the questions
create movie object each iteration
create movie subclasses
change a rating functionality - add if previously rated per category to see what you did before

*/

public class Interface {
    static Database database;
    static User currentUser;

    public static void main(String[] args) {

        //System.out.println(plot.toString());

        Scanner scan = new Scanner(System.in);
        database = new Database();
        currentUser = new User(); // eventually add login/sign up functionality
        database.initializeNormalAccount(currentUser);
        // database.initializeProAccount(currentUser);
        boolean loginStatus = true;

        while (loginStatus == true) {

            System.out.println();
            System.out.println("Welcome to the Main Menu! (Please enter the option number you want)");
            System.out.println("1. Rate a Movie");
            System.out.println("2. Settings");
            System.out.println("3. Exit Program");

            int mainMenuOption = scan.nextInt();

            switch (mainMenuOption) {
                case 1: 
                    System.out.println("What genre are you rating? (Please enter the option number you want)");
                    System.out.println("1. Action/Adventure (live)");
                    System.out.println("2. Comedy (live)");
                    System.out.println("3. Drama (live)");
                    System.out.println("4. Return to Main Menu");
                    System.out.println("5. Exit Program");

                    int genreOption = scan.nextInt();

                    switch (genreOption) {
                        case 1: 
                        case 2:
                        case 3:
                            rateMovie(genreOption);
                            break;
                        case 4:
                            break;
                        case 5: 
                            loginStatus = false;
                            System.out.println("Goodbye!");
                            break;   
                        default:
                            System.out.println("Invalid input. Please enter the option number only.");
                            break; 
                    }

                    System.out.println("Returning to main menu...");
                    break;

                case 2:
                    System.out.println("Choose an account setting option:");
                    System.out.println("1. Standard Account");
                    System.out.println("2. Pro Account (access to more categories to rate)");

                    int settingOption = scan.nextInt();

                    switch (settingOption) {
                        case 1:
                            database.initializeNormalAccount(currentUser);
                            System.out.println("Your settings have been changed to a normal account!");
                            break;
                        case 2:
                            database.initializeProAccount(currentUser);
                            System.out.println("Your settings have been changed to a pro account!");
                            break;
                        default:
                            System.out.println("Invalid input. Please enter the option number only.");
                            break; 
                    }

                    System.out.println("Returning to main menu...");
                    break;

                case 3:
                    loginStatus = false;
                    System.out.println("Goodbye!");
                    break;
                
                default:
                    System.out.println("Invalid input. Please enter the option number only.");
                    break;
            
            } 
        }
        // scan.close();
    }

    public static void rateMovie(int input) { 

        Scanner scan = new Scanner(System.in);
        HashMap<String, Double> multipliers;

        if (input == 1)
            multipliers = currentUser.actionMultipliers;
        else if (input == 2)
            multipliers = currentUser.comedyMultipliers;
        else
            multipliers = currentUser.dramaMultipliers;

        double highestScore = 0;
        double userScore = 0;

        System.out.println();
        System.out.println("Rate each category on a 0.0-10.0 scale." + '\n' + "10 being the best you could ever hope for, 5 being completely neutral" + '\n' + "and 0 being the worst you could imagine.");
        System.out.println();

        for (Map.Entry<String, Category> entry : database.getCategories().entrySet()) {
            String key = entry.getKey(); // category name
            Category value = entry.getValue(); // category obj
            //System.out.println(key);

            if (multipliers.get(key) != 0) {

                System.out.println(value.toString());
                double answer = scan.nextDouble();

                userScore += answer * multipliers.get(key);
                highestScore += 10 * multipliers.get(key);
            }
        }

        userScore /= highestScore;
        userScore *= 10;
        userScore = Math.round(userScore * 100.0) / 100.0;

        System.out.println("Your Overall Rating is:");
        System.out.println(userScore + "/10");

    }
}