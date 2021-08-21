import java.util.Scanner;

public class Main {

    public static void printX(int number) {
        int i = 0;
        while (i < number) {
            System.out.print("X ");
            i++;
        }
        System.out.println("");
    }

    public static void printSpaces(int number) {
        int i = 0;
        while (i < number) {
            System.out.print(" ");
            i++;
        }
    }

    public static void printTriangle(int size) {
        int i = 1;
        while (i <= size) {
            printSpaces(size - i);
            printX(i);
            i++;
        }
    }

    public static void printSquare(int size) {
        int i = 1;
        while (i <= size) {
            printX(size);
            i++;
        }

    }

    public static void printDiamond(int size) {
        int i = 1;
        int j = 1;

//        This part is similar to printing the triangle
        while (i <= size) {
            printSpaces(size - i);
            printX(i);
            i++;
        }

//        Once the triangle reaches desired size, do another loop but decrease the number of x's printed with each loop while printing more spaces
        while (i <= size + size - 1) {
            printSpaces(j);
            printX(i - (j * 2));
            j++;
            i++;
        }
    }

    public static boolean isAShape(String shape) {
        switch (shape) {
            case "triangle":
            case "square":
            case "diamond":
                return true;
            default:
                return false;
        }
    }

    public static boolean isCorrectSize(String size) {
//        Using the initial try-catch block to see if 'size' is an integer or not
        try {
            int x = Integer.parseInt(size);
            if (x > 1 && x < 100) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Using booleans to allow the prompts to reemerge at each stage in case the user types in an incorrect input
        boolean showPrompt1 = true;
        boolean showPrompt2 = true;
        while (showPrompt1) {
            showPrompt1 = false;
            System.out.println("What shape would you like to print?");
            String shape = scanner.nextLine();
//            If user inputs correct shape, show the second prompt, else show the first prompt again by resetting boolean value to true.
            if (isAShape(shape)) {
                while (showPrompt2) {
                    showPrompt2 = false;
                    System.out.println("How tall should the shape be? (must be greater than 1 and less than 100)");
                    String sizeString = scanner.nextLine();
                    if (isCorrectSize(sizeString)) {
                        int size = Integer.parseInt(sizeString);
                        switch (shape) {
                            case "triangle":
                                printTriangle(size);
                                break;
                            case "square":
                                printSquare(size);
                                break;
                            case "diamond":
                                printDiamond(size);
                                break;
                        }
                    } else {
                        System.out.println("Invalid input. Please ensure that the input is an integer between 3 and 99");
                        showPrompt2 = true;
                    }
                }
            } else if (!isAShape(shape)) {
                System.out.println("Shape not found. Please choose from the following: triangle, square, diamond");
                showPrompt1 = true;
                continue;
            }

//            Once input is printed and user breaks out of switch statement, ask to run again.
            boolean again = true;
            while (again) {
                again = false;
                System.out.println("Would you like to do it again?");
                String input = scanner.nextLine();
                if (input.equals("yes")) {

//                    If user wants to repeat, reset both boolean statements to true to run the 'while' loop again
                    showPrompt1 = true;
                    showPrompt2 = true;
                } else if (input.equals("no")) {
                    break;
                } else {
                    System.out.println("Invalid command. Please type 'yes' or 'no.'");

//                    If user inputs invalid command, 'again' is reset to true for the 3rd prompt to reemerge
                    again = true;
                }
            }
        }
    }
}

