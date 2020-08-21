package application.model.base;

public class Stakeholder {
    /*
    Base class that all others extend from
     */

    private String name, role, location;


    public Stakeholder(String name, String role) {
        this.name = name; this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
