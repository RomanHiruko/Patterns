package models;

import models.valueobjects.Company;
import models.valueobjects.Ram;
import models.valueobjects.Type;

public class BLBuilder {
    private Ram ram;
    private int rom = 256;
    private Company company;
    private String model = "Galaxy S20";
    private Type type;

    public BLBuilder(Ram ram, Company company, Type type) {
        this.ram = ram;
        this.company = company;
        this.type = type;
    }

    public BLBuilder setRom(int rom){
        this.rom = rom;
        return this;
    }

    public BLBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public BL build(){
        BL bl = new BL();
        bl.setRam(this.ram);
        bl.setRom(this.rom);
        bl.setModel(this.model);
        bl.setCompany(this.company);
        bl.setType(this.type);
        return bl;
    }
}
