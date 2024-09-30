package org.tuncer.gameConfig;

import org.tuncer.configFile.GameConfig;
import org.tuncer.configFile.Symbols;

public class GameConfigurationDecorator {


    public GameConfig decorate(GameConfig gameConfig) {
        Symbols gameConfigSymbols = gameConfig.getSymbols();
        gameConfigSymbols.getA().setExplanation("A");
        gameConfigSymbols.getB().setExplanation("B");
        gameConfigSymbols.getC().setExplanation("C");
        gameConfigSymbols.getD().setExplanation("D");
        gameConfigSymbols.getE().setExplanation("E");
        gameConfigSymbols.getF().setExplanation("F");
        gameConfigSymbols.getMultiplyByTen().setExplanation("10x");
        gameConfigSymbols.getMultiplyByFive().setExplanation("5x");
        gameConfigSymbols.getPlusOneThousand().setExplanation("+1000");
        gameConfigSymbols.getPlusFiveHundred().setExplanation("+500");
        gameConfigSymbols.getMiss().setExplanation("miss");
        return gameConfig;
    }
}
