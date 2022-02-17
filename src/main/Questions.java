package main;


public class Questions {
    private String questionString;
    QuestionType type;

    public Questions(String questionString, QuestionType type) {
        this.questionString = questionString;
        this.type = type;
    }

    public String getQuestionString() {
        return questionString;
    }

    public void setQuestionString(String questionString) {
        this.questionString = questionString;
    }
}