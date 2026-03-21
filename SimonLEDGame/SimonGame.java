import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SimonGame {

    // Random generator for colours
    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Display instructions
        displayInstructions();

        // 2. Initialise game state
        int score = 0;
        int round = 1;
        List<String> sequence = new ArrayList<>();
        List<String> userInputs = new ArrayList<>();
        boolean continueGame = true;

        // 3. Main game loop
        while (continueGame) {
            // Clear stored user inputs before new round
            userInputs.clear();

            System.out.println();
            System.out.println("===== ROUND " + round + " =====");
            System.out.println("Current Score: " + score);

            // Always add one random colour to the sequence each round
            String newColour = getRandomColour();
            sequence.add(newColour);

            // Display the colour sequence
            displaySequence(sequence);

            // Get user inputs and check them against the sequence
            boolean inputsCorrect = getUserInputs(scanner, sequence, userInputs);

            if (inputsCorrect) {
                // User completed the entire sequence correctly
                score = score + 1;
                System.out.println("Correct! Your score is now: " + score);

                // Celebration dive logic if score >= 5
                if (score >= 5) {
                    celebrationDive(score);
                }

                // Every 5 rounds ask if the user wants to continue
                if (round % 5 == 0) {
                    System.out.print("Do you want to continue? (Y/N): ");
                    String choice = scanner.nextLine().trim();

                    if (choice.equalsIgnoreCase("N")) {
                        System.out.println("See you again champ!");
                        System.out.println("Final Score: " + score);
                        continueGame = false;
                        // Exit program after displaying final score
                        break;
                    }
                }

                // Move to next round
                round = round + 1;

            } else {
                // Mismatch in sequence → Game Over
                System.out.println("Game Over!");
                System.out.println("Final Score: " + score);
                continueGame = false;
                // Loop will end and program terminates after showing final score
            }
        }

        scanner.close();
    }

    // --- Helper methods ---

    // Display game instructions to the user
    private static void displayInstructions() {
        System.out.println("Welcome to SIMON SWIFT (Console Version)!");
        System.out.println("The game will show you a sequence of colours.");
        System.out.println("Each round, one new colour is added to the sequence.");
        System.out.println("You must repeat the whole sequence in order.");
        System.out.println();
        System.out.println("Button to colour mapping:");
        System.out.println("  A -> RED");
        System.out.println("  B -> GREEN");
        System.out.println("  X -> BLUE");
        System.out.println("  Y -> YELLOW");
        System.out.println();
        System.out.println("Type A, B, X or Y for each step in the sequence.");
        System.out.println("If you make a mistake, the game is over.");
        System.out.println("Each correct round gives you +1 score.");
        System.out.println("At 5 or more points, the robot performs a celebration dive.");
        System.out.println("Every 5 rounds you can choose to QUIT or CONTINUE.");
        System.out.println("Good luck!");
        System.out.println();
    }

    // Generate one random colour name
    private static String getRandomColour() {
        int value = random.nextInt(4);
        switch (value) {
            case 0:
                return "RED";
            case 1:
                return "GREEN";
            case 2:
                return "BLUE";
            default:
                return "YELLOW";
        }
    }

    // Display the sequence one colour at a time with waits
    private static void displaySequence(List<String> sequence) {
        System.out.println("Watch the sequence...");
        for (String colour : sequence) {
            // Simulate LED turning on
            System.out.println("LED ON: " + colour);
            sleep(1000); // wait 1 second

            // Simulate LED turning off
            System.out.println("LED OFF");
            sleep(500); // wait 0.5 seconds
        }
        System.out.println("Now repeat the sequence using A, B, X, Y:");
    }

    // Get user inputs for the whole sequence.
    // Returns true if all inputs match, false on first mismatch.
    private static boolean getUserInputs(Scanner scanner,
                                         List<String> sequence,
                                         List<String> userInputs) {
        for (int index = 0; index < sequence.size(); index++) {
            boolean validInput = false;
            char button = ' ';

            // Only accept valid buttons A, B, X, Y
            while (!validInput) {
                System.out.print("Step " + (index + 1) + " - enter button (A/B/X/Y): ");
                String inputLine = scanner.nextLine().trim();

                if (inputLine.isEmpty()) {
                    System.out.println("Input cannot be empty. Try again.");
                    continue;
                }

                button = Character.toUpperCase(inputLine.charAt(0));

                validInput = checkValidButton(button);
                if (!validInput) {
                    System.out.println("Invalid button. Please press A, B, X or Y.");
                }
            }

            String colourPressed = mapButtonToColour(button);
            userInputs.add(colourPressed);

            // Compare to expected colour in sequence
            String expectedColour = sequence.get(index);
            if (!colourPressed.equals(expectedColour)) {
                // Mismatch → main program will handle Game Over
                System.out.println("Wrong colour! Expected: " + expectedColour
                        + ", but you pressed: " + colourPressed);
                return false;
            }
        }

        // All inputs matched the sequence
        return true;
    }

    // Check if button is one of A, B, X, Y
    private static boolean checkValidButton(char button) {
        return button == 'A' || button == 'B' || button == 'X' || button == 'Y';
    }

    // Map buttons to colour names
    private static String mapButtonToColour(char button) {
        switch (button) {
            case 'A':
                return "RED";
            case 'B':
                return "GREEN";
            case 'X':
                return "BLUE";
            case 'Y':
                return "YELLOW";
            default:
                // Should never happen if validation is correct
                return "UNKNOWN";
        }
    }

    // Celebration dive logic as in the pseudocode
    private static void celebrationDive(int score) {
        System.out.println();
        System.out.println("=== CELEBRATION DIVE! ===");

        // Blink LEDs in random order
        blinkAllColoursRandomly();

        // Set movement speed based on score
        int speed;
        if (score < 5) {
            speed = 40;
        } else if (score >= 10) {
            speed = 100;
        } else {
            speed = score * 10;
        }

        // Simulate moving in 'V' shape
        System.out.println("Moving forward 30cm at speed " + speed + "...");
        sleep(800);
        System.out.println("Turning right 60 degrees...");
        sleep(500);
        System.out.println("Moving forward another 30cm at speed " + speed + "...");
        sleep(800);

        // Blink LEDs again at the end
        blinkAllColoursRandomly();

        System.out.println("=== CELEBRATION END ===");
        System.out.println();
    }

    // Simulate blinking all colours randomly
    private static void blinkAllColoursRandomly() {
        String[] colours = {"RED", "GREEN", "BLUE", "YELLOW"};
        System.out.println("Blinking all colours in random order...");
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(colours.length);
            System.out.println("BLINK: " + colours[index]);
            sleep(200);
        }
    }

    // Simple sleep helper method
    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            // If interrupted, just continue without failing
            Thread.currentThread().interrupt();
        }
    }
}
