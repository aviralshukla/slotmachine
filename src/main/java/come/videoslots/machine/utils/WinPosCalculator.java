package come.videoslots.machine.utils;

import come.videoslots.machine.dto.BetLine;
import come.videoslots.machine.dto.Symbol;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinPosCalculator {

    public static int getMatchingPositionsOnBetLine(List<Symbol> symbolsOnPayline) {
        int matchedPositions = 1;
        String firstSymbol = symbolsOnPayline.get(0).getName();
        if (firstSymbol.equals(symbolsOnPayline.get(1).getName())) {
            matchedPositions++;
            if (firstSymbol.equals(symbolsOnPayline.get(2).getName())) {
                matchedPositions++;
                if (firstSymbol.equals(symbolsOnPayline.get(3).getName())) {
                    matchedPositions++;
                    if (firstSymbol.equals(symbolsOnPayline.get(4).getName())) {
                        matchedPositions++;
                    }
                }
            }
        }
        return matchedPositions;
    }

}
