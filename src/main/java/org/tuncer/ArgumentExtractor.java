package org.tuncer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static org.tuncer.Constants.*;

public class ArgumentExtractor {

    private final String[] args;

    public ArgumentExtractor(final String[] args) {
        this.args =args;
    }

    public Map<String, String> extract() {
        List<String> arguments = List.of(args);
        if (arguments.size() %2 == 1) {
            throw new IllegalArgumentException("Invalid number of arguments");
        }

        if (arguments.size() < 4) {
            throw new IllegalArgumentException("Invalid number of arguments: At least 4 arguments expected");
        }

        if (arguments.stream().noneMatch((CLI_PARAM_PREFIX+CLI_CONFIG_PARAM_NAME)::equals)) {
            throw new IllegalArgumentException("Invalid arguments: Can not find config param");
        }

        if (arguments.stream().noneMatch((CLI_PARAM_PREFIX+CLI_BETTING_AMOUNT_PARAM_NAME)::equals)) {
            throw new IllegalArgumentException("Illegal arguments: Can not find betting amount");
        }

        if(!IntStream.range(0, arguments.size() / 2).map(i -> i * 2).allMatch(i -> arguments.get(i).startsWith(CLI_PARAM_PREFIX))) {
            throw new IllegalArgumentException("Illegal argument: Argument name(s) should start with --");
        }

        return IntStream.range(0, arguments.size())
                .filter(i -> i%2 == 0)
                .collect(
                        HashMap::new,
                        (m, i) -> m.put(arguments.get(i).replaceFirst(CLI_PARAM_PREFIX, ""), arguments.get(i + 1)),
                        Map::putAll
                );


    }
}
