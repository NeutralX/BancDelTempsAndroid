package com.example.f0x.bancdeltemps.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User__ {

    @SerializedName("$ref")
    @Expose
    private String $ref;

    /**
     * No args constructor for use in serialization
     *
     */
    public User__() {
    }

    /**
     *
     * @param $ref
     */
    public User__(String $ref) {
        super();
        this.$ref = $ref;
    }

    public String get$ref() {
        return $ref;
    }

    public void set$ref(String $ref) {
        this.$ref = $ref;
    }

    public User__ with$ref(String $ref) {
        this.$ref = $ref;
        return this;
    }

}