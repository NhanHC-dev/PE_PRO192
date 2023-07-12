package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DomesticTour extends Tour {
    private double tourGuideTip;

    public DomesticTour(String code, String title, double price, String transport, LocalDate startDate, LocalDate endDate,
            double tourGuideTip) {
        super(code, title, price, transport, startDate, endDate);
        this.tourGuideTip = tourGuideTip;
    }

    public long getDateNumber() {
		return ChronoUnit.DAYS.between(startDate, endDate);
    }
 
    @Override
    public double calculateSurcharge() {
        return getDateNumber() * tourGuideTip;
    }

    @Override
    public double calculateCharge() {
        return calculateSurcharge() + price;
    }

    

    public double getTourGuideTip() {
        return tourGuideTip;
    }

    public void setTourGuideTip(double tourGuideTip) {
        this.tourGuideTip = tourGuideTip;
    }

    @Override
    public String toString() {
        return "DomesticTour [" + super.toString() + "tourGuideTip=" + tourGuideTip + "]";
    }

}
