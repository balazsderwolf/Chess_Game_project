package com.company.characters;

public class Futo extends Karakter{
    private String nev;
    public Futo(String szin){
        super(szin);
        nev = "Futo";
    }
    public String getName(){
        return nev;
    }
    public boolean validateRequestedMove(int currentLocation_X, int currentLocation_Y, int wantedLocation_X, int wantedLocation_Y, Karakter[][] table, String currentColor) {
        if (currentColor.equals("fekete")) {
            if (Math.abs(wantedLocation_X - currentLocation_X) == Math.abs(wantedLocation_Y - currentLocation_Y) && !table[wantedLocation_X][wantedLocation_Y].getColor().equals("fekete")) {
                if (currentLocation_X > wantedLocation_X && currentLocation_Y > wantedLocation_Y) {
                    int x = currentLocation_X - 1;
                    int y = currentLocation_Y - 1;
                    while (x > wantedLocation_X && y > wantedLocation_Y) {
                        if (!table[x][y].getColor().equals("neutral")) {
                            System.out.println("%nFuto cannot jump%n");
                            return false;
                        }
                        x--;
                        y--;
                    }
                    return true;
                } else if (currentLocation_X > wantedLocation_X && currentLocation_Y < wantedLocation_Y) {
                    int x = currentLocation_X - 1;
                    int y = currentLocation_Y + 1;
                    while (x > wantedLocation_X && y < wantedLocation_Y) {
                        if (!table[x][y].getColor().equals("neutral")) {
                            System.out.println("%nFuto cannot jump%n");
                            return false;
                        }
                        x--;
                        y++;
                    }
                    return true;
                } else if(currentLocation_X < wantedLocation_X && currentLocation_Y > wantedLocation_Y){
                    int x = currentLocation_X + 1;
                    int y = currentLocation_Y - 1;
                    while (x < wantedLocation_X && y > wantedLocation_Y) {
                        if (!table[x][y].getColor().equals("neutral")) {
                            System.out.println("%nFuto cannot jump%n");
                            return false;
                        }
                        x++;
                        y--;
                    }
                    return true;
                } else if(currentLocation_X < wantedLocation_X && currentLocation_Y < wantedLocation_Y){
                    int x = currentLocation_X + 1;
                    int y = currentLocation_Y + 1;
                    while (x < wantedLocation_X && y < wantedLocation_Y) {
                        if (!table[x][y].getColor().equals("neutral")) {
                            System.out.println("%nFuto cannot jump%n");
                            return false;
                        }
                        x++;
                        y++;
                    }
                    return true;
                }
            }
        }
        //feher
        else if (currentColor.equals("feher")) {
            if (Math.abs(wantedLocation_X - currentLocation_X) == Math.abs(wantedLocation_Y - currentLocation_Y) && !table[wantedLocation_X][wantedLocation_Y].getColor().equals("feher")) {
                if (currentLocation_X > wantedLocation_X && currentLocation_Y > wantedLocation_Y) {
                    int x = currentLocation_X - 1;
                    int y = currentLocation_Y - 1;
                    while (x > wantedLocation_X && y > wantedLocation_Y) {
                        if (!table[x][y].getColor().equals("neutral")) {
                            System.out.println("%nFuto cannot jump%n");
                            return false;
                        }
                        x--;
                        y--;
                    }
                    return true;
                } else if (currentLocation_X > wantedLocation_X && currentLocation_Y < wantedLocation_Y) {
                    int x = currentLocation_X - 1;
                    int y = currentLocation_Y + 1;
                    while (x > wantedLocation_X && y < wantedLocation_Y) {
                        if (!table[x][y].getColor().equals("neutral")) {
                            System.out.println("%nFuto cannot jump%n");
                            return false;
                        }
                        x--;
                        y++;
                    }
                    return true;
                } else if(currentLocation_X < wantedLocation_X && currentLocation_Y > wantedLocation_Y){
                    int x = currentLocation_X + 1;
                    int y = currentLocation_Y - 1;
                    while (x < wantedLocation_X && y > wantedLocation_Y) {
                        if (!table[x][y].getColor().equals("neutral")) {
                            System.out.println("%nFuto cannot jump%n");
                            return false;
                        }
                        x++;
                        y--;
                    }
                    return true;
                } else if(currentLocation_X < wantedLocation_X && currentLocation_Y < wantedLocation_Y){
                    int x = currentLocation_X + 1;
                    int y = currentLocation_Y + 1;
                    while (x < wantedLocation_X && y < wantedLocation_Y) {
                        if (!table[x][y].getColor().equals("neutral")) {
                            System.out.println("%nFuto cannot jump%n");
                            return false;
                        }
                        x++;
                        y++;
                    }
                    return true;
                }
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
