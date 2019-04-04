package com.example.f0x.bancdeltemps.responses;

import java.util.List;


import com.example.f0x.bancdeltemps.classes.Ban;
import com.example.f0x.bancdeltemps.classes.Post;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseLogin {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("bans")
    @Expose
    private List<Ban> bans = null;
    @SerializedName("posts")
    @Expose
    private List<Post> posts = null;
    @SerializedName("id_User")
    @Expose
    private Integer idUser;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("register_date")
    @Expose
    private String registerDate;
    @SerializedName("time_hours")
    @Expose
    private Integer timeHours;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("date_of_birth")
    @Expose
    private String dateOfBirth;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("picture_path")
    @Expose
    private String picturePath;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseLogin() {
    }

    /**
     *
     * @param dateOfBirth
     * @param lastName
     * @param picturePath
     * @param email
     * @param bans
     * @param timeHours
     * @param registerDate
     * @param name
     * @param posts
     * @param gender
     * @param idUser
     * @param password
     * @param $id
     */
    public ResponseLogin(String $id, List<Ban> bans, List<Post> posts, Integer idUser, String name, String lastName, String email, String registerDate, Integer timeHours, String password, String dateOfBirth, String gender, String picturePath) {
        super();
        this.$id = $id;
        this.bans = bans;
        this.posts = posts;
        this.idUser = idUser;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.registerDate = registerDate;
        this.timeHours = timeHours;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.picturePath = picturePath;
    }

    public ResponseLogin(Integer idUser, String name, String lastName, String email, String registerDate, Integer timeHours, String password, String dateOfBirth, String gender, String picturePath) {
        this.idUser = idUser;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.registerDate = registerDate;
        this.timeHours = timeHours;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.picturePath = picturePath;
    }

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public ResponseLogin with$id(String $id) {
        this.$id = $id;
        return this;
    }

    public List<Ban> getBans() {
        return bans;
    }

    public void setBans(List<Ban> bans) {
        this.bans = bans;
    }

    public ResponseLogin withBans(List<Ban> bans) {
        this.bans = bans;
        return this;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public ResponseLogin withPosts(List<Post> posts) {
        this.posts = posts;
        return this;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public ResponseLogin withIdUser(Integer idUser) {
        this.idUser = idUser;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ResponseLogin withName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ResponseLogin withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ResponseLogin withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public ResponseLogin withRegisterDate(String registerDate) {
        this.registerDate = registerDate;
        return this;
    }

    public Integer getTimeHours() {
        return timeHours;
    }

    public void setTimeHours(Integer timeHours) {
        this.timeHours = timeHours;
    }

    public ResponseLogin withTimeHours(Integer timeHours) {
        this.timeHours = timeHours;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ResponseLogin withPassword(String password) {
        this.password = password;
        return this;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public ResponseLogin withDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ResponseLogin withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public ResponseLogin withPicturePath(String picturePath) {
        this.picturePath = picturePath;
        return this;
    }

}