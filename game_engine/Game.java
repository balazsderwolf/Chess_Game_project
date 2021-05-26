package com.company.game_engine;

import com.company.GUI.GUI_COLORS;
import com.company.characters.*;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;


public class Game {
    Scanner scanner = new Scanner(System.in);
    //MEMBERS
    public Database db;
    private String currentColorPlayer;
    public Karakter[][] table;
    public final int[] validUserInputAnswers = new int[2];
    public String[] playersName = new String[2];

    //CONSTRUCTOR
    public Game() throws SQLException, ClassNotFoundException {
        this.currentColorPlayer = "feher";
        table = new Karakter[8][8];
        System.out.print(GUI_COLORS.YELLOW_BACKGROUND);
        System.out.println(GUI_COLORS.BLACK_BOLD + "Created new Game successfully" + GUI_COLORS.RESET);
        startNewGame();
        playersName = requestPlayersName();
        db = new Database(playersName);

    }

    public Karakter[][] getTable() {
        return table;
    }

    //GAMEFLOW
    public String[] requestPlayersName() {
        System.out.print("Choose a NICKNAME (Player 1): ");
        do {
            playersName[0] = scanner.nextLine();
        } while (playersName[0].length() == 0);

        System.out.print("\nChoose a NICKNAME (Player 2): ");

        do {
            playersName[1] = scanner.nextLine();
        } while (playersName[1].length() == 0);

        return playersName;
    }

    public void startNewGame() {
        // put Characters to the table
        Paraszt paraszt1 = new Paraszt("feher");
        Paraszt parasztA = new Paraszt("fekete");

        Bastya bastya1 = new Bastya("feher");
        Bastya bastyaA = new Bastya("fekete");

        Futo futo1 = new Futo("feher");
        Futo futoA = new Futo("fekete");

        Lo lo1 = new Lo("feher");
        Lo loA = new Lo("fekete");

        Kiraly kiraly1 = new Kiraly("feher");

        Kiraly kiralyA = new Kiraly("fekete");

        KirNo kirno1 = new KirNo("feher");

        KirNo kirnoA = new KirNo("fekete");

        Karakter neutral = new Karakter();

        table[0][0] = bastyaA;
        table[0][1] = loA;
        table[0][2] = futoA;
        table[0][3] = kiralyA;
        table[0][4] = kirnoA;
        table[0][5] = futoA;
        table[0][6] = loA;
        table[0][7] = bastyaA;

        table[7][0] = bastya1;
        table[7][1] = lo1;
        table[7][2] = futo1;
        table[7][3] = kiraly1;
        table[7][4] = kirno1;
        table[7][5] = futo1;
        table[7][6] = lo1;
        table[7][7] = bastya1;

        Arrays.fill(table[1], parasztA);
        Arrays.fill(table[6], paraszt1);
        Karakter empty = new Karakter();
        for (int i = 2; i < 6; i++) {
            Arrays.fill(table[i], empty);
        }


    }

    public void printGameTable() {

        final int SIZE = "Kiralyno".length();

        int j = 0; // numerate rows

        for (Karakter[] X : table) {

            System.out.println("");
            System.out.println("------------------------------------------------------------------------");
            for (Karakter Y : X) {
                if (Y.getName().equals("empty")) {
                    System.out.printf("     ");
                } else {
                    if (Y.getColor().equals("fekete")) {
                        System.out.printf(GUI_COLORS.RED + "%s" + GUI_COLORS.RESET, Y.getName());
                    } else {
                        System.out.printf("%s", Y.getName());
                    }

                }

                for (int i = 0; i < SIZE - Y.getName().length(); i++) {
                    System.out.printf(" ");
                }
                System.out.printf("|");

            }
            System.out.printf("  " + j);
            j++;
        }
        System.out.println("");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("   0        1        2        3        4        5        6        7     ");
        System.out.println("");
    }

    boolean validateInput(int x, int y) {
        return x >= 0 && x <= 7 && y >= 0 && y <= 7 && !table[x][y].getColor().equals("neutral");
    }

    int[] requestInputFromUserCurrentLocation() throws SQLException {
        //validate if this coordinate exist-> if not->loop
        // if yes->ask where to go


        int inputX;
        int inputY;
        boolean firstTry = true;
        do {
            if (!firstTry)
                System.out.println(GUI_COLORS.RED_BOLD + "Invalid coordinate, please try again (0-7)" + GUI_COLORS.RESET);
            System.out.print("Horizontal location (x axis): ");
            inputX = Integer.parseInt(scanner.nextLine());
            System.out.print("Vertical location (y axis): ");
            inputY = Integer.parseInt(scanner.nextLine());


            firstTry = false;
        } while (!validateInput(inputX, inputY));
        validUserInputAnswers[0] = inputX;
        validUserInputAnswers[1] = inputY;

        return validUserInputAnswers;
    }

    public void requestInputFromUserWhereToGo() throws SQLException {
        //if requestInputfromUser was successfull ask where to go
        //call characters moveTo method
        int[] locationCharacter = requestInputFromUserCurrentLocation();
        System.out.println("Where to move?");
        boolean firstTry = true;
        int inputWhere_X;
        int inputWhere_Y;
        do {
            if (!firstTry)
                System.out.println(GUI_COLORS.RED_BOLD + "Invalid coordinate, please try again (0-7)" + GUI_COLORS.RESET);
            System.out.print("Horizontal location (x axis): ");
            inputWhere_X = Integer.parseInt(scanner.nextLine());
            System.out.print("Horizontal location (x axis): ");
            inputWhere_Y = Integer.parseInt(scanner.nextLine());
            firstTry = false;
        } while (!table[locationCharacter[0]][locationCharacter[1]].validateRequestedMove(locationCharacter[0],
                locationCharacter[1],
                inputWhere_X,
                inputWhere_Y,
                table,
                currentColorPlayer));
        //moveTo()-> validating the relation between the current location and wanted location for the specific character
        table = table[locationCharacter[0]][locationCharacter[1]].moveTo(locationCharacter[0],
                locationCharacter[1],
                inputWhere_X,
                inputWhere_Y,
                table);


        //SAVE MOVE TO DATABASE
        if (currentColorPlayer.equals("feher")) {
            db.saveMoveToDB(playersName[0], inputWhere_X, inputWhere_Y);   //FEHER USER == 0th INDEX
        } else if (currentColorPlayer.equals("fekete")) {
            db.saveMoveToDB(playersName[1], inputWhere_X, inputWhere_Y);   //FEKETE USER == 1th INDEX
        }

        System.out.println(GUI_COLORS.GREEN + "Excelent move:)" + GUI_COLORS.RESET);

    }

    public void switchColor() {
        //after a successfully move-> next color's turn
        if (currentColorPlayer.equals("feher")) {
            currentColorPlayer = "fekete";
        } else if (currentColorPlayer.equals("fekete")) {
            currentColorPlayer = "feher";
        }
        System.out.printf(GUI_COLORS.BLUE_BOLD + "It's %s's turn", currentColorPlayer);
        System.out.println(GUI_COLORS.RESET);
    }

    void endGame() throws SQLException {
        //if checkmate or user want to quit->display winner and Goodby message
        System.out.printf("The Game ended successfully---THANK YOU %s and %s \n",playersName[0],playersName[10]);
        db.closeDataBase();

    }


}
