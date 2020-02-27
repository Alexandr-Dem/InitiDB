package com.alexanderdem.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CashSession  extends Pojo{
    private String	id;
    private int	sessionNumber;
    private int	fiscalNumber;
    private int	cashRegNumber;
    private int	cashRegSerial;
    private String	operationDate;
    private String	openDate;
    private String	closeDate;
    private String	acceptDate;
    private String	managerId;
    private String	responsibleUserId;
    private String	sessionStartCash;
    private int	payOrders;
    private int	sumWriteoffOrders;
    private int	salesCash;
    private int	salesCredit;
    private int	salesCard;
    private int	payIn;
    private int	payOut;
    private int	payIncome;
    private int	cashRemain;
    private int	cashDiff;
    private String	sessionStatus;
    private String	conceptionId;
    private String	pointOfSaleId;
    private String	departmentId;
    private String	processedCashName;
    private String departmentAlias;

    public CashSession() {
        super("CashSession");
    }

    /*-------------------------------------------------SQL------------------------------------------------------------------*/

    @Override
    public String getSQLInsert() {
        String sql = "INSERT INTO [dbo].[CashSession] " +
                "VALUES ( %1$s, %2$s, %3$s, %4$s, %5$s, %6$s, %7$s, %8$s, %9$s, %10$s, %11$s, %12$s, %13$s, %14$s, %15$s," +
                " %16$s, %17$s, %18$s, %19$s, %20$s, %21$s, %22$s, %23$s, %24$s, %25$s,  %26$s) ";
        return String.format(sql, remakeInSQL(id), remakeInSQL(sessionNumber), remakeInSQL(fiscalNumber), remakeInSQL(cashRegNumber),
                remakeInSQL(cashRegSerial), remakeInSQL(operationDate), remakeInSQL(openDate), remakeInSQL(closeDate),
                remakeInSQL(acceptDate), remakeInSQL(managerId), remakeInSQL(responsibleUserId), remakeInSQL(sessionStartCash),
                remakeInSQL(payOrders), remakeInSQL(sumWriteoffOrders), remakeInSQL(salesCash), remakeInSQL(salesCredit),
                remakeInSQL(salesCard), remakeInSQL(payIn), remakeInSQL(payOut), remakeInSQL(payIncome),
                remakeInSQL(cashRemain), remakeInSQL(cashDiff), remakeInSQL(sessionStatus), remakeInSQL(conceptionId),
                remakeInSQL(pointOfSaleId), remakeInSQL(processedCashName));
    }

    @Override
    public String getSQLUpdate() {
        String sql = "UPDATE [dbo].[CashSession]\n" +
                "SET\n" +
                "       [id] = %1$s \n" +
                "      ,[sessionNumber] = %2$s \n" +
                "      ,[fiscalNumber] = %3$s \n" +
                "      ,[cashRegNumber] = %4$s \n" +
                "      ,[cashRegSerial] = %5$s \n" +
                "      ,[operationDate] = %6$s \n" +
                "      ,[openDate] = %7$s \n" +
                "      ,[closeDate] = %8$s \n" +
                "      ,[acceptDate] = %9$s \n" +
                "      ,[managerId] = %10$s \n" +
                "      ,[responsibleUserId] = %11$s \n" +
                "      ,[sessionStartCash] = %12$s \n" +
                "      ,[payOrders] = %13$s \n" +
                "      ,[sumWriteoffOrders] = %14$s \n" +
                "      ,[salesCash] = %15$s \n" +
                "      ,[salesCredit] = %16$s \n" +
                "      ,[salesCard] = %17$s \n" +
                "      ,[payIn] = %18$s \n" +
                "      ,[payOut] = %19$s \n" +
                "      ,[payIncome] = %20$s \n" +
                "      ,[cashRemain] = %21$s \n" +
                "      ,[cashDiff] = %22$s \n" +
                "      ,[sessionStatus] = %23$s \n" +
                "      ,[conceptionId] = %24$s \n" +
                "      ,[pointOfSaleId] = %25$s \n" +
                "      ,[processedCashName] = %26$s\n"+
                " WHERE [id] =  %1$s";
        return String.format(sql, remakeInSQL(id), remakeInSQL(sessionNumber), remakeInSQL(fiscalNumber), remakeInSQL(cashRegNumber),
                remakeInSQL(cashRegSerial), remakeInSQL(operationDate), remakeInSQL(openDate), remakeInSQL(closeDate),
                remakeInSQL(acceptDate), remakeInSQL(managerId), remakeInSQL(responsibleUserId), remakeInSQL(sessionStartCash),
                remakeInSQL(payOrders), remakeInSQL(sumWriteoffOrders), remakeInSQL(salesCash), remakeInSQL(salesCredit),
                remakeInSQL(salesCard), remakeInSQL(payIn), remakeInSQL(payOut), remakeInSQL(payIncome),
                remakeInSQL(cashRemain), remakeInSQL(cashDiff), remakeInSQL(sessionStatus), remakeInSQL(conceptionId),
                remakeInSQL(pointOfSaleId), remakeInSQL(processedCashName));
    }

    @Override
    public String getSQLCheckById() {
        return "SELECT COUNT(id) FROM [dbo].[CashSession]\n" +
                "WHERE id "  + remakeInSQLWere(id);
    }

    @Override
    public String getSQLCheckByAll() {
        String sql =  "SELECT COUNT(id) FROM [dbo].[CashSession]\n" +
                "WHERE\n" +
                "       [id] %1$s AND\n" +
                "      [sessionNumber] %2$s AND\n" +
                "      [fiscalNumber] %3$s AND\n" +
                "      [cashRegNumber] %4$s AND\n" +
                "      [cashRegSerial] %5$s AND\n" +
                "      [operationDate] %6$s AND\n" +
                "      [openDate] %7$s AND\n" +
                "      [closeDate] %8$s AND\n" +
                "      [acceptDate] %9$s AND\n" +
                "      [managerId] %10$s AND\n" +
                "      [responsibleUserId] %11$s AND\n" +
                "      [sessionStartCash] %12$s AND\n" +
                "      [payOrders] %13$s AND\n" +
                "      [sumWriteoffOrders] %14$s AND\n" +
                "      [salesCash] %15$s AND\n" +
                "      [salesCredit] %16$s AND\n" +
                "      [salesCard] %17$s AND\n" +
                "      [payIn] %18$s AND\n" +
                "      [payOut] %19$s AND\n" +
                "      [payIncome] %20$s AND\n" +
                "      [cashRemain] %21$s AND\n" +
                "      [cashDiff] %22$s AND\n" +
                "      [sessionStatus] %23$s AND\n" +
                "      [conceptionId] %24$s AND\n" +
                "      [pointOfSaleId] %25$s AND\n" +
                "      [processedCashName] %26$s";
        return String.format(sql, remakeInSQLWere(id), remakeInSQLWere(sessionNumber), remakeInSQLWere(fiscalNumber),
                remakeInSQLWere(cashRegNumber),remakeInSQLWere(cashRegSerial), remakeInSQLWere(operationDate),
                remakeInSQLWere(openDate), remakeInSQLWere(closeDate),remakeInSQLWere(acceptDate),
                remakeInSQLWere(managerId), remakeInSQLWere(responsibleUserId), remakeInSQLWere(sessionStartCash),
                remakeInSQLWere(payOrders), remakeInSQLWere(sumWriteoffOrders), remakeInSQLWere(salesCash), remakeInSQLWere(salesCredit),
                remakeInSQLWere(salesCard), remakeInSQLWere(payIn), remakeInSQLWere(payOut), remakeInSQLWere(payIncome),
                remakeInSQLWere(cashRemain), remakeInSQLWere(cashDiff), remakeInSQLWere(sessionStatus), remakeInSQLWere(conceptionId),
                remakeInSQLWere(pointOfSaleId), remakeInSQLWere(processedCashName));
    }

    @Override
    public List<Pojo> getChildPojoList() {
        ArrayList<Pojo> pojos = new ArrayList<Pojo>();
        pojos.add(new PointOfSale(pointOfSaleId, departmentId,departmentAlias));
        return pojos;
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

    public int getSessionNumber() {
        return sessionNumber;
    }

    public void setSessionNumber(int sessionNumber) {
        this.sessionNumber = sessionNumber;
    }

    public int getFiscalNumber() {
        return fiscalNumber;
    }

    public void setFiscalNumber(int fiscalNumber) {
        this.fiscalNumber = fiscalNumber;
    }

    public int getCashRegNumber() {
        return cashRegNumber;
    }

    public void setCashRegNumber(int cashRegNumber) {
        this.cashRegNumber = cashRegNumber;
    }

    public int getCashRegSerial() {
        return cashRegSerial;
    }

    public void setCashRegSerial(int cashRegSerial) {
        this.cashRegSerial = cashRegSerial;
    }

    public String getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(String operationDate) {
        this.operationDate = operationDate;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public String getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(String acceptDate) {
        this.acceptDate = acceptDate;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getResponsibleUserId() {
        return responsibleUserId;
    }

    public void setResponsibleUserId(String responsibleUserId) {
        this.responsibleUserId = responsibleUserId;
    }

    public String getSessionStartCash() {
        return sessionStartCash;
    }

    public void setSessionStartCash(String sessionStartCash) {
        this.sessionStartCash = sessionStartCash;
    }

    public int getPayOrders() {
        return payOrders;
    }

    public void setPayOrders(int payOrders) {
        this.payOrders = payOrders;
    }

    public int getSumWriteoffOrders() {
        return sumWriteoffOrders;
    }

    public void setSumWriteoffOrders(int sumWriteoffOrders) {
        this.sumWriteoffOrders = sumWriteoffOrders;
    }

    public int getSalesCash() {
        return salesCash;
    }

    public void setSalesCash(int salesCash) {
        this.salesCash = salesCash;
    }

    public int getSalesCredit() {
        return salesCredit;
    }

    public void setSalesCredit(int salesCredit) {
        this.salesCredit = salesCredit;
    }

    public int getSalesCard() {
        return salesCard;
    }

    public void setSalesCard(int salesCard) {
        this.salesCard = salesCard;
    }

    public int getPayIn() {
        return payIn;
    }

    public void setPayIn(int payIn) {
        this.payIn = payIn;
    }

    public int getPayOut() {
        return payOut;
    }

    public void setPayOut(int payOut) {
        this.payOut = payOut;
    }

    public int getPayIncome() {
        return payIncome;
    }

    public void setPayIncome(int payIncome) {
        this.payIncome = payIncome;
    }

    public int getCashRemain() {
        return cashRemain;
    }

    public void setCashRemain(int cashRemain) {
        this.cashRemain = cashRemain;
    }

    public int getCashDiff() {
        return cashDiff;
    }

    public void setCashDiff(int cashDiff) {
        this.cashDiff = cashDiff;
    }

    public String getSessionStatus() {
        return sessionStatus;
    }

    public void setSessionStatus(String sessionStatus) {
        this.sessionStatus = sessionStatus;
    }

    public String getConceptionId() {
        return conceptionId;
    }

    public void setConceptionId(String conceptionId) {
        this.conceptionId = conceptionId;
    }

    public String getPointOfSaleId() {
        return pointOfSaleId;
    }

    public void setPointOfSaleId(String pointOfSaleId) {
        this.pointOfSaleId = pointOfSaleId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getProcessedCashName() {
        return processedCashName;
    }

    public void setProcessedCashName(String processedCashName) {
        this.processedCashName = processedCashName;
    }

    public void setDepartmentAlias(String departmentAlias) {
        this.departmentAlias = departmentAlias;
    }

    @Override
    public String toString() {
        return "CashSession{" +
                "id='" + id + '\'' +
                ", sessionNumber=" + sessionNumber +
                ", fiscalNumber=" + fiscalNumber +
                ", cashRegNumber=" + cashRegNumber +
                ", cashRegSerial=" + cashRegSerial +
                ", operationDate='" + operationDate + '\'' +
                ", openDate='" + openDate + '\'' +
                ", closeDate='" + closeDate + '\'' +
                ", acceptDate='" + acceptDate + '\'' +
                ", managerId='" + managerId + '\'' +
                ", responsibleUserId='" + responsibleUserId + '\'' +
                ", sessionStartCash='" + sessionStartCash + '\'' +
                ", payOrders=" + payOrders +
                ", sumWriteoffOrders=" + sumWriteoffOrders +
                ", salesCash=" + salesCash +
                ", salesCredit=" + salesCredit +
                ", salesCard=" + salesCard +
                ", payIn=" + payIn +
                ", payOut=" + payOut +
                ", payIncome=" + payIncome +
                ", cashRemain=" + cashRemain +
                ", cashDiff=" + cashDiff +
                ", sessionStatus='" + sessionStatus + '\'' +
                ", conceptionId='" + conceptionId + '\'' +
                ", pointOfSaleId='" + pointOfSaleId + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", processedCashName='" + processedCashName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CashSession that = (CashSession) o;
        return sessionNumber == that.sessionNumber &&
                fiscalNumber == that.fiscalNumber &&
                cashRegNumber == that.cashRegNumber &&
                cashRegSerial == that.cashRegSerial &&
                payOrders == that.payOrders &&
                sumWriteoffOrders == that.sumWriteoffOrders &&
                salesCash == that.salesCash &&
                salesCredit == that.salesCredit &&
                salesCard == that.salesCard &&
                payIn == that.payIn &&
                payOut == that.payOut &&
                payIncome == that.payIncome &&
                cashRemain == that.cashRemain &&
                cashDiff == that.cashDiff &&
                Objects.equals(id, that.id) &&
                Objects.equals(operationDate, that.operationDate) &&
                Objects.equals(openDate, that.openDate) &&
                Objects.equals(closeDate, that.closeDate) &&
                Objects.equals(acceptDate, that.acceptDate) &&
                Objects.equals(managerId, that.managerId) &&
                Objects.equals(responsibleUserId, that.responsibleUserId) &&
                Objects.equals(sessionStartCash, that.sessionStartCash) &&
                Objects.equals(sessionStatus, that.sessionStatus) &&
                Objects.equals(conceptionId, that.conceptionId) &&
                Objects.equals(pointOfSaleId, that.pointOfSaleId) &&
                Objects.equals(departmentId, that.departmentId) &&
                Objects.equals(processedCashName, that.processedCashName) &&
                Objects.equals(departmentAlias, that.departmentAlias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sessionNumber, fiscalNumber, cashRegNumber, cashRegSerial, operationDate, openDate, closeDate, acceptDate, managerId, responsibleUserId, sessionStartCash, payOrders, sumWriteoffOrders, salesCash, salesCredit, salesCard, payIn, payOut, payIncome, cashRemain, cashDiff, sessionStatus, conceptionId, pointOfSaleId, departmentId, processedCashName, departmentAlias);
    }
}
