package model;

import java.time.LocalDate;

public class InternationalTour extends Tour {
    private double aviationTax, entryFee;

    public InternationalTour(String code, String title, double price, String transport, LocalDate startDate,
            LocalDate endDate, double aviationTax, double entryFee) {
        super(code, title, price, transport, startDate, endDate);
        this.aviationTax = aviationTax;
        this.entryFee = entryFee;
    }

    public double getAviationTax() {
        return aviationTax;
    }

    public void setAviationTax(double aviationTax) {
        this.aviationTax = aviationTax;
    }

    public double getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(double entryFee) {
        this.entryFee = entryFee;
    }

    @Override
    public double calculateSurcharge() {
        return aviationTax + entryFee;
    }

    @Override
    public double calculateCharge() {
        return calculateSurcharge() + price;
    }

    @Override
    public String toString() {
        return "InternationalTour [" + super.toString() + "aviationTax=" + aviationTax + ", entryFee=" + entryFee + "]";
    }

}
