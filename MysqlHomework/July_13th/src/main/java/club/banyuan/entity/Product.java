package club.banyuan.entity;

import java.util.Date;

public class Product {

    private int id;
    private String productName;
    private String description;
    private String startTime;
    private String endTime;
    private int startPrice;
    private String operate;

    public Product() {
    }

    public Product(int id, String productName, String description, String startTime, String endTime, int startPrice, String operate) {
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", startPrice=" + startPrice +
                ", operate='" + operate + '\'' +
                '}';
    }
}
