package com.yurii.andrieiev.ua;

import java.util.List;
import java.util.Objects;

    public class DivisionResult  {
        private int dividend ;
        private int divider ;
        private int finalResult;
        private List<CurrentResult> currentResults;

        public DivisionResult(int dividend, int divider, int finalResult, List<CurrentResult> currentResults) {
            this.dividend = dividend;
            this.divider = divider;
            this.finalResult = finalResult;
            this.currentResults = currentResults;
        }

        public int getDivider() {
            return divider;
        }

        public int getDividend() {
            return dividend;
        }

        public int getFinalResult() {
            return finalResult;
        }

        public List<CurrentResult> getCurrentResults() {
            return currentResults;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof DivisionResult)) return false;
            DivisionResult that = (DivisionResult) o;
            return getDividend() == that.getDividend() && getDivider() == that.getDivider() && getFinalResult() == that.getFinalResult() && getCurrentResults().equals(that.getCurrentResults());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getDividend(), getDivider(), getFinalResult(), getCurrentResults());
        }

        @Override
        public String toString() {
            return "DivisionResult{" +
                    "dividend=" + dividend +
                    ", divider=" + divider +
                    ", finalResult=" + finalResult +
                    ", currentResults=" + currentResults +
                    '}';
        }
    }
