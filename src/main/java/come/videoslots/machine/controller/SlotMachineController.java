package come.videoslots.machine.controller;

import come.videoslots.machine.protocol.SlotActionRequest;
import come.videoslots.machine.protocol.SlotActionResponse;
import come.videoslots.machine.service.SlotMachineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/slots")
@Tag(name = "Slot Machine")
public class SlotMachineController {

    private final SlotMachineService slotMachineService;

    public SlotMachineController(SlotMachineService slotMachineService) {
        this.slotMachineService = slotMachineService;
    }

    @PostMapping
    @Operation(summary = "Send request", responses = {
            @ApiResponse(responseCode = "200", description = "Successfully processed the request"),
            @ApiResponse(responseCode = "500", description = "Error occurred while processing the request")
    })
    public ResponseEntity<SlotActionResponse> performAction(@Valid @RequestBody SlotActionRequest slotActionRequest) {
        return new ResponseEntity<>(slotMachineService.performAction(slotActionRequest), HttpStatus.OK);
    }

}
