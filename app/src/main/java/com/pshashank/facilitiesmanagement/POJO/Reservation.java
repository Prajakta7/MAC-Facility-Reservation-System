package com.pshashank.facilitiesmanagement.POJO;

public class Reservation {

    String StartDate;
    String StartTime;
    String FacilityVenue;
    String FacilityType;
    String UTAID;

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getFacilityVenue() {
        return FacilityVenue;
    }

    public void setFacilityVenue(String facilityVenue) {
        FacilityVenue = facilityVenue;
    }

    public String getFacilityType() {
        return FacilityType;
    }

    public void setFacilityType(String facilityType) {
        FacilityType = facilityType;
    }

    public String getUTAID() {
        return UTAID;
    }

    public void setUTAID(String UTAID) {
        this.UTAID = UTAID;
    }
}
