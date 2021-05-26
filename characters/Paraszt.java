package com.company.characters;


public class Paraszt extends Karakter {
    private String nev;

    public Paraszt(String szin) {
        super(szin);
        nev = "Paraszt";
    }
    public String getName(){
        return nev;
    }
    public boolean validateRequestedMove(int currentLocation_X, int currentLocation_Y, int wantedLocation_X, int wantedLocation_Y, Karakter[][] table, String currentColor) {
        if (currentColor.equals("fekete")) { //x axes+1 because this character can move foreward or attack x axes+1 and y axes +-1
            if ((!table[wantedLocation_X][wantedLocation_Y].getColor().equals("neutral")) && ((wantedLocation_X - currentLocation_X) == 1) && (Math.abs(wantedLocation_Y - currentLocation_Y) == 1) && table[wantedLocation_X][wantedLocation_Y].getColor().equals("feher")) {
                //attack
                return true;
            } else if (table[wantedLocation_X][wantedLocation_Y].getColor().equals("neutral") && wantedLocation_X - currentLocation_X == 1 && currentLocation_Y == wantedLocation_Y) {
                //simple move
                return true;
            } else {
                //invalid move request
                return false;
            }

        } else if (currentColor.equals("feher")) { //same as by the black just with inverse (-1)
            if ((!table[wantedLocation_X][wantedLocation_Y].getColor().equals("neutral")) && ((wantedLocation_X - currentLocation_X) == -1) && (Math.abs(wantedLocation_Y - currentLocation_Y) == 1) && table[wantedLocation_X][wantedLocation_Y].getColor().equals("fekete")) {
                //attack
                return true;
            } else if (table[wantedLocation_X][wantedLocation_Y].getColor().equals("neutral") && wantedLocation_X - currentLocation_X == -1 && currentLocation_Y == wantedLocation_Y) {
                //simple move
                return true;
            } else {
                //invalid move request
                return false;
            }
        }
        return false;
    }

    public Karakter[][] moveTo(int currentLocation_X, int currentLocation_Y, int wantedLocation_X, int wantedLocation_Y, Karakter[][] table) {
        //make the move
        table[wantedLocation_X][wantedLocation_Y] = table[currentLocation_X][currentLocation_Y];
        table = deleteOldCoordinate(currentLocation_X, currentLocation_Y, table);

        return table;
    }


}
