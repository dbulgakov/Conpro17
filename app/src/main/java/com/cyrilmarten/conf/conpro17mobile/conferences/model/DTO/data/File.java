
package com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class File {

    @SerializedName("file_description")
    @Expose
    private String fileDescription;
    @SerializedName("file_id")
    @Expose
    private Integer fileId;
    @SerializedName("file_url")
    @Expose
    private String fileUrl;

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

}
