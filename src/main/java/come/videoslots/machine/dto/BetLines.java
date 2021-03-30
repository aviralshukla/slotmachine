package come.videoslots.machine.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BetLines {

    private static final BetLine BET_LINE_1 = new BetLine("1", Arrays.asList(0, 3, 6, 9, 12));
    private static final BetLine BET_LINE_2 = new BetLine("2", Arrays.asList(1, 4, 7, 10, 13));
    private static final BetLine BET_LINE_3 = new BetLine("3", Arrays.asList(2, 5, 8, 11, 14));
    private static final BetLine BET_LINE_4 = new BetLine("4", Arrays.asList(0, 4, 8, 10, 12));
    private static final BetLine BET_LINE_5 = new BetLine("5", Arrays.asList(2, 4, 6, 10, 14));

    private static final List<BetLine> betLines;

    static {
        List<BetLine> allBetLines = new ArrayList<>();
        allBetLines.add(BET_LINE_1);
        allBetLines.add(BET_LINE_2);
        allBetLines.add(BET_LINE_3);
        allBetLines.add(BET_LINE_4);
        allBetLines.add(BET_LINE_5);

        betLines = Collections.unmodifiableList(allBetLines);
    }

    public static List<BetLine> getAllBetLines() {
        return betLines;
    }
}
