package come.videoslots.machine.protocol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SlotActionRequest {
    @NotNull
    private Double betAmount;
    private Map<String, String> cheatCodes;
}
