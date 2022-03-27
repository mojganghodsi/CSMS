package com.hastobe.csms.model;

import java.io.Serializable;

public class ChargingProcessOutput implements Serializable {
    private Double overall = 0.0;
    private Components components = new Components();

    public ChargingProcessOutput() {
    }

    public ChargingProcessOutput(Double overall, Components components) {
        this.overall = overall;
        this.components = components;
    }

    public Double getOverall() {
        return overall;
    }

    public void setOverall(Double overall) {
        this.overall = overall;
    }

    public Components getComponents() {
        return components;
    }

    public void setComponents(Components components) {
        this.components = components;
    }
    public void setEnergyComponent(Double energyComponent){
        this.components.setEnergy(energyComponent);
    }
    public void setTimeComponent(Double timeComponent){
        this.components.setTime(timeComponent);
    }
    public void setTransactionComponent(Double transactionComponent){
        this.components.setTransaction(transactionComponent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChargingProcessOutput chargingProcessOutput = (ChargingProcessOutput) o;
        return this.overall.equals(chargingProcessOutput.getOverall()) &&
                this.components.equals(chargingProcessOutput.getComponents());
    }

}
