package club.banyuan.entity;

import java.util.Date;

public class Product {

    private int id;
    private String productName;
    private String description;
    private Date startTime;
    private Date endTime;
    private int startPrice;
    private String operate;

    public Product() {
    }

    public Product(int id, String productName, String description, Date startTime, Date endTime, int startPrice, String operate) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startPrice = startPrice;
        this.operate = operate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(int startPrice) {
        this.startPrice = startPrice;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }
}
