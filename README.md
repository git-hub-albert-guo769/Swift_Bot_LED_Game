# Simon Swift — Java Simon LED Game

**Simon Swift** is a simple, console-based implementation of the classic "Simon" memory game written in Java.  
The program simulates coloured LEDs and controller buttons via console messages and keyboard input. It's lightweight, requires no external libraries, and is intended for learning and demonstration.

---

## Features
- Classic Simon-style gameplay: a random colour is added each round and the player must repeat the full sequence.
- Console "LED" simulation using printed messages (`LED ON: RED`, `LED OFF`).
- Button-to-colour mapping: `A → RED`, `B → GREEN`, `X → BLUE`, `Y → YELLOW`.
- Score tracking and rounds.
- A "celebration" routine on game over that blinks colours and prints a playful robot-movement sequence.
- Clean, single-file Java implementation (`SimonGame.java`).

---

## Requirements
- Java Development Kit (JDK) 8 or later installed.
- Terminal / command line access.

---

## How to build & run

Open a terminal in the directory containing `SimonGame.java` (you already uploaded it) and run:

```bash
# Compile
javac SimonGame.java

# Run
java SimonGame
```

If you prefer an IDE (IntelliJ IDEA, Eclipse, VS Code with Java extensions), open the file as a Java project and run the `main` method from the `SimonGame` class.

---

## How to play

1. When the game starts it will display instructions and show the sequence of colours (simulated by printed `LED ON: <COLOUR>` messages).
2. After the sequence is shown, you'll be prompted to repeat it using the controller buttons:
   - `A` → RED
   - `B` → GREEN
   - `X` → BLUE
   - `Y` → YELLOW
3. Enter the sequence using the keys separated by spaces (or as one line) when prompted, for example:
   ```
   A B X Y
   ```
4. If you repeat the sequence correctly, you earn a point and the sequence grows by one new random colour.
5. The game continues until you make a mistake. On game over a celebration routine is shown and your final score is shown. 

---

## Example demonstration (eclipse console)

```
===== ROUND 1 =====
Current Score: 0
Watch the sequence...
LED ON: RED
LED OFF
Now repeat the sequence using A, B, X, Y:
> A
Correct! Your score is now: 1

===== ROUND 2 =====
Current Score: 1
Watch the sequence...
LED ON: RED
LED OFF
LED ON: GREEN
LED OFF
Now repeat the sequence using A, B, X, Y:
> A B
Correct! Your score is now: 2
...
Game Over!
Final Score: 5
=== CELEBRATION DIVE! ===
Blinking all colours in random order...
BLINK: GREEN
BLINK: RED
...
Moving forward 30cm at speed 50...
Turning right 60 degrees...
Moving forward another 30cm at speed 50...
```

---

## Code structure (single file `SimonGame.java`)
Key functions/methods in the file (brief):
- `main(String[] args)` — Program entry. Sets up the game loop, score, and handles rounds.
- `displayInstructions()` — Prints a help/instructions block explaining how to play and the button mapping.
- `getRandomColour()` — Returns one of `"RED"`, `"GREEN"`, `"BLUE"`, `"YELLOW"` at random.
- `displaySequence(List<String> sequence)` — Prints each colour as an "LED ON" message, then "LED OFF".
- `getUserInputs(Scanner scanner, List<String> sequence, List<String> userInputs)` — Reads user input (buttons), validates and compares against the sequence.
- `checkValidButton(char button)` — Validates that the entered character is one of `A`, `B`, `X`, `Y`.
- `mapButtonToColour(char button)` — Maps player button press to the corresponding colour string.
- `celebrationDive(int score)` — Shows a celebration sequence on game end, uses:
  - `blinkAllColoursRandomly()` — Blinks colours in random order (console messages).
  - Simulated robot movement messages (printed with pauses).
- `sleep(long millis)` — Helper to pause between printed messages.

---

## Future improvements
- Add timed input or difficulty levels (faster display, stricter timing).
- Replace text simulation with a GUI using Swing/JavaFX for real visual LEDs.
- Add persistent high-score saving (file or database).
- Add sound feedback using Java sound APIs.
- Add unit tests for core logic.

---

## License
This README and the example project are provided under the **MIT License** — feel free to reuse or adapt the code.

---

## Notes
- The program simulates hardware (LEDs and robot movements) using console output and `Thread.sleep(...)` calls. No external hardware is required.


