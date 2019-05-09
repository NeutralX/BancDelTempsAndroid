package com.example.f0x.bancdeltemps.responses;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseCrearPost {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("value")
    @Expose
    private Integer value;

    /**
     * No args constructor for use in serialization
     */
    public ResponseCrearPost() {
    }

    /**
     * @param value
     * @param $id
     */
    public ResponseCrearPost(String $id, Integer value) {
        super();
        this.$id = $id;
        this.value = value;
    }

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public ResponseCrearPost with$id(String $id) {
        this.$id = $id;
        return this;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public ResponseCrearPost withValue(Integer value) {
        this.value = value;
        return this;
    }

}