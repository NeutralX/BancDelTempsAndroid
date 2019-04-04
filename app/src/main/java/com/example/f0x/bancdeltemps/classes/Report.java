package com.example.f0x.bancdeltemps.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Report {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("post")
    @Expose
    private Post___ post;
    @SerializedName("id_Report")
    @Expose
    private Integer idReport;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("is_revised")
    @Expose
    private Boolean isRevised;
    @SerializedName("post_Id_Post")
    @Expose
    private Integer postIdPost;
    @SerializedName("id_Reporter")
    @Expose
    private Integer idReporter;
    @SerializedName("id_Reported")
    @Expose
    private Integer idReported;

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
     * @param post
     * @param description
     * @param idReport
     * @param isRevised
     * @param postIdPost
     * @param $id
     */
    public Report(String $id, Post___ post, Integer idReport, String description, Boolean isRevised, Integer postIdPost, Integer idReporter, Integer idReported) {
        super();
        this.$id = $id;
        this.post = post;
        this.idReport = idReport;
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

    public Post___ getPost() {
        return post;
    }

    public void setPost(Post___ post) {
        this.post = post;
    }

    public Report withPost(Post___ post) {
        this.post = post;
        return this;
    }

    public Integer getIdReport() {
        return idReport;
    }

    public void setIdReport(Integer idReport) {
        this.idReport = idReport;
    }

    public Report withIdReport(Integer idReport) {
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

    public Boolean getIsRevised() {
        return isRevised;
    }

    public void setIsRevised(Boolean isRevised) {
        this.isRevised = isRevised;
    }

    public Report withIsRevised(Boolean isRevised) {
        this.isRevised = isRevised;
        return this;
    }

    public Integer getPostIdPost() {
        return postIdPost;
    }

    public void setPostIdPost(Integer postIdPost) {
        this.postIdPost = postIdPost;
    }

    public Report withPostIdPost(Integer postIdPost) {
        this.postIdPost = postIdPost;
        return this;
    }

    public Integer getIdReporter() {
        return idReporter;
    }

    public void setIdReporter(Integer idReporter) {
        this.idReporter = idReporter;
    }

    public Report withIdReporter(Integer idReporter) {
        this.idReporter = idReporter;
        return this;
    }

    public Integer getIdReported() {
        return idReported;
    }

    public void setIdReported(Integer idReported) {
        this.idReported = idReported;
    }

    public Report withIdReported(Integer idReported) {
        this.idReported = idReported;
        return this;
    }

}