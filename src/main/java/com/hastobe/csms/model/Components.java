package com.hastobe.csms.model;

import java.io.Serializable;

public class Components implements Serializable {
    private Double energy;
    private Double time;
    private Double transaction;

    public Components() {
    }

    public Components(Double energy, Double time, Double transaction) {
        this.energy = energy;
        this.time = time;
        this.transaction = transaction;
    }

    public Double getEnergy() {
        return energy;
    }

    public void setEnergy(Double energy) {
        this.energy = energy;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public Double getTransaction() {
        return transaction;
    }

    public void setTransaction(Double transaction) {
        this.transaction = transaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Components components = (Components) o;
        return this.energy.equals(components.getEnergy())&&
                this.time.equals(components.getTime()) &&
                this.transaction.equals(components.getTransaction());
    }
}
