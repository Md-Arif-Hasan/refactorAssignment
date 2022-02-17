package main;


public class Player {
    private String name;
    private int place;
    private int purse;
    private boolean penaltyBox;
    private boolean isGettingOutOfPenaltyBox;

    public Player(String name) {
        this.name = name;
        this.place=0;
        this.purse=0;
        this.penaltyBox=false;
        this.isGettingOutOfPenaltyBox=false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getPurse() {
        return purse;
    }

    public void setPurse(int purse) {
        this.purse = purse;
    }

    public boolean isPenaltyBox() {
        return penaltyBox;
    }

    public void setPenaltyBox(boolean penaltyBox) {
        this.penaltyBox = penaltyBox;
    }

    public boolean isGettingOutOfPenaltyBox() {
        return isGettingOutOfPenaltyBox;
    }

    public void setGettingOutOfPenaltyBox(boolean gettingOutOfPenaltyBox) {
        isGettingOutOfPenaltyBox = gettingOutOfPenaltyBox;
    }
    public boolean willMove(int number){
        return (((isPenaltyBox()) & (number%2!=0)) | !isPenaltyBox()) ;
    }
    public void move(int number){
        String status=getName()+" is not getting out of the penalty box";
        if(willMove(number)){
            setPlace((getPlace()+number)%12);
            status=getName()+"'s new location is "+ getPlace();
            setPenaltyBox(false);
        }
        System.out.println(status);
    }
    public boolean isWinner(){
        return (getPurse()>=6);
    }
}