package com.example.f0x.bancdeltemps.responses;

import java.util.List;

import com.example.f0x.bancdeltemps.classes.Post;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseGetPosts {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("posts")
    @Expose
    private List<Post> posts = null;

    /**
     * No args constructor for use in serialization
     */
    public ResponseGetPosts() {
    }

    /**
     * @param posts
     * @param $id
     */
    public ResponseGetPosts(String $id, List<Post> posts) {
        super();
        this.$id = $id;
        this.posts = posts;
    }

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public ResponseGetPosts with$id(String $id) {
        this.$id = $id;
        return this;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public ResponseGetPosts withPosts(List<Post> posts) {
        this.posts = posts;
        return this;
    }
}

