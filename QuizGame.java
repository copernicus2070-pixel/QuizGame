import java.util.Scanner;

// Base Question class (Encapsulation + Classes/Objects)
class Question {
    private String text;
    private String answer;

    public Question(String text, String answer) {
        this.text = text;
        this.answer = answer;
    }


    public String getText() { return text; }
    public String getAnswer() { return answer; }

    // Polymorphism: overridden in subclasses
    public boolean checkAnswer(String response) {
        return response.equalsIgnoreCase(answer);
    }
}

// Subclass: Multiple Choice Question (Inheritance + Polymorphism)
class MultipleChoiceQuestion extends Question {
    private String[] options;

    public MultipleChoiceQuestion(String text, String answer, String[] options) {
        super(text, answer);
        this.options = options;
    }

    @Override
    public boolean checkAnswer(String response) {
        return response.equalsIgnoreCase(getAnswer());
    }

    public void displayOptions() {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i+1) + ". " + options[i]);
        }
    }
}

// Subclass: True/False Question (Inheritance + Polymorphism)
class TrueFalseQuestion extends Question {
    public TrueFalseQuestion(String text, String answer) {
        super(text, answer);
    }

    @Override
    public boolean checkAnswer(String response) {
        return response.equalsIgnoreCase(getAnswer());
    }
}

// Main Game Class
public class QuizGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Demonstrating Objects
        Question q1 = new MultipleChoiceQuestion(
            "Which planet is known as the Red Planet?",
            "Mars",
            new String[]{"Earth", "Mars", "Jupiter", "Venus"}
        );

        Question q2 = new TrueFalseQuestion(
            "The sun rises in the west. (True/False)",
            "False"
        );
        // Fill-in-the-Blank Questions
        FillInTheBlankQuestion q1 = new FillInTheBlankQuestion(
            "The capital of Ethiopia is _____.",
            "Addis Ababa"
        );

        FillInTheBlankQuestion q2 = new FillInTheBlankQuestion(
            "Java was originally developed by _____.",
            "Sun Microsystems"
        );

        // Add them to the list
        questions.add(q1);
        questions.add(q2);

        // Polymorphism: superclass reference to subclass objects
        Question[] quiz = {q1, q2};

        int score = 0;

        for (Question q : quiz) {
            System.out.println("\n" + q.getText());

            // Method overloading example: different ways to display questions
            if (q instanceof MultipleChoiceQuestion) {
                ((MultipleChoiceQuestion) q).displayOptions();
                System.out.print("Enter your answer: ");
                String response = sc.nextLine();
                if (q.checkAnswer(response)) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong!");
                }
            } else {
                System.out.print("Enter True/False: ");
                String response = sc.nextLine();
                if (q.checkAnswer(response)) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong!");
                }
            }
        }

        System.out.println("\nYour final score: " + score + "/" + quiz.length);
        sc.close();
    }
}

