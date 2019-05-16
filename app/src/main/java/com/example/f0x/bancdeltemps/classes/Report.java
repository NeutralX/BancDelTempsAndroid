package com.example.f0x.bancdeltemps.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Report {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("id_Report")
    @Expose
    private long idReport;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("is_revised")
    @Expose
    private boolean isRevised;
    @SerializedName("post_Id_Post")
    @Expose
    private long postIdPost;
    @SerializedName("id_Reporter")
    @Expose
    private long idReporter;
    @SerializedName("id_Reported")
    @Expose
    private long idReported;

    /**
     * No args constructor for use in serialization
     *
     */
    public Report() {
    }

    /**
     *
     * @param idReporter
     * @param idReported
     * @param description
     * @param idReport
     * @param isRevised
     * @param postIdPost
     * @param $id
     */
    public Report(String $id, long idReport, String description, boolean isRevised, long postIdPost, long idReporter, long idReported) {
        super();
        this.$id = $id;
        this.idReport = idReport;
        this.description = description;
        this.isRevised = isRevised;
        this.postIdPost = postIdPost;
        this.idReporter = idReporter;
        this.idReported = idReported;
    }

    public Report(String description, boolean isRevised, long postIdPost, long idReporter, long idReported) {
        super();
        this.description = description;
        this.isRevised = isRevised;
        this.postIdPost = postIdPost;
        this.idReporter = idReporter;
        this.idReported = idReported;
    }

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public Report with$id(String $id) {
        this.$id = $id;
        return this;
    }

    public long getIdReport() {
        return idReport;
    }

    public void setIdReport(long idReport) {
        this.idReport = idReport;
    }

    public Report withIdReport(long idReport) {
        this.idReport = idReport;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Report withDescription(String description) {
        this.description = description;
        return this;
    }

    public boolean isIsRevised() {
        return isRevised;
    }

    public void setIsRevised(boolean isRevised) {
        this.isRevised = isRevised;
    }

    public Report withIsRevised(boolean isRevised) {
        this.isRevised = isRevised;
        return this;
    }

    public long getPostIdPost() {
        return postIdPost;
    }

    public void setPostIdPost(long postIdPost) {
        this.postIdPost = postIdPost;
    }

    public Report withPostIdPost(long postIdPost) {
        this.postIdPost = postIdPost;
        return this;
    }

    public long getIdReporter() {
        return idReporter;
    }

    public void setIdReporter(long idReporter) {
        this.idReporter = idReporter;
    }

    public Report withIdReporter(long idReporter) {
        this.idReporter = idReporter;
        return this;
    }

    public long getIdReported() {
        return idReported;
    }

    public void setIdReported(long idReported) {
        this.idReported = idReported;
    }

    public Report withIdReported(long idReported) {
        this.idReported = idReported;
        return this;
    }

}
