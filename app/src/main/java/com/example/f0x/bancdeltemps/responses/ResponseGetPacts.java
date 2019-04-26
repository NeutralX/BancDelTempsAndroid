package com.example.f0x.bancdeltemps.responses;

import java.util.List;

import com.example.f0x.bancdeltemps.classes.Pact;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseGetPacts {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("pacts")
    @Expose
    private List<Pact> pacts = null;

    /**
     * No args constructor for use in serialization
     */
    public ResponseGetPacts() {
    }

    /**
     * @param pacts
     * @param $id
     */
    public ResponseGetPacts(String $id, List<Pact> pacts) {
        super();
        this.$id = $id;
        this.pacts = pacts;
    }

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public ResponseGetPacts with$id(String $id) {
        this.$id = $id;
        return this;
    }

    public List<Pact> getPacts() {
        return pacts;
    }

    public void setPacts(List<Pact> pacts) {
        this.pacts = pacts;
    }

    public ResponseGetPacts withPacts(List<Pact> pacts) {
        this.pacts = pacts;
        return this;
    }

}
