package com.hastobe.csms.model;

import java.io.Serializable;

public class Rate implements Serializable {
        private Double energy;
        private Double time;
        private Double transaction;

        public Rate() {
        }

        public Rate(Double energy, Double time, Double transaction) {
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
}
