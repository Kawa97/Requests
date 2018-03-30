package com.example.corsista.requests;

/**
 * Created by corsista on 27/03/2018.
 */

public class Telefono {
    private String rom;
    private String screenSize;
    private String backCamera;
    private String companyGame;
    private String name;
    private String frontCamera;
    private String battery;
    private String operatingSystem;
    private String processor;
    private String url;
    private String ram;

    public Telefono(String rom, String screenSize, String backCamera, String companyGame, String name, String frontCamera, String battery,
                    String operatingSystem, String processor, String url, String ram)
    {
        this.rom = rom;
        this.screenSize = screenSize;
        this.backCamera = backCamera;
        this.companyGame = companyGame;
        this.name = name;
        this.frontCamera = frontCamera;
        this.battery = battery;
        this.operatingSystem = operatingSystem;
        this.processor = processor;
        this.url = url;
        this.ram = ram;
    }

    @Override
    public String toString() {
        return "Telefono{" +
                "rom='" + rom + '\'' +
                ", screenSize='" + screenSize + '\'' +
                ", backCamera='" + backCamera + '\'' +
                ", companyGame='" + companyGame + '\'' +
                ", name='" + name + '\'' +
                ", frontCamera='" + frontCamera + '\'' +
                ", battery='" + battery + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", processor='" + processor + '\'' +
                ", url='" + url + '\'' +
                ", ram='" + ram + '\'' +
                '}';
}

    public String getScreenSize() {
        return screenSize;
    }
}
