package come.videoslots.machine.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class BetLine {
    private final String id;
    private final List<Integer> betLinePositions;
}
