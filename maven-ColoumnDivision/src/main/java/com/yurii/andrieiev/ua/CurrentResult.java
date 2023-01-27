package com.yurii.andrieiev.ua;

import java.util.Objects;

public class CurrentResult {
    private int currentDividendInt;
    private int numberSubtracted;
    private int  spaceDifference;

    public CurrentResult(int currentDividendInt, int numberSubtracted, int spaceDifference) {
        this.currentDividendInt = currentDividendInt;
        this.numberSubtracted = numberSubtracted;
        this.spaceDifference = spaceDifference;
    }

    public  int getNumberSubtracted() {
        return numberSubtracted;
    }

    public int getCurrentDividendInt() {
        return currentDividendInt;
    }

    public int getSpaceDifference() {
        return spaceDifference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CurrentResult)) return false;
        CurrentResult that = (CurrentResult) o;
        return getCurrentDividendInt() == that.getCurrentDividendInt() && getNumberSubtracted() == that.getNumberSubtracted() && getSpaceDifference() == that.getSpaceDifference();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCurrentDividendInt(), getNumberSubtracted(), getSpaceDifference());
    }

    @Override
    public String toString() {
        return "CurrentResult{" +
                "currentDividendInt=" + currentDividendInt +
                ", numberSubtracted=" + numberSubtracted +
                ", spaceDifference=" + spaceDifference +
                '}';
    }
}
