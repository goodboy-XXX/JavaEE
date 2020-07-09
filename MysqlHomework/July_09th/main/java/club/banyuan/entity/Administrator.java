package club.banyuan.entity;

public class Administrator {

    private int id;
    private String manageName;
    private String password;

    public Administrator() {
    }

    public Administrator(int id, String manageName, String password) {
        this.id = id;
        this.manageName = manageName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManageName() {
        return manageName;
    }

    public void setManageName(String manageName) {
        this.manageName = manageName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
