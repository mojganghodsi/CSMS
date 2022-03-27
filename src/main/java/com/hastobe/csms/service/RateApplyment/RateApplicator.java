package com.hastobe.csms.service.RateApplyment;

import com.hastobe.csms.model.ChargingProcessInput;
import com.hastobe.csms.model.ChargingProcessOutput;

/**
 * @author mojgan
 * Rate Applicator, parent of node chains to apply rate to CDR
 * linke the nodes
 * proceed though the nodes
 */
public abstract class RateApplicator {
    private RateApplicator next;

    /***
     * Builds chains of ChargingProcess objects.
     * @param next
     * @return RateApplicator, node
     */
    public RateApplicator linkWith(RateApplicator next) {
        this.next = next;
        return next;
    }

    /***
     * Subclasses(chain nodes) will implement this method to apply rate.
     * @param chargingProcessInput
     * @param chargingProcessOutput
     * @return boolean
     */
    public abstract boolean apply(ChargingProcessInput chargingProcessInput, ChargingProcessOutput chargingProcessOutput);

    /***
     * Runs check on the next object in chain or ends traversing if we're in last object in chain.
     * @param chargingProcessInput
     * @param chargingProcessOutput
     * @return boolean
     */
    protected boolean checkNext(ChargingProcessInput chargingProcessInput, ChargingProcessOutput chargingProcessOutput) {
        if (next == null) {
            return true;
        }
        return next.apply(chargingProcessInput, chargingProcessOutput);
    }

    /***
     * add calculated price in the node to overall price
     * If it is the last node, calculate final overall in 2 floating point
     * @param chargingProcessOutput
     * @param inputPrice
     */
    void addPriceToOverAllPrice(ChargingProcessOutput chargingProcessOutput, Double inputPrice){
        if (next == null) {
            Double overall = chargingProcessOutput.getOverall() + inputPrice;
            chargingProcessOutput.setOverall(Math.round(overall * 100.0) / 100.0);
        }
        else
            chargingProcessOutput.setOverall(chargingProcessOutput.getOverall() + inputPrice);
    }
}
