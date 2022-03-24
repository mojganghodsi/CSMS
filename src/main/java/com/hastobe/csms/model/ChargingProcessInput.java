package com.hastobe.csms.model;

import java.io.Serializable;

public class ChargingProcessInput implements Serializable {
    private Rate rate;
    private CDR cdr;

    public ChargingProcessInput() {
    }

    public ChargingProcessInput(Rate rate, CDR cdr) {
        this.rate = rate;
        this.cdr = cdr;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public CDR getCdr() {
        return cdr;
    }

    public void setCdr(CDR cdr) {
        this.cdr = cdr;
    }

}
