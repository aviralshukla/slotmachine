package come.videoslots.machine.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class WinSituation {
    private final Double winAmount;
    private final BetLine betLine;
    private final int matchedPositions;
}

