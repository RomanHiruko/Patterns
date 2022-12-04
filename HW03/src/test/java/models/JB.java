package models;

import java.io.Serializable;

public class JB implements Serializable {
    public int ram;
    public String company;
    public String type;

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public JB(int ram, String company, String type) {
        this.ram = ram;
        this.company = company;
        this.type = type;
    }

    public JB() {
    }
}
