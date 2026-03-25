# Noughts & Crosses Swiftbot Software implementation

## Project overview

This project is a two-player Noughts & Crosses / Tic-Tac-Toe game built around a 3×3 physical board and a command-line interface (CLI). One player is the user, and the other is SwiftBot, which performs the robot-side board movement and visual feedback. The project was developed in two main stages: a software design phase and a software implementation phase. The design report defined the improved SRS, algorithm design, UI planning, and progress monitoring, while the implementation report shows how those ideas were translated into working code, testing, and development changes. fileciteturn1file7turn1file11turn1file12

## Development process

### Assignment 2 — Software design
The design stage focused on improving the original LLM-generated SRS so the requirements were clearer, more atomic, and easier to implement. It included:
- functional requirements
- non-functional requirements
- additional functionalities
- flowchart design
- UI design
- planning and monitoring with a Gantt chart fileciteturn1file10turn1file11

A major goal of that stage was to reorganise the requirements into a logical sequence so they could be turned into flowcharts, pseudocode, and a cleaner implementation later. The improved SRS also defined the CLI-based game, SwiftBot interaction, logging, calibration, undo, timer, and difficulty modes. fileciteturn1file7turn1file8turn1file14

### Assignment 3 — Software implementation
The implementation stage followed the improved SRS and turned the design into a playable program. The report explains that the implementation was refined from the earlier design by:
- keeping the main game logic, board handling, and robot interaction in organised classes
- adding colour-coded CLI output for readability
- handling dice rolls, registration, turns, logging, scoreboard updates, and end-of-round options
- using a threaded timer for medium/hard modes
- adding calibration and motion handling notes for SwiftBot movement
- testing the program with black-box test cases fileciteturn1file12turn1file17turn1file18turn1file19

## Core features

- Welcome screen and user registration
- SwiftBot button A start trigger
- Dice roll to decide who goes first and assign pieces
- User move input through the CLI
- SwiftBot move selection and physical movement
- Win / draw detection
- LED blink feedback for outcomes
- Round logging
- Scoreboard tracking across rounds
- Play again / quit controls
- Undo and timer features tied to difficulty mode
- Calibration-aware SwiftBot movement planning fileciteturn1file7turn1file8turn1file12turn1file17

## Development choices and changes

The implementation report states that the program was reorganised into multiple static classes in the same file to improve structure and follow single-responsibility ideas. It also notes that some parts changed from the original design, such as combining dice-roll comparison into the broader dice method and replacing the live countdown with a more reliable threaded timer. fileciteturn1file12turn1file19

The report also records a few practical limitations:
- input validation is not fully consistent everywhere
- the timer does not always display as a smooth single-line countdown
- some UI formatting could still be improved
- some planned behaviour, such as full calibration accuracy, still needs adjustment on real hardware fileciteturn1file12turn1file19

## How to run

The exact launch steps depend on the environment used for SwiftBot and Java, but the intended workflow is:
1. compile the Java source
2. run the program from the CLI
3. connect to SwiftBot when available
4. use the keyboard and/or SwiftBot buttons for interaction

The project was tested successfully in the university environment and includes both keyboard-only fallback behaviour and hardware-aware behaviour. fileciteturn1file18turn1file19

## Testing summary

The implementation report includes black-box testing for:
- welcome screen and registration
- dice rolls
- move validation
- occupied-square handling
- board updates
- SwiftBot movement and LED behaviour
- logging and scoreboard updates
- quit / restart controls
- undo, timer, and difficulty settings fileciteturn1file18turn1file19

Most core functional requirements were marked as passed, while some areas were partially successful or flagged for refinement, especially UI consistency, input validation consistency, and some aspects of calibration / motion / timer presentation. fileciteturn1file19

## Notes on the project structure

The design report is best read as the planning and specification stage, while the implementation report is the build-and-evaluate stage. Together, they show the full development pipeline:
- identify and refine requirements
- design flowcharts and UI
- implement the program
- test the result
- note remaining issues and improvements fileciteturn1file10turn1file11turn1file12turn1file17turn1file18turn1file19

## Acknowledgements

AI tools were used during development for SRS generation, flowchart planning, implementation guidance, and button/LED handling support. The reports cite ChatGPT and Claude as part of the development process. 

## Project files

- `noughts & crosses software design .pdf` — Assignment 2 design report
- `2523488_noughts & crosses_Guo_A.pdf` — Assignment 3 implementation report
