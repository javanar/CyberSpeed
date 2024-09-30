package org.tuncer.scratch;

import org.tuncer.Output;
import org.tuncer.configFile.GameConfig;
import org.tuncer.configFile.Symbol;
import org.tuncer.gameConfig.GameConfiguration;
import org.tuncer.gameConfig.GameConfigurationDecorator;

import java.io.IOException;

public class Play {

    private final String config;
    private final double bettingAmount;

    public Play(final String config, final double bettingAmount) {
        this.config = config;
        this.bettingAmount = bettingAmount;
    }

    public Output getResult() throws IOException {

        GameConfigurationDecorator gameConfigurationDecorator = new GameConfigurationDecorator();
        GameConfiguration gameConfiguration = new GameConfiguration(config, gameConfigurationDecorator);
        GameConfig gameConfig = gameConfiguration.getGameConfig();

        Scratch scratch = new Scratch(gameConfig);
        Symbol[][] symbolMatrix = scratch.scratch();

        ResultProcessor resultProcessor = new ResultProcessor(symbolMatrix, bettingAmount, gameConfig);
        return resultProcessor.process();
    }
}
