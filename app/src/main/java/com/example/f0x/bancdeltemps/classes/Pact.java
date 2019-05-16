package com.example.f0x.bancdeltemps.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pact {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("post")
    @Expose
    private Post post;
    @SerializedName("id_Pact")
    @Expose
    private Integer idPact;
    @SerializedName("date_created")
    @Expose
    private String dateCreated;
    @SerializedName("date_finished")
    @Expose
    private String dateFinished;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("posts_Id_Post")
    @Expose
    private Integer postsIdPost;
    @SerializedName("id_Author")
    @Expose
    private Integer idAuthor;
    @SerializedName("id_NoAuthor")
    @Expose
    private Integer idNoAuthor;
    @SerializedName("hours")
    @Expose
    private Integer hours;

    /**
     * No args constructor for use in serialization
     */
    public Pact() {
    }

    /**
     * @param dateFinished
     * @param title
     * @param post
     * @param postsIdPost
     * @param idNoAuthor
     * @param idAuthor
     * @param hours
     * @param description
     * @param dateCreated
     * @param idPact
     * @param $id
     */
    public Pact(String $id, Post post, Integer idPact, String dateCreated, String dateFinished, String description, String title, Integer postsIdPost, Integer idAuthor, Integer idNoAuthor, Integer hours) {
        super();
        this.$id = $id;
        this.post = post;
        this.idPact = idPact;
        this.dateCreated = dateCreated;
        this.dateFinished = dateFinished;
        this.description = description;
        this.title = title;
        this.postsIdPost = postsIdPost;
        this.idAuthor = idAuthor;
        this.idNoAuthor = idNoAuthor;
        this.hours = hours;
    }

    public Pact(String dateCreated, String dateFinished, String description, String title, Integer postsIdPost, Integer idAuthor, Integer idNoAuthor, Integer hours) {
        super();
        this.dateCreated = dateCreated;
        this.dateFinished = dateFinished;
        this.description = description;
        this.title = title;
        this.postsIdPost = postsIdPost;
        this.idAuthor = idAuthor;
        this.idNoAuthor = idNoAuthor;
        this.hours = hours;
    }

    public Pact(int idPact, String dateFinished, int hours) {
        super();
        this.idPact = idPact;
        this.dateFinished = dateFinished;
        this.hours = hours;
    }

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public Pact with$id(String $id) {
        this.$id = $id;
        return this;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Pact withPost(Post post) {
        this.post = post;
        return this;
    }

    public Integer getIdPact() {
        return idPact;
    }

    public void setIdPact(Integer idPact) {
        this.idPact = idPact;
    }

    public Pact withIdPact(Integer idPact) {
        this.idPact = idPact;
        return this;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Pact withDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public String getDateFinished() {
        return dateFinished;
    }

    public void setDateFinished(String dateFinished) {
        this.dateFinished = dateFinished;
    }

    public Pact withDateFinished(String dateFinished) {
        this.dateFinished = dateFinished;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pact withDescription(String description) {
        this.description = description;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Pact withTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getPostsIdPost() {
        return postsIdPost;
    }

    public void setPostsIdPost(Integer postsIdPost) {
        this.postsIdPost = postsIdPost;
    }

    public Pact withPostsIdPost(Integer postsIdPost) {
        this.postsIdPost = postsIdPost;
        return this;
    }

    public Integer getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Integer idAuthor) {
        this.idAuthor = idAuthor;
    }

    public Pact withIdAuthor(Integer idAuthor) {
        this.idAuthor = idAuthor;
        return this;
    }

    public Integer getIdNoAuthor() {
        return idNoAuthor;
    }

    public void setIdNoAuthor(Integer idNoAuthor) {
        this.idNoAuthor = idNoAuthor;
    }

    public Pact withIdNoAuthor(Integer idNoAuthor) {
        this.idNoAuthor = idNoAuthor;
        return this;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Pact withHours(Integer hours) {
        this.hours = hours;
        return this;
    }

}