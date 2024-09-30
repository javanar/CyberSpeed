package org.tuncer.scratch.game;

import org.tuncer.scratch.calculator.ResultProcessor;
import org.tuncer.scratch.config.GameConfig;
import org.tuncer.scratch.config.Symbol;
import org.tuncer.scratch.matrix.MatrixCreator;
import org.tuncer.scratch.output.Output;

import java.io.IOException;

public class Game {

    private final GameConfig gameConfig;

    public Game(final GameConfig gameConfig) {
        this.gameConfig = gameConfig;
    }

    public Output play(double bettingAmount) throws IOException {
        Symbol[][] symbolMatrix =  new MatrixCreator(gameConfig).create();
        return  new ResultProcessor(symbolMatrix, bettingAmount, gameConfig).process();
    }


}
