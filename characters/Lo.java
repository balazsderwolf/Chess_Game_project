package com.company.characters;

public class Lo extends Karakter {
    private String nev;

    public Lo(String szin) {
        super(szin);
        nev = "Lo";
    }
    public String getName(){
        return nev;
    }
    public boolean validateRequestedMove(int currentLocation_X, int currentLocation_Y, int wantedLocation_X, int wantedLocation_Y, Karakter[][] table, String currentColor) {
        if (currentColor.equals("fekete")) { //x axes+1 because this character can move foreward or attack x axes+1 and y axes +-1
            if ((wantedLocation_X - 2 == currentLocation_X || wantedLocation_X + 2 == currentLocation_X) && (wantedLocation_Y - 1 == currentLocation_Y || wantedLocation_Y + 1 == currentLocation_Y) && !table[wantedLocation_X][wantedLocation_Y].getColor().equals("fekete")) {
                //attack/simple move
                return true;
            } else if ((wantedLocation_X - 1 == currentLocation_X || wantedLocation_X + 1 == currentLocation_X) && (wantedLocation_Y - 2 == currentLocation_Y || wantedLocation_Y + 2 == currentLocation_Y) && !table[wantedLocation_X][wantedLocation_Y].getColor().equals("fekete")) {
                //attack/simple move
                return true;
            }
        } else if (currentColor.equals("feher")) {
            if ((wantedLocation_X - 2 == currentLocation_X || wantedLocation_X + 2 == currentLocation_X) && (wantedLocation_Y - 1 == currentLocation_Y || wantedLocation_Y + 1 == currentLocation_Y) && !table[wantedLocation_X][wantedLocation_Y].getColor().equals("feher")) {
                //attack/simple move
                return true;
            } else if ((wantedLocation_X - 1 == currentLocation_X || wantedLocation_X + 1 == currentLocation_X) && (wantedLocation_Y - 2 == currentLocation_Y || wantedLocation_Y + 2 == currentLocation_Y) && !table[wantedLocation_X][wantedLocation_Y].getColor().equals("feher")) {
                //attack/simple move
                return true;
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