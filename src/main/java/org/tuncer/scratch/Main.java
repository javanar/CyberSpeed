package org.tuncer.scratch;

import org.tuncer.scratch.config.GameConfig;
import org.tuncer.scratch.config.GameConfigurator;
import org.tuncer.scratch.game.Game;
import org.tuncer.scratch.output.Output;
import org.tuncer.scratch.output.OutputPrinter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

import static org.tuncer.scratch.Constants.CLI_BETTING_AMOUNT_PARAM_NAME;
import static org.tuncer.scratch.Constants.CLI_CONFIG_PARAM_NAME;

/**
 * Scratch Game
 *
 */
public class Main
{

    public static void main( String[] args ) throws IOException, URISyntaxException {

        ArgumentExtractor argumentExtractor = new ArgumentExtractor(args);
        Map<String, String> argumentsMap = argumentExtractor.extract();

        String bettingAmountString = argumentsMap.get(CLI_BETTING_AMOUNT_PARAM_NAME);

        double bettingAmount;
        try {
            bettingAmount = Double.parseDouble(bettingAmountString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Betting amount should be a number");
        }

        String config = argumentsMap.get(CLI_CONFIG_PARAM_NAME);

        GameConfig gameConfig = new GameConfigurator(config).getGameConfig();
        Game game = new Game(gameConfig);
        Output output = game.play(bettingAmount);

        OutputPrinter outputPrinter = new OutputPrinter(output);
        System.out.println(outputPrinter.json());

    }
}
