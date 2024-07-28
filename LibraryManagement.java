import java.util.InputMismatchException;
import java.util.Scanner;

class Info {
    static int bookCount = 0;
    int id;
    String name;

    public void takeInfo(Scanner sc) {
        try {
            System.out.print("Enter your student ID: ");
            id = sc.nextInt();
            sc.nextLine(); // Consume newline left-over
            System.out.print("Enter your name: ");
            name = sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid student ID and name.");
            sc.next(); // Clear invalid input
            takeInfo(sc); // Recursively call the method to retry
        }
    }
}

class ListOfBook extends Info {
    public void show() {
        String[] array = {
                "UNITY by Harish Kumar",
                "EXPLORE by Anita Sharma",
                "ADVENTURE by Satish Kumar",
                "HAPPINESS by Anamica",
                "ONE IS ENOUGH by Shradhaa"
        };
        System.out.println("List of books:");
        for (int i = 0; i < array.length; i++) {
            System.out.println((i + 1) + ". " + array[i]);
        }
    }
}

class Issued extends ListOfBook {
    int choose;

    public void number(Scanner sc) {
        try {
            System.out.print("Choose a book to issue (enter the book number): ");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("You have issued: UNITY by Harish Kumar");
                    ++bookCount;
                    break;
                case 2:
                    System.out.println("You have issued: EXPLORE by Anita Sharma");
                    ++bookCount;
                    break;
                case 3:
                    System.out.println("You have issued: ADVENTURE by Satish Kumar");
                    ++bookCount;
                    break;
                case 4:
                    System.out.println("You have issued: HAPPINESS by Anamica");
                    ++bookCount;
                    break;
                case 5:
                    System.out.println("You have issued: ONE IS ENOUGH by Shradhaa");
                    ++bookCount;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid book number.");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid book number.");
            sc.next(); // Clear invalid input
            number(sc); // Recursively call the method to retry
        }
    }
}

public class LibraryManagement extends Issued {
    public static void main(String[] args) {
        LibraryManagement l = new LibraryManagement();
        Scanner sc = new Scanner(System.in);
        l.takeInfo(sc);
        l.show();
        l.number(sc);
        System.out.println("Number of books issued: " + bookCount);
        sc.close();
    }
}