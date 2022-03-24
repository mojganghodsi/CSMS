package com.hastobe.csms.service;

import com.hastobe.csms.model.ChargingProcessInput;
import com.hastobe.csms.model.ChargingProcessOutput;
import com.hastobe.csms.service.RateApplyment.EnergyApplicator;
import com.hastobe.csms.service.RateApplyment.RateApplicator;
import com.hastobe.csms.service.RateApplyment.TimeApplicator;
import com.hastobe.csms.service.RateApplyment.TransactionApplicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mojgan
 * main class of Service layer, endpoint of charging process in service layer
 *
 */
@Service
public class ChargingProcessService {
    /***
     * Injecting dependencies if needed via constructor
     */
    @Autowired
    public ChargingProcessService() {
    }

    /***
     * charge process
     * Implemented chain of responsibility pattern to apply the rate on CDR
     * calculate overall price
     * @param chargingProcessInput
     * @return ChargingProcessOutput
     */
    public ChargingProcessOutput charge(ChargingProcessInput chargingProcessInput){
        RateApplicator energyApplicator = new EnergyApplicator();
        RateApplicator timeApplicator = new TimeApplicator();
        RateApplicator transactionApplicator = new TransactionApplicator();
        ChargingProcessOutput chargingProcessOutput = new ChargingProcessOutput();
        energyApplicator.linkWith(timeApplicator);
        timeApplicator.linkWith(transactionApplicator);
        energyApplicator.apply(chargingProcessInput,chargingProcessOutput);
        calculateOverallPrice(chargingProcessOutput);
        return chargingProcessOutput;
    }

    void calculateOverallPrice(ChargingProcessOutput chargingProcessOutput){
        Double overallPrice = chargingProcessOutput.getComponents().getEnergy() +
                chargingProcessOutput.getComponents().getTime() +
                chargingProcessOutput.getComponents().getTransaction();
        chargingProcessOutput.setOverall(Math.round(overallPrice * 100.0) / 100.0);
    }
}
