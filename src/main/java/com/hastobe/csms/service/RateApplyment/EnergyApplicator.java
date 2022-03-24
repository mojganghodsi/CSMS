package com.hastobe.csms.service.RateApplyment;

import com.hastobe.csms.model.ChargingProcessInput;
import com.hastobe.csms.model.ChargingProcessOutput;

/**
 * @author mojgan
 * Energy Applicator, one of node chains to apply energy fee in rate to CDR
 */
public class EnergyApplicator extends RateApplicator implements ConsumedEnergyCalculator {
    /***
     * apply energy fee in rate to CDR
     * @param chargingProcessInput
     * @param chargingProcessOutput
     * @return if it there is any other node to continue through the chains
     */
    @Override
    public boolean apply(ChargingProcessInput chargingProcessInput, ChargingProcessOutput chargingProcessOutput) {
        if (chargingProcessInput.getRate()!=null)
            if (chargingProcessInput.getRate().getEnergy()!=null){
                Double consumedEnergy = calculateConsumedEnergy(chargingProcessInput);
                Double energyRate = chargingProcessInput.getRate().getEnergy();
                Double energyComponent = Math.round(consumedEnergy * energyRate * 1000.0) / 1000.0;
                chargingProcessOutput.setEnergyComponent(energyComponent);
            }
        return checkNext(chargingProcessInput,chargingProcessOutput);
    }
}
