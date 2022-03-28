package com.hastobe.csms.controller;

import com.hastobe.csms.model.ChargingProcessInput;
import com.hastobe.csms.model.ChargingProcessOutput;
import com.hastobe.csms.service.ChargingProcessService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author mojgan
 * Controller class
 *
 */
@RestController
@RequestMapping("/chargeprocess")
public class ChargingProcessController {

    ChargingProcessService chargingProcessService;

    /***
     * Injecting dependencies via constructor
     */
    @Autowired
    public ChargingProcessController(ChargingProcessService chargingProcessService) {
        this.chargingProcessService = chargingProcessService;
    }

    /***
     * Implemented restFull API to expose the charging process endpoint
     * @param chargingProcessInput
     * @return ResponseEntity<ChargingProcessOutput>
     */
    @ApiOperation(value = "start the charging process", response = Iterable.class, tags = "charge")
    @RequestMapping(value = "/charge", method = RequestMethod.POST)
    public ResponseEntity<ChargingProcessOutput> charge(@RequestBody ChargingProcessInput chargingProcessInput) {
        ChargingProcessOutput chargingProcessOutput =  chargingProcessService.charge(chargingProcessInput);
        return ResponseEntity.status(HttpStatus.OK).body(chargingProcessOutput);
        }
}
