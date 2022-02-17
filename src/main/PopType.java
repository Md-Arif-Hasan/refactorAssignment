package main;


public class PopType implements QuestionType{
    @Override
    public boolean matchCategory(int number) {
        return (number==0 || number==4 || number==8);
    }

    @Override
    public String retType() {
        return "Pop";
    }
}