package application.model.base;

public abstract class Stakeholder {
    /*
    Base class that all others extend from
     */

    private String name, address;

    public Stakeholder(String name, String address) {
        this.name = name;  this.address = address;
    }
    public Stakeholder(String name) {
        this(name, "");
    }

    public Stakeholder() { this(""); }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
