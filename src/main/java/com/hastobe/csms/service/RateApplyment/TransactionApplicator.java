package com.hastobe.csms.service.RateApplyment;

import com.hastobe.csms.model.ChargingProcessInput;
import com.hastobe.csms.model.ChargingProcessOutput;
/**
 * @author mojgan
 * Transaction Applicator, one of node chains to apply transaction fee in rate to CDR
 */
public class TransactionApplicator extends RateApplicator {
    /***
     * apply transaction fee in rate to CDR
     * @param chargingProcessInput
     * @param chargingProcessOutput
     * @return if it there is any other node to continue through the chains
     */
    @Override
    public boolean apply(ChargingProcessInput chargingProcessInput, ChargingProcessOutput chargingProcessOutput) {
        if (chargingProcessInput.getRate()!=null)
            if (chargingProcessInput.getRate().getTransaction()!=null){
                Double transactionComponent = chargingProcessInput.getRate().getTransaction();
                chargingProcessOutput.setTransactionComponent(transactionComponent);
                addPriceToOverAllPrice(chargingProcessOutput,transactionComponent);
            }
        return checkNext(chargingProcessInput,chargingProcessOutput);
    }
}
