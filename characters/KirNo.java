package com.company.characters;

public class KirNo extends Karakter{
    private String nev;
    public KirNo(String szin){
        super(szin);
        nev = "Kiralyno";
    }
    public String getName(){
        return nev;
    }
    public boolean validateRequestedMove(int currentLocation_X, int currentLocation_Y, int wantedLocation_X, int wantedLocation_Y, Karakter[][] table, String currentColor) {
        if(currentColor.equals("fekete")){
            //bastya
            if(wantedLocation_X == currentLocation_X && !table[wantedLocation_X][wantedLocation_Y].getColor().equals("fekete")){
                if(currentLocation_Y>wantedLocation_Y){
                    for(int i = currentLocation_Y-1;i>wantedLocation_Y;i--){
                        if(!table[currentLocation_X][i].getColor().equals("neutral")){
                            System.out.println("%nBastya cannot jump%n");
                            return false;
                        }
                    }
                    return true;
                }
                else if(currentLocation_Y<wantedLocation_Y){
                    for(int i = currentLocation_Y+1;i<wantedLocation_Y;i++){
                        if(!table[currentLocation_X][i].getColor().equals("neutral")){
                            System.out.println("%nBastya cannot jump%n");
                            return false;
                        }
                    }
                    return true;
                }

            }else if(wantedLocation_Y == currentLocation_Y && !table[wantedLocation_X][wantedLocation_Y].getColor().equals("fekete")){
                if(currentLocation_X>wantedLocation_X){
                    for(int i = currentLocation_X-1;i>wantedLocation_X;i--){
                        if(!table[i][currentLocation_Y].getColor().equals("neutral")){
                            System.out.println("%nBastya cannot jump%n");
                            return false;
                        }
                    }
                    return true;
                }
                else if(currentLocation_X<wantedLocation_X){
                    for(int i = currentLocation_X+1;i<wantedLocation_X;i++){
                        if(!table[i][currentLocation_Y].getColor().equals("neutral")){
                            System.out.println("%nBastya cannot jump%n");
                            return false;
                        }
                    }
                    return true;
                }
            }
            //futo
            else if (Math.abs(wantedLocation_X - currentLocation_X) == Math.abs(wantedLocation_Y - currentLocation_Y) && !table[wantedLocation_X][wantedLocation_Y].getColor().equals("fekete")) {
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
        else if(currentColor.equals("feher")){
            if(wantedLocation_X == currentLocation_X && !table[wantedLocation_X][wantedLocation_Y].getColor().equals("feher")){
                if(currentLocation_Y>wantedLocation_Y){
                    for(int i = currentLocation_Y-1;i>wantedLocation_Y;i--){
                        if(!table[currentLocation_X][i].getColor().equals("neutral")){
                            System.out.println("%nBastya cannot jump%n");
                            return false;
                        }
                    }
                    return true;
                }
                else if(currentLocation_Y<wantedLocation_Y){
                    for(int i = currentLocation_Y+1;i<wantedLocation_Y;i++){
                        if(!table[currentLocation_X][i].getColor().equals("neutral")){
                            System.out.println("%nBastya cannot jump%n");
                            return false;
                        }
                    }
                    return true;
                }

            }else if(wantedLocation_Y == currentLocation_Y && !table[wantedLocation_X][wantedLocation_Y].getColor().equals("feher")){
                if(currentLocation_X>wantedLocation_X){
                    for(int i = currentLocation_X-1;i>wantedLocation_X;i--){
                        if(!table[i][currentLocation_Y].getColor().equals("neutral")){
                            System.out.println("%nBastya cannot jump%n");
                            return false;
                        }
                    }
                    return true;
                }
                else if(currentLocation_X<wantedLocation_X){
                    for(int i = currentLocation_X+1;i<wantedLocation_X;i++){
                        if(!table[i][currentLocation_Y].getColor().equals("neutral")){
                            System.out.println("%nBastya cannot jump%n");
                            return false;
                        }
                    }
                    return true;
                }
            }
            //futo
            else if (Math.abs(wantedLocation_X - currentLocation_X) == Math.abs(wantedLocation_Y - currentLocation_Y) && !table[wantedLocation_X][wantedLocation_Y].getColor().equals("feher")) {
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