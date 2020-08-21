package application.model.base;

public abstract class Stakeholder {
    /*
    Base class that all others extend from
     */

    private String name, address;

    public Stakeholder(String name, String address, String role) {
        this.name = name;  this.address = address;
    }
    public Stakeholder(String name, String role) {
        this(name, "", role);
    }

    public Stakeholder(String role) {
        this("", role);
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

    public boolean isDoctor() {
        return this.role.equals("Doctor");
    }

    public boolean isClient() {
        return this.role.equals("Client");
    }

    public boolean isDeliverer() {
        return this.role.equals("Deliverer");
    }
}
