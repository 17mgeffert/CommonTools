package controller;

import service.ApiService;

import java.io.IOException;

public class main{

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        ApiService service = new ApiService();
        service.get("https://pokeapi.co/api/v2/pokemon/ditto/");
    }


}