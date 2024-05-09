package com.idacademy;

public enum Propertyfile {
    CONFIG("config.properties"),
    EMAIL("email.properties");

    private String pathToFile;
    Propertyfile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public String getPathToFile() {
        return pathToFile;
    }

}
