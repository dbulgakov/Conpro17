
package com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Report {

    @SerializedName("report_description")
    @Expose
    private String reportDescription;
    @SerializedName("report_end_date")
    @Expose
    private String reportEndDate;
    @SerializedName("report_id")
    @Expose
    private Integer reportId;
    @SerializedName("report_name")
    @Expose
    private String reportName;
    @SerializedName("report_start_date")
    @Expose
    private String reportStartDate;
    @SerializedName("reporter_first_name")
    @Expose
    private String reporterFirstName;
    @SerializedName("reporter_last_name")
    @Expose
    private String reporterLastName;
    @SerializedName("reporter_userID")
    @Expose
    private Integer reporterUserID;

    public String getReportDescription() {
        return reportDescription;
    }

    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }

    public String getReportEndDate() {
        return reportEndDate;
    }

    public void setReportEndDate(String reportEndDate) {
        this.reportEndDate = reportEndDate;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportStartDate() {
        return reportStartDate;
    }

    public void setReportStartDate(String reportStartDate) {
        this.reportStartDate = reportStartDate;
    }

    public String getReporterFirstName() {
        return reporterFirstName;
    }

    public void setReporterFirstName(String reporterFirstName) {
        this.reporterFirstName = reporterFirstName;
    }

    public String getReporterLastName() {
        return reporterLastName;
    }

    public void setReporterLastName(String reporterLastName) {
        this.reporterLastName = reporterLastName;
    }

    public Integer getReporterUserID() {
        return reporterUserID;
    }

    public void setReporterUserID(Integer reporterUserID) {
        this.reporterUserID = reporterUserID;
    }

}
