package com.company.characters;

public class Bastya extends Karakter{
    private String nev;
    public Bastya(String szin){
        super(szin);
        nev = "Bastya";
    }

    public String getName(){
        return nev;
    }

    public boolean validateRequestedMove(int currentLocation_X, int currentLocation_Y, int wantedLocation_X, int wantedLocation_Y, Karakter[][] table, String currentColor) {
        if(currentColor.equals("fekete")){
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
