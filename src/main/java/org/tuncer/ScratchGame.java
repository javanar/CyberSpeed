package org.tuncer;

import org.tuncer.scratch.Play;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import static org.tuncer.Constants.CLI_BETTING_AMOUNT_PARAM_NAME;
import static org.tuncer.Constants.CLI_CONFIG_PARAM_NAME;

/**
 * Scratch Game
 *
 */
public class ScratchGame
{

    public static void main( String[] args ) throws IOException {

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

        Play play = new Play(config, bettingAmount);
        Output output = play.getResult();

//        Arrays.stream(output.getMatrix()).flatMap(Arrays::stream).forEach(System.out::println);

        System.out.println(output);

    }
}
