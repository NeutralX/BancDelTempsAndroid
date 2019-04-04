package com.example.f0x.bancdeltemps.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ban {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("user")
    @Expose
    private User_ user;
    @SerializedName("id_Ban")
    @Expose
    private Integer idBan;
    @SerializedName("ban_date")
    @Expose
    private String banDate;
    @SerializedName("ban_finish_date")
    @Expose
    private String banFinishDate;
    @SerializedName("userId_User")
    @Expose
    private Integer userIdUser;

    /**
     * No args constructor for use in serialization
     *
     */
    public Ban() {
    }

    /**
     *
     * @param idBan
     * @param userIdUser
     * @param banDate
     * @param user
     * @param $id
     * @param banFinishDate
     */
    public Ban(String $id, User_ user, Integer idBan, String banDate, String banFinishDate, Integer userIdUser) {
        super();
        this.$id = $id;
        this.user = user;
        this.idBan = idBan;
        this.banDate = banDate;
        this.banFinishDate = banFinishDate;
        this.userIdUser = userIdUser;
    }

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public Ban with$id(String $id) {
        this.$id = $id;
        return this;
    }

    public User_ getUser() {
        return user;
    }

    public void setUser(User_ user) {
        this.user = user;
    }

    public Ban withUser(User_ user) {
        this.user = user;
        return this;
    }

    public Integer getIdBan() {
        return idBan;
    }

    public void setIdBan(Integer idBan) {
        this.idBan = idBan;
    }

    public Ban withIdBan(Integer idBan) {
        this.idBan = idBan;
        return this;
    }

    public String getBanDate() {
        return banDate;
    }

    public void setBanDate(String banDate) {
        this.banDate = banDate;
    }

    public Ban withBanDate(String banDate) {
        this.banDate = banDate;
        return this;
    }

    public String getBanFinishDate() {
        return banFinishDate;
    }

    public void setBanFinishDate(String banFinishDate) {
        this.banFinishDate = banFinishDate;
    }

    public Ban withBanFinishDate(String banFinishDate) {
        this.banFinishDate = banFinishDate;
        return this;
    }

    public Integer getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(Integer userIdUser) {
        this.userIdUser = userIdUser;
    }

    public Ban withUserIdUser(Integer userIdUser) {
        this.userIdUser = userIdUser;
        return this;
    }

}