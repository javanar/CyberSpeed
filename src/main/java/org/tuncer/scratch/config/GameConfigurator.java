package org.tuncer.scratch.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.tuncer.scratch.Main;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class GameConfigurator {

    private final String config;

    public GameConfigurator(String config) {
        this.config = config;
    }

    public GameConfig getGameConfig() throws IOException, URISyntaxException {
        ObjectMapper objectMapper = new ObjectMapper();

//        In order to get the file from resources directory
//        ClassLoader classLoader = getClass().getClassLoader();
//        File configFile = new File(classLoader.getResource(config).getFile());
//        Get the file from current directory
        File jarFile = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
        String inputFilePath = jarFile.getParent() + File.separator + config;
        File configFile = new File(inputFilePath);

        GameConfig gameConfig = objectMapper.readValue(configFile, GameConfig.class);
        return decorateGameConfig(gameConfig);
    }

    private GameConfig decorateGameConfig(GameConfig gameConfig) {
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
