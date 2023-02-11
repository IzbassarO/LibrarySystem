package LibrarySystem.entities.user;

public class User {
    private Integer ID;

    private String name;

    private String group;

    //constructor
    public User(Integer ID, String name, String group) {
        this.ID = ID;
        this.name = name;
        this.group = group;
    }

    public User(String name, String group) {
        this.name = name;
        this.group = group;
    }
    public User(){}
    //constructor

    //toString
    @Override
    public String toString() {
        return "\n" + ID + " " + name + " " + group;
    }
    //toString

    //getters and setters
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
    //getters and setters
}
