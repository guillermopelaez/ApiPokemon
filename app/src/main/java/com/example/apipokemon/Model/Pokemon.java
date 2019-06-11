package com.example.apipokemon.Model;

public class Pokemon {
private int num;

    public int getNum() {
        return num;
    }

    public int setNum(int num) {
        String[] urlPartes = url.split("/");
        return Integer.parseInt(urlPartes[urlPartes.length -1]);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String name;
private String url;

}
