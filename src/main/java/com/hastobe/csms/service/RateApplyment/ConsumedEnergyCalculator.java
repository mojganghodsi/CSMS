package com.hastobe.csms.service.RateApplyment;

import com.hastobe.csms.model.ChargingProcessInput;
/***
 * Interface in order to calculate consumed energy
 */
public interface ConsumedEnergyCalculator {
    /***
     *default method calculate consumed energy(kW)
     * @param chargingProcessInput
     * @return Double, consumed energy(kW)
     */
    default Double calculateConsumedEnergy(ChargingProcessInput chargingProcessInput){
        return ((double)(chargingProcessInput.getCdr().getMeterStop() - chargingProcessInput.getCdr().getMeterStart()))/1000;
    }
}
