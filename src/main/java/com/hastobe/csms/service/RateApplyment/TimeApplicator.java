package com.hastobe.csms.service.RateApplyment;

import com.hastobe.csms.model.ChargingProcessInput;
import com.hastobe.csms.model.ChargingProcessOutput;

/**
 * @author mojgan
 * Time Applicator, one of node chains to apply time fee in rate to CDR
 */

public class TimeApplicator extends RateApplicator implements TransactionTimeCalculator{
    /***
     * apply time fee in rate to CDR
     * @param chargingProcessInput
     * @param chargingProcessOutput
     * @return if it there is any other node to continue through the chains
     */
    @Override
    public boolean apply(ChargingProcessInput chargingProcessInput, ChargingProcessOutput chargingProcessOutput) {
        if (chargingProcessInput.getRate()!=null)
            if (chargingProcessInput.getRate().getTime()!=null){
                Double transactionTime = calculateTransactionTime(chargingProcessInput);
                Double timeRate = chargingProcessInput.getRate().getTime();
                Double timeComponent = Math.round(transactionTime * timeRate * 1000.0) / 1000.0;
                chargingProcessOutput.setTimeComponent(timeComponent);
            }
        return checkNext(chargingProcessInput,chargingProcessOutput);
    }
}
