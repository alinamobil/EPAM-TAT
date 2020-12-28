package model;

import java.util.Objects;

public class Goods {
    private String amount;
    private String toBuy;

    public Goods(String amount, String toBuy) {
        this.amount = amount;
        this.toBuy = toBuy;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getToBuy() {
        return toBuy;
    }

    public void setToBuy(String toBuy) {
        this.toBuy = toBuy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return Objects.equals(amount, goods.amount) &&
                Objects.equals(toBuy, goods.toBuy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, toBuy);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "amount='" + amount + '\'' +
                ", toBuy='" + toBuy + '\'' +
                '}';
    }
}
