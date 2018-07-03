package com.pribas.controller;


import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.pribas.beans.Product;
import com.pribas.beans.ProductsList;
import com.pribas.beans.Token;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpRequest {


    public int getProducts() {
        try {
            Token tokenApproval = getFuckingToken();
            HttpResponse<String> jsonResponse = Unirest.get("http://barcosrestapi.azurewebsites.net/api/v1/ProductList?token={token}")
                    .header("accept", "application/json")
                    .routeParam("token", tokenApproval.getAccess_token())
                    .asString();
            Gson gson = new Gson();

            ProductsList productsList = gson.fromJson(jsonResponse.getBody(), ProductsList.class);
            int result =jsonResponse.getStatus();
            return result;
        } catch (UnirestException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private Token getFuckingToken() {
        try {
            HttpResponse<String> jsonResponse = Unirest.post("http://barcosrestapi.azurewebsites.net/oauth/token")
                    .header("accept", "application/json")
                    .body("username=s3rkanodemir@gmail.com&password=9876&grant_type=password")
                    .asString();
            return new Gson().fromJson(jsonResponse.getBody(), Token.class);
        } catch (UnirestException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getProductByName(String name) {
        try {

            Token tokenApproval = getFuckingToken();
            HttpResponse<String> jsonResponse = Unirest.get("http://barcosrestapi.azurewebsites.net/api/v1/GetProductByName/{name}?token={token}")
                    .header("accept", "application/json")
                    .routeParam("token", tokenApproval.getAccess_token())
                    .routeParam("name", name)
                    .asString();
            Gson gson = new Gson();
            int result =jsonResponse.getStatus();
            return result;
        } catch (Exception e) {
            return 0;
        }
    }

    public int addProduct(String name) {
        try {
            Gson gson = new Gson();
            Product productToAdd = new Product();
            productToAdd.setName(name);

            Token tokenApproval = getFuckingToken();
            HttpResponse<String> jsonResponse = Unirest.post("http://barcosrestapi.azurewebsites.net/api/v1/AddProduct?token={token}")
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .routeParam("token", tokenApproval.getAccess_token())
                    .body(gson.toJson(productToAdd))
                    .asString();
            int result =jsonResponse.getStatus();
            return result;
        } catch (Exception e) {
            return 0;
        }
    }
    public int addProduct(String name,String text) {
        try {
            Gson gson = new Gson();
            Product productToAdd = new Product();
            productToAdd.setName(name);
            productToAdd.setText(text);

            Token tokenApproval = getFuckingToken();
            HttpResponse<String> jsonResponse = Unirest.post("http://barcosrestapi.azurewebsites.net/api/v1/AddProduct?token={token}")
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .routeParam("token", tokenApproval.getAccess_token())
                    .body(gson.toJson(productToAdd))
                    .asString();
            int result =jsonResponse.getStatus();
            return result;
        } catch (Exception e) {
            return 0;
        }
    }

}
