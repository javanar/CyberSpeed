package org.tuncer.scratch;

import org.tuncer.configFile.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Scratch {

    private final GameConfig gameConfig;

    public Scratch(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
    }

    public Symbol[][] scratch() throws IOException {



        BonusProbabilitySymbols bonusProbabilitySymbols = gameConfig.getProbabilities().getBonusSymbols().getSymbols();
        Symbols gameConfigSymbols = gameConfig.getSymbols();
        List<Symbol> weightedSymbolList = getWeightedSymbolList(bonusProbabilitySymbols, gameConfigSymbols);
        int totalBonusSymbolSeed = calculateTotalBonusSymbolSeed(bonusProbabilitySymbols);

        int rows = gameConfig.getRows();
        int columns = gameConfig.getColumns();

        List<StandardSymbolProbability> standardSymbolProbabilities = gameConfig.getProbabilities().getStandardSymbols();

        int seed = 0;
        Symbol[][]  matrix= new Symbol[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                for (StandardSymbolProbability standardSymbolProbability : standardSymbolProbabilities) {

                    if (standardSymbolProbability.getRow() == row && standardSymbolProbability.getColumn() == column) {

                        int totalStandardSymbolSeed = calculateTotalStandardSymbolSeed(standardSymbolProbability);
                        seed = totalBonusSymbolSeed + totalStandardSymbolSeed;

                        int probabilityA = standardSymbolProbability.getSymbols().getA();
                        for (int i = 0; i < probabilityA; i++) {
                            weightedSymbolList.add(gameConfigSymbols.getA());
                        }

                        int probabilityB = standardSymbolProbability.getSymbols().getB();
                        for (int i = 0; i < probabilityB; i++) {
                            weightedSymbolList.add(gameConfigSymbols.getB());
                        }

                        int probabilityC = standardSymbolProbability.getSymbols().getC();
                        for (int i = 0; i < probabilityC; i++) {
                            weightedSymbolList.add(gameConfigSymbols.getC());
                        }

                        int probabilityD = standardSymbolProbability.getSymbols().getD();
                        for (int i = 0; i < probabilityD; i++) {
                            weightedSymbolList.add(gameConfigSymbols.getD());
                        }

                        int probabilityE = standardSymbolProbability.getSymbols().getE();
                        for (int i = 0; i < probabilityE; i++) {
                            weightedSymbolList.add(gameConfigSymbols.getE());
                        }

                        int probabilityF = standardSymbolProbability.getSymbols().getF();
                        for (int i = 0; i < probabilityF; i++) {
                            weightedSymbolList.add(gameConfigSymbols.getF());
                        }

                    } else {

                        // Default Values if matrix index is not defined in config file

                        int totalStandardSymbolSeed = 21;
                        seed = totalBonusSymbolSeed + totalStandardSymbolSeed;

                        int probabilityA = 1;
                        for (int i = 0; i < probabilityA; i++) {
                            weightedSymbolList.add(gameConfigSymbols.getA());
                        }

                        int probabilityB = 2;
                        for (int i = 0; i < probabilityB; i++) {
                            weightedSymbolList.add(gameConfigSymbols.getB());
                        }

                        int probabilityC = 3;
                        for (int i = 0; i < probabilityC; i++) {
                            weightedSymbolList.add(gameConfigSymbols.getC());
                        }

                        int probabilityD = 4;
                        for (int i = 0; i < probabilityD; i++) {
                            weightedSymbolList.add(gameConfigSymbols.getD());
                        }

                        int probabilityE = 5;
                        for (int i = 0; i < probabilityE; i++) {
                            weightedSymbolList.add(gameConfigSymbols.getE());
                        }

                        int probabilityF = 6;
                        for (int i = 0; i < probabilityF; i++) {
                            weightedSymbolList.add(gameConfigSymbols.getF());
                        }
                    }

                }

                Random random = new Random();
                int draw = random.nextInt(seed);
                matrix[row][column] = weightedSymbolList.get(draw);
            }
        }

        return matrix;
    }

    private List<Symbol> getWeightedSymbolList(BonusProbabilitySymbols bonusProbabilitySymbols, Symbols gameConfigSymbols) {
        List<Symbol> weightedSymbolList = new ArrayList<>();

        int probabilityMultiplyByTen = bonusProbabilitySymbols.getMultiplyByTen();
        for(int i=0; i<probabilityMultiplyByTen;i++) {
            weightedSymbolList.add(gameConfigSymbols.getMultiplyByTen());
        }

        int probabilityMultiplyByFive = bonusProbabilitySymbols.getMultiplyByFive();
        for(int i=0; i<probabilityMultiplyByFive;i++) {
            weightedSymbolList.add(gameConfigSymbols.getMultiplyByFive());
        }

        int probabilityPlusOneThousand = bonusProbabilitySymbols.getPlusOneThousand();
        for(int i=0; i<probabilityPlusOneThousand;i++) {
            weightedSymbolList.add(gameConfigSymbols.getPlusOneThousand());
        }

        int probabilityPlusFiveHundred = bonusProbabilitySymbols.getPlusFiveHundred();
        for(int i=0; i<probabilityPlusFiveHundred;i++) {
            weightedSymbolList.add(gameConfigSymbols.getPlusFiveHundred());
        }

        int probabilityMiss = bonusProbabilitySymbols.getMiss();
        for(int i=0; i<probabilityMiss;i++) {
            weightedSymbolList.add(gameConfigSymbols.getMiss());
        }
        return weightedSymbolList;
    }

    private int calculateTotalBonusSymbolSeed(BonusProbabilitySymbols bonusProbabilitySymbols) {
        int seedMultiplyByTen = bonusProbabilitySymbols.getMultiplyByTen();
        int seedMultiplyByFive = bonusProbabilitySymbols.getMultiplyByFive();
        int seedPlusOneThousand = bonusProbabilitySymbols.getPlusOneThousand();
        int seedPlusFiveHundred = bonusProbabilitySymbols.getPlusFiveHundred();
        int seedMiss = bonusProbabilitySymbols.getMiss();

        return seedMultiplyByTen + seedMultiplyByFive + seedPlusOneThousand + seedPlusFiveHundred + seedMiss;

    }

    private int calculateTotalStandardSymbolSeed(StandardSymbolProbability standardSymbolProbability) {
        LetterSymbolProbabilities letterSymbolProbabilities = standardSymbolProbability.getSymbols();
        int probabilityLetterA = letterSymbolProbabilities.getA();
        int probabilityLetterB = letterSymbolProbabilities.getB();
        int probabilityLetterC = letterSymbolProbabilities.getC();
        int probabilityLetterD = letterSymbolProbabilities.getD();
        int probabilityLetterE = letterSymbolProbabilities.getE();
        int probabilityLetterF = letterSymbolProbabilities.getF();

        return probabilityLetterA + probabilityLetterB + probabilityLetterC
                + probabilityLetterD + probabilityLetterE + probabilityLetterF;
    }
}
