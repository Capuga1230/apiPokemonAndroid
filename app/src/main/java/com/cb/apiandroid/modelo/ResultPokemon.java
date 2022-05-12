package com.cb.apiandroid.modelo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResultPokemon {


    @SerializedName("count")
    private int count;

    @SerializedName("next")
    private String next;

    @SerializedName("results")
    private ArrayList<Pokemon> results;

    public ResultPokemon() {
    }

    public ResultPokemon(int count, String next, ArrayList<Pokemon> results) {
        this.count = count;
        this.next = next;
        this.results = results;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }
}


