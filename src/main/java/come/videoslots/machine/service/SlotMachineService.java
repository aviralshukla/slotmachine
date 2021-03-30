package come.videoslots.machine.service;

import come.videoslots.machine.dto.*;
import come.videoslots.machine.protocol.SlotActionRequest;
import come.videoslots.machine.protocol.SlotActionResponse;
import come.videoslots.machine.utils.BoardGenerator;
import come.videoslots.machine.utils.PayoutCalculator;
import come.videoslots.machine.utils.ResponseBuilder;
import come.videoslots.machine.utils.WinPosCalculator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SlotMachineService {

    private final BoardGenerator boardGenerator;

    public SlotMachineService(BoardGenerator boardGenerator) {
        this.boardGenerator = boardGenerator;
    }

    public SlotActionResponse performAction(SlotActionRequest slotActionRequest) {
        // Randomize the symbols
        List<Symbol> board = boardGenerator.generateBoard(slotActionRequest);
        Map<Integer, Symbol> flatBoard = boardGenerator.flatBoard(board);

        // Iterate over betlines
        List<WinSituation> wins = BetLines.getAllBetLines().stream()
                .map(betLine -> generateWinSituation(betLine, flatBoard, slotActionRequest.getBetAmount()))
                .collect(Collectors.toList());

        return ResponseBuilder.buildResponse(slotActionRequest.getBetAmount(), wins, board);
    }

    private WinSituation generateWinSituation(BetLine betLine, Map<Integer, Symbol> flatBoard, Double betAmount) {
        List<Symbol> symbolsOnPayline = betLine.getBetLinePositions().stream()
                .map(flatBoard::get).collect(Collectors.toList());

        int matchingPositions = WinPosCalculator.getMatchingPositionsOnBetLine(symbolsOnPayline);

        return WinSituation.builder()
                .betLine(betLine)
                .matchedPositions(matchingPositions)
                .winAmount(PayoutCalculator.getPayout(matchingPositions, betAmount))
                .build();

    }

}
