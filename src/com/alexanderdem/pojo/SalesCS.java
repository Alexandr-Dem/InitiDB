package com.alexanderdem.pojo;

import java.util.*;

public class SalesCS extends Pojo{
    private String id ;
    private int number ;
    private String serviceType ;
    private String deliveryExpectedTime ;
    private String openTime ;
    private String deliveryPrintTime ;
    private String dishServicePrintTime ;
    private String cookingFinishTime ;
    private String billTime ;
    private String sendTime ;
    private String actualTime ;
    private String closeTime ;
    private String deliveryCloseTime ;
    private int sum ;
    private int resultSum ;
    private int discountSum ;
    private String discount ;
    private int cashnumber ;
    private String cashname ;
    private String conception ;
    private String hashcode ;
    private String operationType ;
    private String storned ;
    private String cashSessionId ;
    private String typeName ;
    private String phone ;
    private String operatorId ;
    private String courierId;
    private String departmentId;
    private Payment [] payments;
    private OrderItems [] orderItemsList;

    public SalesCS() {
        super("SalesCS");
    }

    /*-------------------------------------------------SQL------------------------------------------------------------------*/

    @Override
    public String getSQLInsert() {
        String sql = "INSERT INTO [dbo].[SalesCS] " +
                "VALUES ( %1$s, %2$s, %3$s, %4$s, %5$s, %6$s, %7$s, %8$s, %9$s, %10$s, %11$s, %12$s, %13$s, %14$s, %15$s," +
                " %16$s, %17$s, %18$s, %19$s, %20$s, %21$s, %22$s, %23$s, %24$s, %25$s, %26$s, %27$s, %28$s, %29$s)";
        return String.format(sql, remakeInSQL(id), remakeInSQL(number), remakeInSQL(serviceType), remakeInSQL(deliveryExpectedTime),
                remakeInSQL(openTime), remakeInSQL(deliveryPrintTime), remakeInSQL(dishServicePrintTime), remakeInSQL(cookingFinishTime),
                remakeInSQL(billTime), remakeInSQL(sendTime), remakeInSQL(actualTime), remakeInSQL(closeTime),
                remakeInSQL(deliveryCloseTime), remakeInSQL(sum), remakeInSQL(resultSum), remakeInSQL(discountSum),
                remakeInSQL(discount), remakeInSQL(cashnumber), remakeInSQL(cashname), remakeInSQL(conception),
                remakeInSQL(hashcode), remakeInSQL(operationType), remakeInSQL(storned), remakeInSQL(cashSessionId),
                remakeInSQL(typeName), remakeInSQL(phone), remakeInSQL(operatorId), remakeInSQL(courierId), remakeInSQL(departmentId));
    }

    @Override
    public String getSQLUpdate() {
        String sql = "UPDATE [dbo].[SalesCS]\n" +
                "SET\n" +
                "       [id] = %1$s\n" +
                "      ,[number] = %2$s\n" +
                "      ,[serviceType] = %3$s\n" +
                "      ,[deliveryExpectedTime] = %4$s\n" +
                "      ,[openTime] = %5$s\n" +
                "      ,[deliveryPrintTime] = %6$s\n" +
                "      ,[dishServicePrintTime] = %7$s\n" +
                "      ,[cookingFinishTime] = %8$s\n" +
                "      ,[billTime] = %9$s\n" +
                "      ,[sendTime] = %10$s\n" +
                "      ,[actualTime] = %11$s\n" +
                "      ,[closeTime] = %12$s\n" +
                "      ,[deliveryCloseTime] = %13$s\n" +
                "      ,[sum] = %14$s\n" +
                "      ,[resultSum] = %15$s\n" +
                "      ,[discountSum] = %16$s\n" +
                "      ,[discount] = %17$s\n" +
                "      ,[cashnumber] = %18$s\n" +
                "      ,[cashname] = %19$s\n" +
                "      ,[conception] = %20$s\n" +
                "      ,[hashcode] = %21$s\n" +
                "      ,[operationType] = %22$s\n" +
                "      ,[storned] = %23$s\n" +
                "      ,[cashSessionId] = %24$s\n" +
                "      ,[typeName] = %25$s\n" +
                "      ,[phone] = %26$s\n" +
                "      ,[operatorId] = %27$s\n" +
                "      ,[courierId] = %28$s\n" +
                "      ,[departmentId] = %29$s\n" +
                "WHERE [id] =  %1$s";
        return String.format(sql, remakeInSQL(id), remakeInSQL(number), remakeInSQL(serviceType), remakeInSQL(deliveryExpectedTime),
                remakeInSQL(openTime), remakeInSQL(deliveryPrintTime), remakeInSQL(dishServicePrintTime), remakeInSQL(cookingFinishTime),
                remakeInSQL(billTime), remakeInSQL(sendTime), remakeInSQL(actualTime), remakeInSQL(closeTime),
                remakeInSQL(deliveryCloseTime), remakeInSQL(sum), remakeInSQL(resultSum), remakeInSQL(discountSum),
                remakeInSQL(discount), remakeInSQL(cashnumber), remakeInSQL(cashname), remakeInSQL(conception),
                remakeInSQL(hashcode), remakeInSQL(operationType), remakeInSQL(storned), remakeInSQL(cashSessionId),
                remakeInSQL(typeName), remakeInSQL(phone), remakeInSQL(operatorId), remakeInSQL(courierId), remakeInSQL(departmentId));
    }

    @Override
    public String getSQLCheckById() {
        return "SELECT COUNT(id) FROM [dbo].[SalesCS]\n" +
                "WHERE id "  + remakeInSQLWere(id);
    }

    @Override
    public String getSQLCheckByAll() {
        String sql =  "SELECT COUNT(id) FROM [dbo].[SalesCS]\n" +
                "WHERE\n" +
                "       [id] %1$s AND\n" +
                "       [number]  %2$s AND\n" +
                "       [serviceType]  %3$s AND\n" +
                "       [deliveryExpectedTime]  %4$s AND\n" +
                "       [openTime]  %5$s AND\n" +
                "       [deliveryPrintTime]  %6$s AND\n" +
                "       [dishServicePrintTime]  %7$s AND\n" +
                "       [cookingFinishTime]  %8$s AND\n" +
                "       [billTime]  %9$s AND\n" +
                "       [sendTime]  %10$s AND\n" +
                "       [actualTime]  %11$s AND\n" +
                "       [closeTime]  %12$s AND\n" +
                "       [deliveryCloseTime]  %13$s AND\n" +
                "       [sum]  %14$s AND\n" +
                "       [resultSum]  %15$s AND\n" +
                "       [discountSum]  %16$s AND\n" +
                "       [discount]  %17$s AND\n" +
                "       [cashnumber]  %18$s AND\n" +
                "       [cashname]  %19$s AND\n" +
                "       [conception]  %20$s AND\n" +
                "       [hashcode]  %21$s AND\n" +
                "       [operationType]  %22$s AND\n" +
                "       [storned]  %23$s AND\n" +
                "       [cashSessionId]  %24$s AND\n" +
                "       [typeName]  %25$s AND\n" +
                "       [phone]  %26$s AND\n" +
                "       [operatorId]  %27$s AND\n" +
                "       [courierId]  %28$s AND\n" +
                "       [departmentId]  %29$s";
        return String.format(sql, remakeInSQLWere(id), remakeInSQLWere(number), remakeInSQLWere(serviceType), remakeInSQLWere(deliveryExpectedTime),
                remakeInSQLWere(openTime), remakeInSQLWere(deliveryPrintTime), remakeInSQLWere(dishServicePrintTime), remakeInSQLWere(cookingFinishTime),
                remakeInSQLWere(billTime), remakeInSQLWere(sendTime), remakeInSQLWere(actualTime), remakeInSQLWere(closeTime),
                remakeInSQLWere(deliveryCloseTime), remakeInSQLWere(sum), remakeInSQLWere(resultSum), remakeInSQLWere(discountSum),
                remakeInSQLWere(discount), remakeInSQLWere(cashnumber), remakeInSQLWere(cashname), remakeInSQLWere(conception),
                remakeInSQLWere(hashcode), remakeInSQLWere(operationType), remakeInSQLWere(storned), remakeInSQLWere(cashSessionId),
                remakeInSQLWere(typeName), remakeInSQLWere(phone), remakeInSQLWere(operatorId), remakeInSQLWere(courierId), remakeInSQLWere(departmentId));
    }

    @Override
    public List<Pojo> getChildPojoList() {
        return new ArrayList<Pojo>();
    }

    @Override
    public List<Pojo> getSputnics() {
        List<Pojo> sputnics = new ArrayList<Pojo>();
        sputnics.addAll(Arrays.asList(payments));
        sputnics.addAll(Arrays.asList(orderItemsList));
        return sputnics;
    }

    /*-------------------------------------GET SET toString hashCode equals------------------------------------------*/


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getDeliveryExpectedTime() {
        return deliveryExpectedTime;
    }

    public void setDeliveryExpectedTime(String deliveryExpectedTime) {
        this.deliveryExpectedTime = deliveryExpectedTime;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getDeliveryPrintTime() {
        return deliveryPrintTime;
    }

    public void setDeliveryPrintTime(String deliveryPrintTime) {
        this.deliveryPrintTime = deliveryPrintTime;
    }

    public String getDishServicePrintTime() {
        return dishServicePrintTime;
    }

    public void setDishServicePrintTime(String dishServicePrintTime) {
        this.dishServicePrintTime = dishServicePrintTime;
    }

    public String getCookingFinishTime() {
        return cookingFinishTime;
    }

    public void setCookingFinishTime(String cookingFinishTime) {
        this.cookingFinishTime = cookingFinishTime;
    }

    public String getBillTime() {
        return billTime;
    }

    public void setBillTime(String billTime) {
        this.billTime = billTime;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getActualTime() {
        return actualTime;
    }

    public void setActualTime(String actualTime) {
        this.actualTime = actualTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getDeliveryCloseTime() {
        return deliveryCloseTime;
    }

    public void setDeliveryCloseTime(String deliveryCloseTime) {
        this.deliveryCloseTime = deliveryCloseTime;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
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

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public int getCashnumber() {
        return cashnumber;
    }

    public void setCashnumber(int cashnumber) {
        this.cashnumber = cashnumber;
    }

    public String getCashname() {
        return cashname;
    }

    public void setCashname(String cashname) {
        this.cashname = cashname;
    }

    public String getConception() {
        return conception;
    }

    public void setConception(String conception) {
        this.conception = conception;
    }

    public String getHashcode() {
        return hashcode;
    }

    public void setHashcode(String hashcode) {
        this.hashcode = hashcode;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getStorned() {
        return storned;
    }

    public void setStorned(String storned) {
        this.storned = storned;
    }

    public String getCashSessionId() {
        return cashSessionId;
    }

    public void setCashSessionId(String cashSessionId) {
        this.cashSessionId = cashSessionId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getCourierId() {
        return courierId;
    }

    public void setCourierId(String courierId) {
        this.courierId = courierId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Payment[] getPayments() {
        return payments;
    }

    public void setPayments(Payment[] payments) {
        this.payments = payments;
        for (Payment payment : payments) {
            payment.setId(UUID.randomUUID().toString());
            payment.setSalesCSId(id);
        }
    }

    public OrderItems[] getOrderItemsList() {
        return orderItemsList;
    }

    public void setOrderItemsList(OrderItems[] orderItemsList) {
        this.orderItemsList = orderItemsList;
        for (OrderItems orderItem : orderItemsList) {
            orderItem.setId(UUID.randomUUID().toString());
            orderItem.setSalesCSId(id);
        }
    }

    @Override
    public String toString() {
        return "SalesCS{" +
                "id='" + id + '\'' +
                ", number=" + number +
                ", serviceType='" + serviceType + '\'' +
                ", deliveryExpectedTime='" + deliveryExpectedTime + '\'' +
                ", openTime='" + openTime + '\'' +
                ", deliveryPrintTime='" + deliveryPrintTime + '\'' +
                ", dishServicePrintTime='" + dishServicePrintTime + '\'' +
                ", cookingFinishTime='" + cookingFinishTime + '\'' +
                ", billTime='" + billTime + '\'' +
                ", sendTime='" + sendTime + '\'' +
                ", actualTime='" + actualTime + '\'' +
                ", closeTime='" + closeTime + '\'' +
                ", deliveryCloseTime='" + deliveryCloseTime + '\'' +
                ", sum=" + sum +
                ", resultSum=" + resultSum +
                ", discountSum=" + discountSum +
                ", discount='" + discount + '\'' +
                ", cashnumber=" + cashnumber +
                ", cashname='" + cashname + '\'' +
                ", conception='" + conception + '\'' +
                ", hashcode='" + hashcode + '\'' +
                ", operationType='" + operationType + '\'' +
                ", storned='" + storned + '\'' +
                ", cashSessionId='" + cashSessionId + '\'' +
                ", typeName='" + typeName + '\'' +
                ", phone='" + phone + '\'' +
                ", operatorId='" + operatorId + '\'' +
                ", courierId='" + courierId + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", payments=" + Arrays.toString(payments) +
                ", orderItemsList=" + Arrays.toString(orderItemsList) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesCS salesCS = (SalesCS) o;
        return number == salesCS.number &&
                sum == salesCS.sum &&
                resultSum == salesCS.resultSum &&
                discountSum == salesCS.discountSum &&
                cashnumber == salesCS.cashnumber &&
                Objects.equals(id, salesCS.id) &&
                Objects.equals(serviceType, salesCS.serviceType) &&
                Objects.equals(deliveryExpectedTime, salesCS.deliveryExpectedTime) &&
                Objects.equals(openTime, salesCS.openTime) &&
                Objects.equals(deliveryPrintTime, salesCS.deliveryPrintTime) &&
                Objects.equals(dishServicePrintTime, salesCS.dishServicePrintTime) &&
                Objects.equals(cookingFinishTime, salesCS.cookingFinishTime) &&
                Objects.equals(billTime, salesCS.billTime) &&
                Objects.equals(sendTime, salesCS.sendTime) &&
                Objects.equals(actualTime, salesCS.actualTime) &&
                Objects.equals(closeTime, salesCS.closeTime) &&
                Objects.equals(deliveryCloseTime, salesCS.deliveryCloseTime) &&
                Objects.equals(discount, salesCS.discount) &&
                Objects.equals(cashname, salesCS.cashname) &&
                Objects.equals(conception, salesCS.conception) &&
                Objects.equals(hashcode, salesCS.hashcode) &&
                Objects.equals(operationType, salesCS.operationType) &&
                Objects.equals(storned, salesCS.storned) &&
                Objects.equals(cashSessionId, salesCS.cashSessionId) &&
                Objects.equals(typeName, salesCS.typeName) &&
                Objects.equals(phone, salesCS.phone) &&
                Objects.equals(operatorId, salesCS.operatorId) &&
                Objects.equals(courierId, salesCS.courierId) &&
                Objects.equals(departmentId, salesCS.departmentId) &&
                Arrays.equals(payments, salesCS.payments) &&
                Arrays.equals(orderItemsList, salesCS.orderItemsList);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, number, serviceType, deliveryExpectedTime, openTime, deliveryPrintTime, dishServicePrintTime, cookingFinishTime, billTime, sendTime, actualTime, closeTime, deliveryCloseTime, sum, resultSum, discountSum, discount, cashnumber, cashname, conception, hashcode, operationType, storned, cashSessionId, typeName, phone, operatorId, courierId, departmentId);
        result = 31 * result + Arrays.hashCode(payments);
        result = 31 * result + Arrays.hashCode(orderItemsList);
        return result;
    }
}
