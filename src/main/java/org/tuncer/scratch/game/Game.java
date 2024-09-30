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
        Symbol[][] symbolMatrix = createScratch(gameConfig);
        return processResult(gameConfig, symbolMatrix, bettingAmount);
    }

    private Symbol[][] createScratch(GameConfig gameConfig) throws IOException {
        final MatrixCreator matrixCreator = new MatrixCreator(gameConfig);
        return matrixCreator.create();
    }

    private Output processResult(GameConfig gameConfig, Symbol[][] symbolMatrix, double bettingAmount) {
        ResultProcessor resultProcessor = new ResultProcessor(symbolMatrix, bettingAmount, gameConfig);
        return resultProcessor.process();
    }




}
