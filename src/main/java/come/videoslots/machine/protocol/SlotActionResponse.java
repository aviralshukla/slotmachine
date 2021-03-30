package come.videoslots.machine.protocol;

import come.videoslots.machine.dto.Payline;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SlotActionResponse {
    private String board;
    private Double betAmount;
    private Double totalWin;
    private List<Payline> paylines;
}
