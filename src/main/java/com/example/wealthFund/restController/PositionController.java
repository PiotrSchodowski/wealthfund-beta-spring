package com.example.wealthFund.restController;

import com.example.wealthFund.dto.positionDtos.AddPositionDto;
import com.example.wealthFund.dto.positionDtos.SubtractPositionDto;
import com.example.wealthFund.dto.positionDtos.UndoPositionDto;
import com.example.wealthFund.service.PositionManager;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
@Tag(name = "5 Position Management", description = "adding, decreasing and undoing positions")
@RestController
public class PositionController {

    private final PositionManager positionManager;


    public PositionController(PositionManager positionManager) {
        this.positionManager = positionManager;
    }

    @PostMapping("/user/{userName}/wallet/{walletName}/position")
    public AddPositionDto addPosition(@PathVariable String userName,
                                      @PathVariable String walletName,
                                      @RequestBody AddPositionDto addPositionDto) {
        return positionManager.addPosition(userName, walletName, addPositionDto);
    }

    @PutMapping("/user/{userName}/wallet/{walletName}/position/decrease")
    public SubtractPositionDto decreasePosition(@PathVariable String userName,
                                                @PathVariable String walletName,
                                                @RequestBody SubtractPositionDto subtractPositionDto) {
        return positionManager.subtractPosition(userName, walletName, subtractPositionDto);
    }

    @DeleteMapping("/user/{userName}/wallet/{walletName}/position/{id}/undo")
    public UndoPositionDto undoOperation(@PathVariable String userName,
                                         @PathVariable String walletName,
                                         @PathVariable Long id) {
        return positionManager.undoOperation(userName, walletName, id);
    }


}
