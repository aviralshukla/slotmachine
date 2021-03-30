package come.videoslots.machine.utils;

import come.videoslots.machine.dto.Payline;
import come.videoslots.machine.dto.Symbol;
import come.videoslots.machine.dto.WinSituation;
import come.videoslots.machine.protocol.SlotActionResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ResponseBuilder {

    public static SlotActionResponse buildResponse(Double bet, List<WinSituation> wins, List<Symbol> board) {
        return SlotActionResponse.builder()
                .betAmount(bet)
                .totalWin(wins.stream().mapToDouble(WinSituation::getWinAmount).sum())
                .board(board.stream().map(Symbol::getName).collect(Collectors.joining(",")))
                .paylines(wins.stream().map(w ->
                        Payline.builder()
                                .betline(w.getBetLine().toString())
                                .matchedSymbols(w.getMatchedPositions())
                                .paylineWin(w.getWinAmount()).build())
                        .collect(Collectors.toList()))
                .build();
    }

}
