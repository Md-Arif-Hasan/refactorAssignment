package main;

public class ScienceType implements QuestionType{
    @Override
    public boolean matchCategory(int number) {
        return (number==1 || number == 5 || number ==9);
    }

    @Override
    public String retType() {
        return "Science";
    }
}