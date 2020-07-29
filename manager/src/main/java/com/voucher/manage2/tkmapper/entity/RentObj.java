package com.voucher.manage2.tkmapper.entity;

import java.io.Serializable;

public class RentObj implements Serializable {
    private int newRent;
    private int remove;
    private int relieve;

    @Override
    public String toString() {
        return "RentObj{" +
                "newRent=" + newRent +
                ", remove=" + remove +
                ", relieve=" + relieve +
                '}';
    }

    public int getNewRent() {
        return newRent;
    }

    public void setNewRent(int newRent) {
        this.newRent = newRent;
    }

    public int getRemove() {
        return remove;
    }

    public void setRemove(int remove) {
        this.remove = remove;
    }

    public int getRelieve() {
        return relieve;
    }

    public void setRelieve(int relieve) {
        this.relieve = relieve;
    }

    public RentObj() {
    }

    public RentObj(int newRent, int remove, int relieve) {
        this.newRent = newRent;
        this.remove = remove;
        this.relieve = relieve;
    }
}
