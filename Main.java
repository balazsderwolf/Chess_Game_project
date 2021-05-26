package com.company;

import com.company.game_engine.Database;
import com.company.game_engine.Game;

import java.sql.SQLException;


public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Game game = new Game();
        // gameflow
        while (true) {
            boolean isError = false;
            game.printGameTable();
            //solve empty input / letter
            try {
                game.requestInputFromUserWhereToGo();
            } catch (NumberFormatException e) {
                isError = true;
                System.out.println("Input wasnt a number");
            } catch (ArrayIndexOutOfBoundsException ae) {
                System.out.println("Check the table index range (0-7)");
                isError = true;
            }
            if (!isError) {
                game.switchColor();
            }

        }
    }
}
