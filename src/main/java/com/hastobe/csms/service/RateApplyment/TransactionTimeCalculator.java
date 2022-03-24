package com.hastobe.csms.service.RateApplyment;

import com.hastobe.csms.model.ChargingProcessInput;

/***
 * Interface in order to calculate transaction duration
 */
public interface TransactionTimeCalculator {
    /***
     * default method calculate transaction duration(hour)
     * @param chargingProcessInput
     * @return Double, transaction duration(hour)
     */
    default Double calculateTransactionTime(ChargingProcessInput chargingProcessInput){
        // transaction duration in seconds
        Long timeDifferenceInSec = (chargingProcessInput.getCdr().getTimestampStop().getTime() - chargingProcessInput.getCdr().getTimestampStart().getTime())/1000;
        int secInEveryHour = 60 * 60;
        // transaction duration in hour
        return ((double)timeDifferenceInSec/secInEveryHour);
    }
}
