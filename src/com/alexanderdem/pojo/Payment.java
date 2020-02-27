package com.alexanderdem.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Payment extends Pojo{
    private String id;
    private String salesCSId;
    private String name;
    private String paymentGroup;
    private int paymentSum;
    private int paymentSumRaw;

    public Payment() {
        super("Payments");
    }
    /*-------------------------------------------------SQL------------------------------------------------------------------*/
    @Override
    public String getSQLInsert() {
        String sql = "INSERT INTO [dbo].[Payments] " +
                "VALUES ( %1$s, %2$s, %3$s, %4$s, %5$s, %6$s)";
        return String.format(sql, remakeInSQL(id), remakeInSQL(salesCSId), remakeInSQL(name),
                remakeInSQL(paymentGroup), remakeInSQL(paymentSum), remakeInSQL(paymentSumRaw));
    }

    @Override
    public String getSQLUpdate() {
        String sql = "UPDATE [dbo].[Payments]\n" +
                "SET\n" +
                "       [id] = %1$s\n" +
                "      ,[salesCSId] = %2$s\n" +
                "      ,[name] = %3$s\n" +
                "      ,[paymentGroup] = %4$s\n" +
                "      ,[paymentSum] = %5$s\n" +
                "      ,[paymentSumRaw] = %6$s\n" +
                "WHERE [id] =  %1$s";
        return String.format(sql, remakeInSQL(id), remakeInSQL(salesCSId), remakeInSQL(name),
                remakeInSQL(paymentGroup), remakeInSQL(paymentSum), remakeInSQL(paymentSumRaw));
    }

    @Override
    public String getSQLCheckById() {
        return "SELECT COUNT(id) FROM [dbo].[Payments]\n" +
                "WHERE id "  + remakeInSQLWere(id);
    }

    @Override
    public String getSQLCheckByAll() {
        String sql =  "SELECT COUNT(id) FROM [dbo].[OrdersItems]\n" +
                "WHERE\n" +
                "       [id] %1$s AND\n" +
                "       [salesCSId] %2$s AND\n" +
                "       [name] %3$s AND\n" +
                "       [paymentGroup] %4$s AND\n" +
                "       [paymentSum] %5$s AND\n" +
                "       [paymentSumRaw] %6$s";
        return String.format(sql, remakeInSQLWere(id), remakeInSQLWere(salesCSId), remakeInSQLWere(name),
                remakeInSQLWere(paymentGroup), remakeInSQLWere(paymentSum), remakeInSQLWere(paymentSumRaw));
    }

    @Override
    public List<Pojo> getChildPojoList() {
        return new ArrayList<Pojo>();

    }
    @Override
    public List<Pojo> getSputnics() {
        return new ArrayList<Pojo>();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaymentGroup() {
        return paymentGroup;
    }

    public void setPaymentGroup(String paymentGroup) {
        this.paymentGroup = paymentGroup;
    }

    public int getPaymentSum() {
        return paymentSum;
    }

    public void setPaymentSum(int paymentSum) {
        this.paymentSum = paymentSum;
    }

    public int getPaymentSumRaw() {
        return paymentSumRaw;
    }

    public void setPaymentSumRaw(int paymentSumRaw) {
        this.paymentSumRaw = paymentSumRaw;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id='" + id + '\'' +
                ", salesCSId='" + salesCSId + '\'' +
                ", name='" + name + '\'' +
                ", paymentGroup='" + paymentGroup + '\'' +
                ", paymentSum=" + paymentSum +
                ", paymentSumRaw=" + paymentSumRaw +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return paymentSum == payment.paymentSum &&
                paymentSumRaw == payment.paymentSumRaw &&
                Objects.equals(id, payment.id) &&
                Objects.equals(salesCSId, payment.salesCSId) &&
                Objects.equals(name, payment.name) &&
                Objects.equals(paymentGroup, payment.paymentGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, salesCSId, name, paymentGroup, paymentSum, paymentSumRaw);
    }
}
