import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Test change for PR pipeline
// Added comment to test pipeline
// Demo change for PR pipeline


// Base Question class
abstract class Question {
    private String text;
    private String correctAnswer;

    public Question(String text, String correctAnswer) {
        this.text = text;
        this.correctAnswer = correctAnswer;
    }

    public String getText() {
        return text;
    }

    public abstract void displayQuestion();

    public boolean checkAnswer(String answer) {
        return answer.trim().equalsIgnoreCase(correctAnswer);
    }
}

// True/False subclass
class TrueFalseQuestion extends Question {
    public TrueFalseQuestion(String text, String correctAnswer) {
        super(text, correctAnswer);
    }

    @Override
    public void displayQuestion() {
        System.out.println(getText() + " (True/False)");
    }
}

// Multiple Choice subclass
class MultipleChoiceQuestion extends Question {
    private String[] options;

    public MultipleChoiceQuestion(String text, String[] options, String correctAnswer) {
        super(text, correctAnswer);
        this.options = options;
    }

    @Override
    public void displayQuestion() {
        System.out.println(getText());
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }
}

// Fill-in-the-Blank subclass
class FillInTheBlankQuestion extends Question {
    private String correctAnswer;

    public FillInTheBlankQuestion(String text, String correctAnswer) {
        super(text, correctAnswer);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public void displayQuestion() {
        System.out.println(getText());
        System.out.println("Type your answer:");
    }

    @Override
    public boolean checkAnswer(String answer) {
        return answer.trim().equalsIgnoreCase(correctAnswer);
    }
}

// Main QuizGame program
public class QuizGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Question> questions = new ArrayList<>();
        int score = 0;

        // --- True/False Questions ---
        questions.add(new TrueFalseQuestion("The Earth is flat.", "False"));
        questions.add(new TrueFalseQuestion("Water boils at 100°C.", "True"));
        questions.add(new TrueFalseQuestion("The sun rises in the west.", "False"));

        // --- Multiple Choice Questions ---
        questions.add(new MultipleChoiceQuestion(
            "Which language is used for Android development?",
            new String[]{"Python", "Java", "C++", "Ruby"},
            "Java"
        ));

        questions.add(new MultipleChoiceQuestion(
            "Which planet is known as the Red Planet?",
            new String[]{"Earth", "Mars", "Jupiter", "Venus"},
            "Mars"
        ));

        questions.add(new MultipleChoiceQuestion(
            "Who wrote 'Hamlet'?",
            new String[]{"Charles Dickens", "William Shakespeare", "Mark Twain", "Jane Austen"},
            "William Shakespeare"
        ));

        // --- Fill-in-the-Blank Questions ---
        questions.add(new FillInTheBlankQuestion(
            "The capital of Ethiopia is _____.",
            "Addis Ababa"
        ));

        questions.add(new FillInTheBlankQuestion(
            "Java was originally developed by _____.",
            "Sun Microsystems"
        ));

        questions.add(new FillInTheBlankQuestion(
            "The chemical symbol for water is _____.",
            "H2O"
        ));

        // --- Shuffle questions ---
        Collections.shuffle(questions);

        // --- Run the quiz ---
for (Question q : questions) {
        q.displayQuestion();

    // Start timer before reading input
    long startTime = System.currentTimeMillis();
    String answer = scanner.nextLine();
    long endTime = System.currentTimeMillis();

    // Calculate time taken in seconds
    long timeTaken = (endTime - startTime) / 1000;

    // Friendly feedback with timer
    if (q.checkAnswer(answer)) {
        System.out.println("Correct! 🎉 You answered in " + timeTaken + " seconds.\n");
        score++;
    } else {
        System.out.println("Oops! ❌ The correct answer was not '" + answer + "'. You took " + timeTaken + " seconds.\n");
    }
}

        // --- Show final score ---
        System.out.println("Quiz finished! Your score: " + score + "/" + questions.size());
        scanner.close();
    }
}
