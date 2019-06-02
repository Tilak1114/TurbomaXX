package com.example.turbomaxx;

public class CarModel {
    private String bodyType, carAvatar, driveType, engine, fuel, gearbox, modelname, powerSpec1, powerSpec2, topSpeed, torque, zerotohund;

    public CarModel(){

    }

    public CarModel(String bodyType, String carAvatar, String driveType, String engine, String fuel, String gearbox, String modelname, String powerSpec1, String powerSpec2, String topSpeed, String torque, String zerotohund) {
        this.bodyType = bodyType;
        this.driveType = driveType;
        this.carAvatar = carAvatar;
        this.engine = engine;
        this.fuel = fuel;
        this.gearbox = gearbox;
        this.modelname = modelname;
        this.powerSpec1 = powerSpec1;
        this.powerSpec2 = powerSpec2;
        this.topSpeed = topSpeed;
        this.torque = torque;
        this.zerotohund = zerotohund;
    }

    public String getCarAvatar() {
        return carAvatar;
    }

    public void setCarAvatar(String carAvatar) {
        this.carAvatar = carAvatar;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname;
    }

    public String getPowerSpec1() {
        return powerSpec1;
    }

    public void setPowerSpec1(String powerSpec1) {
        this.powerSpec1 = powerSpec1;
    }

    public String getPowerSpec2() {
        return powerSpec2;
    }

    public void setPowerSpec2(String powerSpec2) {
        this.powerSpec2 = powerSpec2;
    }

    public String getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(String topSpeed) {
        this.topSpeed = topSpeed;
    }

    public String getTorque() {
        return torque;
    }

    public void setTorque(String torque) {
        this.torque = torque;
    }

    public String getZerotohund() {
        return zerotohund;
    }

    public void setZerotohund(String zerotohund) {
        this.zerotohund = zerotohund;
    }
}
