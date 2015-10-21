/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ekman.modelo;

import java.text.SimpleDateFormat;

/**
 *
 * @author Igor
 */
public class Derivadores {
    
    private String assetId;
    private String dataDate;
    private String timeYear;
    private String timeMonth;
    private String timeDay;
    private String timeHour;
    private String timeMin;
    private String sst;
    private String gps_lat;
    private String gps_lon;
    private String tipo;

    public Derivadores(String assetId, String dataDate, String timeYear, String timeMonth, String timeDay, String timeHour, String timeMin, String sst, String gps_lat, String gps_lon, String tipo) {
        this.assetId = assetId;
        this.dataDate = dataDate;
        this.timeYear = timeYear;
        this.timeMonth = timeMonth;
        this.timeDay = timeDay;
        this.timeHour = timeHour;
        this.timeMin = timeMin;
        this.sst = sst;
        this.gps_lat = gps_lat;
        this.gps_lon = gps_lon;
        this.tipo = tipo;
    }
    
    public Derivadores(String assetId, String dataDate) {
        this.assetId = assetId;
        this.dataDate = dataDate;
    }


    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getDataDate() {
        return dataDate;
    }

    public void setDataDate(String dataDate) {
        this.dataDate = dataDate;
    }

    public String getTimeYear() {
        return timeYear;
    }

    public void setTimeYear(String timeYear) {
        this.timeYear = timeYear;
    }

    public String getTimeMonth() {
        return timeMonth;
    }

    public void setTimeMonth(String timeMonth) {
        this.timeMonth = timeMonth;
    }

    public String getTimeDay() {
        return timeDay;
    }

    public void setTimeDay(String timeDay) {
        this.timeDay = timeDay;
    }

    public String getTimeHour() {
        return timeHour;
    }

    public void setTimeHour(String timeHour) {
        this.timeHour = timeHour;
    }

    public String getTimeMin() {
        return timeMin;
    }

    public void setTimeMin(String timeMin) {
        this.timeMin = timeMin;
    }

    public String getSst() {
        return sst;
    }

    public void setSst(String sst) {
        this.sst = sst;
    }

    public String getGps_lat() {
        return gps_lat;
    }

    public void setGps_lat(String gps_lat) {
        this.gps_lat = gps_lat;
    }

    public String getGps_lon() {
        return gps_lon;
    }

    public void setGps_lon(String gps_lon) {
        this.gps_lon = gps_lon;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
