package com.hastobe.csms.model;

import java.io.Serializable;
import java.util.Date;

public class CDR implements Serializable {
    private Long meterStart;
    private Date timestampStart;
    private Long meterStop;
    private Date timestampStop;

    public CDR() {
    }

    public CDR(Long meterStart, Date timestampStart, Long meterStop, Date timestampStop) {
        this.meterStart = meterStart;
        this.timestampStart = timestampStart;
        this.meterStop = meterStop;
        this.timestampStop = timestampStop;
    }

    public Long getMeterStart() {
        return meterStart;
    }

    public void setMeterStart(Long meterStart) {
        this.meterStart = meterStart;
    }

    public Date getTimestampStart() {
        return timestampStart;
    }

    public void setTimestampStart(Date timestampStart) {
        this.timestampStart = timestampStart;
    }

    public Long getMeterStop() {
        return meterStop;
    }

    public void setMeterStop(Long meterStop) {
        this.meterStop = meterStop;
    }

    public Date getTimestampStop() {
        return timestampStop;
    }

    public void setTimestampStop(Date timestampStop) {
        this.timestampStop = timestampStop;
    }
}
