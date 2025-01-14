package io.zipcoder.casino.Menus;

import io.zipcoder.casino.utilities.CasinoArt;
import io.zipcoder.casino.PlayerCreation.Player;
import io.zipcoder.casino.utilities.Console;

public class Casino {
    private Player currentPlayer;
    private Console console = new Console(System.in, System.out);
    private CasinoArt art = new CasinoArt();
    private boolean running = true;

    public void runCasinoMenu(Player currentPlayer){
        this.currentPlayer = currentPlayer;
        while(running) {
            Console.clearScreen();
            console.println(art.getCasinoArt(CasinoArt.Art.CASINOLOBBY));
            System.out.println(String.format("Welcome to The Notorious B.I.G. 3 Casino, %s!", currentPlayer.getName()));
            Console.displayCasinoMenu();
            Integer playerInput = console.getIntegerInput(":");
            casinoMenuLogic(playerInput);
        }
    }

    public void casinoMenuLogic(Integer playerInput){
        switch (playerInput){
            case 1:
                GameMenu gameMenu = new GameMenu();
                gameMenu.runGameMenu(currentPlayer);
                break;
            case 2:
                console.println(String.format("Your current balance is $%d.00.\n\n", currentPlayer.getBalance()));
                console.getStringInput("Press Enter to return to menu");
                break;
            case 3:
                if(currentPlayer.getHistory().isEmpty()){
                    console.println("Sorry! You do not yet have a gaming history. Play some games to get one!\n\n");
                    console.getStringInput("Press Enter to return to menu");
                } else {
                    console.println(currentPlayer.printHistory());
                    console.getStringInput("Press Enter to return to menu");
                }
                break;
            case 4:
                console.println("Thank you for visiting The Notorious B.I.G. 3!");
                running = false;
                break;
        }
    }
}
