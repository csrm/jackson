package com.example.jackson;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Container {
    private Map map;
    public Container() {

    }
    public Container(Map map) {
        this.map = map;
    }
    public void setMap(Map map) {
        this.map = map;
    }
    @JsonSerialize(as = Map.class)
    public Map getMap() {
        return map;
    }
    @Override
    public String toString() {
        return "Container[ "+map+" ]";
    }
}
