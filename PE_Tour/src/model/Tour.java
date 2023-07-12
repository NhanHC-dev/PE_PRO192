package model;

import java.time.LocalDate;

public abstract class Tour implements ITour {
    protected String code, title;
    protected double price;
    protected String transport;
    protected LocalDate startDate, endDate;

    public Tour(String code, String title, double price, String transport, LocalDate startDate, LocalDate endDate) {
        this.code = code;
        this.title = title;
        this.price = price;
        this.transport = transport;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public double calculateSurcharge() {
        return 0;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Tour [code=" + code + ", title=" + title + ", price=" + price + ", transport=" + transport
                + ", startDate=" + startDate + ", endDate=" + endDate + "]";
    }

}
