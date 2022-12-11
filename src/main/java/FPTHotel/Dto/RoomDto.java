package FPTHotel.Dto;
public class RoomDto {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return the floor
     */
    public int getFloor() {
        return floor;
    }

    /**
     * @param floor the floor to set
     */
    public void setFloor(int floor) {
        this.floor = floor;
    }

    /**
     * @return the convenient
     */
    public String getConvenient() {
        return convenient;
    }

    /**
     * @param convenient the convenient to set
     */
    public void setConvenient(String convenient) {
        this.convenient = convenient;
    }
    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return the priceFirstHour
     */
    public Double getPriceFirstHour() {
        return priceFirstHour;
    }

    /**
     * @param priceFirstHour the priceFirstHour to set
     */
    public void setPriceFirstHour(Double priceFirstHour) {
        this.priceFirstHour = priceFirstHour;
    }

    /**
     * @return the priceLastHour
     */
    public Double getPriceLastHour() {
        return priceLastHour;
    }

    /**
     * @param priceLastHour the priceLastHour to set
     */
    public void setPriceLastHour(Double priceLastHour) {
        this.priceLastHour = priceLastHour;
    }

    /**
     * @return the promotion
     */
    public String getPromotion() {
        return promotion;
    }

    /**
     * @param promotion the promotion to set
     */
    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return the countHomestay
     */
    public Integer getCountHomestay() {
        return countHomestay;
    }

    /**
     * @param countHomestay the countHomestay to set
     */
    public void setCountHomestay(Integer countHomestay) {
        this.countHomestay = countHomestay;
    }

    /**
     * @return the countBook
     */
    public Integer getCountBook() {
        return countBook;
    }

    /**
     * @param countBook the countBook to set
     */
    public void setCountBook(Integer countBook) {
        this.countBook = countBook;
    }
    private int id;
    private int number;
    private int floor;
    private String convenient;
    private String image;
    private Double price;
    private Double priceFirstHour;
    private Double priceLastHour;
    private String promotion;
    private Integer status;
    private Integer countHomestay;
    private Integer countBook;
}
