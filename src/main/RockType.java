package main;

public class RockType implements QuestionType{
    @Override
    public boolean matchCategory(int number) {
        return (number==3 || number==7 || number==11);
    }

    @Override
    public String retType() {
        return "Rock";
    }
}