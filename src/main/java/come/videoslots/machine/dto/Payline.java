package come.videoslots.machine.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payline {
    private String betline;
    private int matchedSymbols;
    private double paylineWin;
}
