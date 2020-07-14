package club.banyuan.entity;

public class User {

    private int id;
    private String userName;
    private String pwd;
    private String identityID;
    private String phoneNumber;
    private String address;
    private int post;

    public User() {
    }

    public User(int id, String userName, String pwd, String identityID, String phoneNumber, String address, int post) {
        this.id = id;
        this.userName = userName;
        this.pwd = pwd;
        this.identityID = identityID;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.post = post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getIdentityID() {
        return identityID;
    }

    public void setIdentityID(String identityID) {
        this.identityID = identityID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", identityID='" + identityID + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", post=" + post +
                '}';
    }
}
