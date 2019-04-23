
package com.example.f0x.bancdeltemps.responses;

import java.util.List;

import com.example.f0x.bancdeltemps.classes.Post;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseGetPosts {

    @SerializedName("posts")
    @Expose
    private List<Post> posts = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseGetPosts() {
    }

    /**
     *
     * @param posts
     */
    public ResponseGetPosts(List<Post> posts) {
        super();
        this.posts = posts;
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
