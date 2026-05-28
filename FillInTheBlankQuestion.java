public class FillInTheBlankQuestion extends Question {
    private String correctAnswer;

    // Constructor
    public FillInTheBlankQuestion(String text, String correctAnswer) {
        super(text); // call the parent Question constructor
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean checkAnswer(String answer) {
        // Compare ignoring case
        return answer.trim().equalsIgnoreCase(correctAnswer);
    }

    @Override
    public void displayQuestion() {
        System.out.println(getText());
        System.out.println("Type your answer:");
    }
}
