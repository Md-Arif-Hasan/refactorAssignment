package main;


public class SportsType implements QuestionType{
    @Override
    public boolean matchCategory(int number) {
        return (number==2 || number==6 || number==10);
    }

    @Override
    public String retType() {
        return "Sports";
    }
}