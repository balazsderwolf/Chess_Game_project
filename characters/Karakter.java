package com.company.characters;

public class Karakter {
    private String szin;
    private String nev = "empty";

    public Karakter(){
        this.szin = "neutral";
    }
    Karakter(String szin){
        this.szin = szin;

    }
    public String getName(){
        return nev;
    }

    public Karakter[][] moveTo(int currentLocation_X,
                               int currentLocation_Y,
                               int wantedLocation_X,
                               int wantedLocation_Y, Karakter[][] table){
        Karakter[][] empty = new Karakter[8][8];
        System.out.println("Ganerated Problem-something went wrong, this is the superclass's moveTo");
        return empty;
    }

    public boolean validateRequestedMove(int currentLocation_X, int currentLocation_Y, int wantedLocation_X, int wantedLocation_Y, Karakter[][] table, String currentColor){
        System.out.println("Ganerated Problem-something went wrong, this is the superclass's valodateRequestedMove");
        return false;
    }

    void setColor(String color){
        szin = color;
    }

    public String getColor(){
        return szin;
    }

    Karakter[][] deleteOldCoordinate(int currentLocation_X,int currentLocation_Y,Karakter[][] table){
        Karakter nullObj = new Karakter("neutral");
        table[currentLocation_X][currentLocation_Y] = nullObj;
        return table;
    }
}
