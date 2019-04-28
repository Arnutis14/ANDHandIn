package com.example.exercise41;

import com.google.gson.Gson;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


import java.util.ArrayList;
import java.util.Arrays;


public class APIConsumer {

    private ArrayList<State> states;


    public APIConsumer() {

    }


    public ArrayList<State> getAllStates() throws UnirestException {


        HttpResponse<JsonNode> rspn = Unirest.get("https://gist.githubusercontent.com/mshafrir/2646763/raw/8b0dbb93521f5d6889502305335104218454c2bf/states_titlecase.json?fbclid=IwAR1soKnPOsh_m2xX-HSIrvSnsicIFkHBDZtG8cywyjOHLO9kqpen7Zp1nQo").asJson();


        Gson gson = new Gson();
        State[] stateArray = (State[]) gson.fromJson(String.valueOf(rspn), State[].class);
        states = new ArrayList<>(Arrays.asList(stateArray));
        return states;
    }


}
