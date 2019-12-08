public class Desk {
    private int deskNum;
    private String deskType;
    private String clientName;
    private String orderMenu;
    private int price;
    private boolean isPayed;

    public int getDeskNum() {
        return deskNum;
    }

    public String getDeskType() {
        return deskType;
    }

    public Desk(int deskNum, String deskType) {
        this.deskNum = deskNum;
        this.deskType = deskType;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getOrderMenu() {
        return orderMenu;
    }

    public void setOrderMenu(String orderMenu) {
        this.orderMenu = orderMenu;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isPayed() {
        return isPayed;
    }

    public void setPayed(boolean payed) {
        isPayed = payed;
    }
}
