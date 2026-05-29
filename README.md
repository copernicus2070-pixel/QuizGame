QuizGame
 
An interactive Java quiz game that asks True/False, Multiple Choice, and Fill‑in‑the‑Blank questions.
The game includes a timer for each question, friendly feedback messages, and an automated Pull Request review pipeline using GitHub Actions.

Features

Multiple question types: True/False, Multiple Choice, Fill‑in‑the‑Blank

Timer that shows how long each answer took

Friendly feedback messages with encouragement and corrections

Randomized question order using Collections.shuffle()

Score Board

Automated PR review pipeline with GitHub Actions (compilation, sample input run, Checkstyle checks)

How to Run

Clone the repository:
git clone https://github.com/copernicus2070-pixel/QuizGame.git

Compile the program:
javac QuizGame.java

Run the game:
java QuizGame

Automated PR Review Pipeline

This project includes a GitHub Actions workflow that runs automatically when a Pull Request is opened.

The pipeline:

Compiles the Java code

Runs the quiz automatically using sample_input.txt

Checks code style with Checkstyle

Provides feedback directly in the Pull Request under the Checks tab

OOP concept covered

Classes & Objects  
Defined in Question (lines 8–25) and subclasses. Objects created in QuizGame.java (lines 70–110).

Encapsulation  
Private fields text and correctAnswer in Question (lines 10–11). Accessed via getText() and checkAnswer().

Inheritance  
Subclasses (TrueFalseQuestion, MultipleChoiceQuestion, FillInTheBlankQuestion) extend Question (line 3 in each file).

Polymorphism  
displayQuestion() overridden in each subclass. checkAnswer() overloaded in FillInTheBlankQuestion. Loop in QuizGame.java (lines 115–130) uses superclass references for dynamic binding.

Future Enhancements

Save results to a file for history tracking

Add more question categories and difficulty levels

Build a graphical user interface (GUI) version

Developer/Author

Developed by Abel Tilahun — Addis Ababa, Ethiopia

copernicus2070@gmail.com

 2026 
