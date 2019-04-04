package com.example.f0x.bancdeltemps.classes;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("posts")
    @Expose
    private List<Post_> posts = null;
    @SerializedName("id_Category")
    @Expose
    private Integer idCategory;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;

    /**
     * No args constructor for use in serialization
     *
     */
    public Category() {
    }

    /**
     *
     * @param description
     * @param name
     * @param posts
     * @param $id
     * @param idCategory
     */
    public Category(String $id, List<Post_> posts, Integer idCategory, String name, String description) {
        super();
        this.$id = $id;
        this.posts = posts;
        this.idCategory = idCategory;
        this.name = name;
        this.description = description;
    }

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public Category with$id(String $id) {
        this.$id = $id;
        return this;
    }

    public List<Post_> getPosts() {
        return posts;
    }

    public void setPosts(List<Post_> posts) {
        this.posts = posts;
    }

    public Category withPosts(List<Post_> posts) {
        this.posts = posts;
        return this;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public Category withIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category withName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category withDescription(String description) {
        this.description = description;
        return this;
    }

}