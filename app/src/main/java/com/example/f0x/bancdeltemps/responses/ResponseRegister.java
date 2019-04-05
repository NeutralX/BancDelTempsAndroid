package com.example.f0x.bancdeltemps.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseRegister {

    @SerializedName("$id")
    @Expose
    private String $id;
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
    public ResponseRegister() {
    }

    /**
     *
     * @param dateOfBirth
     * @param lastName
     * @param picturePath
     * @param email
     * @param timeHours
     * @param registerDate
     * @param name
     * @param gender
     * @param idUser
     * @param password
     * @param $id
     */
    public ResponseRegister(String $id, Integer idUser, String name, String lastName, String email, String registerDate, Integer timeHours, String password, String dateOfBirth, String gender, String picturePath) {
        super();
        this.$id = $id;
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

    public ResponseRegister with$id(String $id) {
        this.$id = $id;
        return this;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public ResponseRegister withIdUser(Integer idUser) {
        this.idUser = idUser;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ResponseRegister withName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ResponseRegister withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ResponseRegister withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public ResponseRegister withRegisterDate(String registerDate) {
        this.registerDate = registerDate;
        return this;
    }

    public Integer getTimeHours() {
        return timeHours;
    }

    public void setTimeHours(Integer timeHours) {
        this.timeHours = timeHours;
    }

    public ResponseRegister withTimeHours(Integer timeHours) {
        this.timeHours = timeHours;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ResponseRegister withPassword(String password) {
        this.password = password;
        return this;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public ResponseRegister withDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ResponseRegister withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public ResponseRegister withPicturePath(String picturePath) {
        this.picturePath = picturePath;
        return this;
    }

}