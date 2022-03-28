package com.hastobe.csms.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class ChargingProcessInput implements Serializable {
    @ApiModelProperty(notes = "Rate to apply on CDR",name="rate",required=true)
    private Rate rate;
    @ApiModelProperty(notes = "(C)charge (D)detail (R)record",name="charge detail record",required=true)
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
