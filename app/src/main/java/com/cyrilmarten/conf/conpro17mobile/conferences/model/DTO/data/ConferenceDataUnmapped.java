
package com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConferenceDataUnmapped {

    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("files")
    @Expose
    private List<File> files = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("reports")
    @Expose
    private List<Report> reports = null;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

}
