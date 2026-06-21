package assignment;

public class Assignment {
    public static void main(String[] args) {

        Authentication auth = new Authentication();

        User loggedInUser = auth.Menu();

        System.out.println("Welcome " + loggedInUser.getUsername() + "!");

        MainMenu menu = new MainMenu(loggedInUser);
        menu.start();  
    }
}