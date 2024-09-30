package org.tuncer.gameConfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.tuncer.configFile.GameConfig;

import java.io.File;
import java.io.IOException;

public class GameConfiguration {

    private final String config;
    private final GameConfigurationDecorator gameConfigurationDecorator;

    public GameConfiguration(String config, GameConfigurationDecorator gameConfigurationDecorator) {
        this.config = config;
        this.gameConfigurationDecorator = gameConfigurationDecorator;
    }

    public GameConfig getGameConfig() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        // In order to get the file from resources directory
//        ClassLoader classLoader = getClass().getClassLoader();
//        File configFile = new File(classLoader.getResource(config).getFile());

        // Get the file from current directory
        File configFile = new File(config);

        GameConfig gameConfig = objectMapper.readValue(configFile, GameConfig.class);
        return gameConfigurationDecorator.decorate(gameConfig);
    }
}
