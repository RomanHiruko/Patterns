package models;

import models.valueobjects.Company;
import models.valueobjects.Ram;
import models.valueobjects.Type;

import java.io.Serializable;

public class VO implements Serializable {
    private Ram ram;
    private Company company;
    private Type type;

    public VO(Ram ram, Company company, Type type) {
        this.ram = ram;
        this.company = company;
        this.type = type;
    }

    public VO() {
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
