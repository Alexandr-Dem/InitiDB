package com.alexanderdem.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties("nomenclature")
public class OrderItems extends Pojo{
    private String id;
    private String salesCSId;
    private String nomenclatureId;
    private String dishServicePrintTime;
    private int amount;
    private int fullSum;
    private int resultSum;
    private int discountSum;
    private int fullPrice;
    private int resultPrice;

    public OrderItems() {
        super("OrdersItems");
    }

    /*-------------------------------------------------SQL------------------------------------------------------------------*/

    @Override
    public String getSQLInsert() {
        String sql = "INSERT INTO [dbo].[OrdersItems] " +
                "VALUES ( %1$s, %2$s, %3$s, %4$s, %5$s, %6$s, %7$s, %8$s, %9$s, %10$s)";
        return String.format(sql, remakeInSQL(id), remakeInSQL(salesCSId), remakeInSQL(nomenclatureId), remakeInSQL(dishServicePrintTime)
                , remakeInSQL(amount), remakeInSQL(fullSum), remakeInSQL(resultSum), remakeInSQL(discountSum)
                , remakeInSQL(fullPrice), remakeInSQL(resultPrice));
    }

    @Override
    public String getSQLUpdate() {
        String sql = "UPDATE [dbo].[OrdersItems]\n" +
                "SET\n" +
                "       [id] = %1$s\n" +
                "      ,[salesCSId] = %2$s\n" +
                "      ,[nomenclatureId] = %3$s\n" +
                "      ,[dishServicePrintTime] = %4$s\n" +
                "      ,[amount] = %5$s\n" +
                "      ,[fullSum] = %6$s\n" +
                "      ,[resultSum] = %7$s\n" +
                "      ,[discountSum] = %8$s\n" +
                "      ,[fullPrice] = %9$s\n" +
                "      ,[resultPrice] = %10$s\n" +
                "WHERE [id] =  %1$s";
        return String.format(sql, remakeInSQL(id), remakeInSQL(salesCSId), remakeInSQL(nomenclatureId), remakeInSQL(dishServicePrintTime)
                , remakeInSQL(amount), remakeInSQL(fullSum), remakeInSQL(resultSum), remakeInSQL(discountSum)
                , remakeInSQL(fullPrice), remakeInSQL(resultPrice));
    }

    @Override
    public String getSQLCheckById() {
        return "SELECT COUNT(id) FROM [dbo].[OrdersItems]\n" +
                "WHERE id "  + remakeInSQLWere(id);
    }

    @Override
    public String getSQLCheckByAll() {
        String sql =  "SELECT COUNT(id) FROM [dbo].[OrdersItems]\n" +
                "WHERE\n" +
                "       [id] %1$s AND\n" +
                "       [salesCSId]  %2$s AND\n" +
                "       [nomenclatureId]  %3$s AND\n" +
                "       [dishServicePrintTime]  %4$s AND\n" +
                "       [amount]  %5$s AND\n" +
                "       [fullSum]  %6$s AND\n" +
                "       [resultSum]  %7$s AND\n" +
                "       [discountSum]  %8$s AND\n" +
                "       [fullPrice]  %9$s AND\n" +
                "       [resultPrice]  %10$s";
        return String.format(sql, remakeInSQLWere(id), remakeInSQLWere(salesCSId), remakeInSQLWere(nomenclatureId), remakeInSQLWere(dishServicePrintTime)
                , remakeInSQLWere(amount), remakeInSQLWere(fullSum), remakeInSQLWere(resultSum), remakeInSQLWere(discountSum)
                , remakeInSQLWere(fullPrice), remakeInSQLWere(resultPrice));
    }

    @Override
    public List<Pojo> getChildPojoList() {
        return new ArrayList<Pojo>();
    }

    @Override
    public List<Pojo> getSputnics() {
        return new ArrayList<>();
    }
/*-------------------------------------GET SET toString hashCode equals------------------------------------------*/


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSalesCSId() {
        return salesCSId;
    }

    public void setSalesCSId(String salesCSId) {
        this.salesCSId = salesCSId;
    }

    public String getNomenclatureId() {
        return nomenclatureId;
    }

    public void setNomenclatureId(String nomenclatureId) {
        this.nomenclatureId = nomenclatureId;
    }

    public String getDishServicePrintTime() {
        return dishServicePrintTime;
    }

    public void setDishServicePrintTime(String dishServicePrintTime) {
        this.dishServicePrintTime = dishServicePrintTime;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getFullSum() {
        return fullSum;
    }

    public void setFullSum(int fullSum) {
        this.fullSum = fullSum;
    }

    public int getResultSum() {
        return resultSum;
    }

    public void setResultSum(int resultSum) {
        this.resultSum = resultSum;
    }

    public int getDiscountSum() {
        return discountSum;
    }

    public void setDiscountSum(int discountSum) {
        this.discountSum = discountSum;
    }

    public int getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(int fullPrice) {
        this.fullPrice = fullPrice;
    }

    public int getResultPrice() {
        return resultPrice;
    }

    public void setResultPrice(int resultPrice) {
        this.resultPrice = resultPrice;
    }

    @Override
    public String toString() {
        return "OrdersItems{" +
                "id='" + id + '\'' +
                ", salesCSId='" + salesCSId + '\'' +
                ", nomenclatureId='" + nomenclatureId + '\'' +
                ", dishServicePrintTime='" + dishServicePrintTime + '\'' +
                ", amount=" + amount +
                ", fullSum=" + fullSum +
                ", resultSum=" + resultSum +
                ", discountSum=" + discountSum +
                ", fullPrice=" + fullPrice +
                ", resultPrice=" + resultPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItems that = (OrderItems) o;
        return amount == that.amount &&
                fullSum == that.fullSum &&
                resultSum == that.resultSum &&
                discountSum == that.discountSum &&
                fullPrice == that.fullPrice &&
                resultPrice == that.resultPrice &&
                Objects.equals(id, that.id) &&
                Objects.equals(salesCSId, that.salesCSId) &&
                Objects.equals(nomenclatureId, that.nomenclatureId) &&
                Objects.equals(dishServicePrintTime, that.dishServicePrintTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, salesCSId, nomenclatureId, dishServicePrintTime, amount, fullSum, resultSum, discountSum, fullPrice, resultPrice);
    }
}
