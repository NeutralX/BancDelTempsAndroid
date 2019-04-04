package com.example.f0x.bancdeltemps.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Post {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("pacts")
    @Expose
    private List<Pact> pacts = null;
    @SerializedName("reports")
    @Expose
    private List<Report> reports = null;
    @SerializedName("user")
    @Expose
    private User__ user;
    @SerializedName("id_Post")
    @Expose
    private Integer idPost;
    @SerializedName("date_created")
    @Expose
    private String dateCreated;
    @SerializedName("date_finished")
    @Expose
    private String dateFinished;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("userId_User")
    @Expose
    private Integer userIdUser;
    @SerializedName("category_Id_Category")
    @Expose
    private Integer categoryIdCategory;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("hours")
    @Expose
    private Integer hours;

    /**
     * No args constructor for use in serialization
     *
     */
    public Post() {
    }

    /**
     *
     * @param reports
     * @param location
     * @param hours
     * @param userIdUser
     * @param dateFinished
     * @param category
     * @param title
     * @param description
     * @param active
     * @param dateCreated
     * @param categoryIdCategory
     * @param idPost
     * @param $id
     * @param pacts
     * @param user
     */
    public Post(String $id, Category category, List<Pact> pacts, List<Report> reports, User__ user, Integer idPost, String dateCreated, String dateFinished, String description, String location, String title, Integer userIdUser, Integer categoryIdCategory, Boolean active, Integer hours) {
        super();
        this.$id = $id;
        this.category = category;
        this.pacts = pacts;
        this.reports = reports;
        this.user = user;
        this.idPost = idPost;
        this.dateCreated = dateCreated;
        this.dateFinished = dateFinished;
        this.description = description;
        this.location = location;
        this.title = title;
        this.userIdUser = userIdUser;
        this.categoryIdCategory = categoryIdCategory;
        this.active = active;
        this.hours = hours;
    }

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public Post with$id(String $id) {
        this.$id = $id;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Post withCategory(Category category) {
        this.category = category;
        return this;
    }

    public List<Pact> getPacts() {
        return pacts;
    }

    public void setPacts(List<Pact> pacts) {
        this.pacts = pacts;
    }

    public Post withPacts(List<Pact> pacts) {
        this.pacts = pacts;
        return this;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public Post withReports(List<Report> reports) {
        this.reports = reports;
        return this;
    }

    public User__ getUser() {
        return user;
    }

    public void setUser(User__ user) {
        this.user = user;
    }

    public Post withUser(User__ user) {
        this.user = user;
        return this;
    }

    public Integer getIdPost() {
        return idPost;
    }

    public void setIdPost(Integer idPost) {
        this.idPost = idPost;
    }

    public Post withIdPost(Integer idPost) {
        this.idPost = idPost;
        return this;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Post withDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public String getDateFinished() {
        return dateFinished;
    }

    public void setDateFinished(String dateFinished) {
        this.dateFinished = dateFinished;
    }

    public Post withDateFinished(String dateFinished) {
        this.dateFinished = dateFinished;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Post withDescription(String description) {
        this.description = description;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Post withLocation(String location) {
        this.location = location;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Post withTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(Integer userIdUser) {
        this.userIdUser = userIdUser;
    }

    public Post withUserIdUser(Integer userIdUser) {
        this.userIdUser = userIdUser;
        return this;
    }

    public Integer getCategoryIdCategory() {
        return categoryIdCategory;
    }

    public void setCategoryIdCategory(Integer categoryIdCategory) {
        this.categoryIdCategory = categoryIdCategory;
    }

    public Post withCategoryIdCategory(Integer categoryIdCategory) {
        this.categoryIdCategory = categoryIdCategory;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Post withActive(Boolean active) {
        this.active = active;
        return this;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Post withHours(Integer hours) {
        this.hours = hours;
        return this;
    }

}