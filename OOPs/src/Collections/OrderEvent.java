package Collections;

public class OrderEvent {
    private String orderId;
    private String userId;
    private String productId;
    private String category;
    private String region;
    private long timeStamp;

    public OrderEvent(String orderId, String userId, String productId, String category, String region, long timeStamp) {
        this.orderId = orderId;
        this.userId = userId;
        this.productId = productId;
        this.category = category;
        this.region = region;
        this.timeStamp = timeStamp;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
