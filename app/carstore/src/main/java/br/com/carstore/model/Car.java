package br.com.carstore.model;

public class Car {

    private String name;
    private String color;

    public Car(String name, String carColor) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Car(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

}