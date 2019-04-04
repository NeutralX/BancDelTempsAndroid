package com.example.f0x.bancdeltemps.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post_ {

    @SerializedName("$ref")
    @Expose
    private String $ref;

    /**
     * No args constructor for use in serialization
     *
     */
    public Post_() {
    }

    /**
     *
     * @param $ref
     */
    public Post_(String $ref) {
        super();
        this.$ref = $ref;
    }

    public String get$ref() {
        return $ref;
    }

    public void set$ref(String $ref) {
        this.$ref = $ref;
    }

    public Post_ with$ref(String $ref) {
        this.$ref = $ref;
        return this;
    }

}