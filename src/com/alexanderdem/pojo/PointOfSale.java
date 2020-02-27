package com.alexanderdem.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PointOfSale extends Pojo{
    private String id;
    private String departmentId;
    private String alias;

    public PointOfSale() {
        super("PointsOfSale");
    }

    public PointOfSale(String id, String departmentId, String alias) {
        this();
        this.id = id;
        this.departmentId = departmentId;
        this.alias = alias;
    }

    /*-------------------------------------------------SQL------------------------------------------------------------------*/

    @Override
    public String getSQLInsert() {
        String sql = "INSERT INTO [dbo].[PointsOfSale] " +
                "VALUES ( %1$s, %2$s)";
        return String.format(sql, remakeInSQL(id), remakeInSQL(departmentId));
    }

    @Override
    public String getSQLUpdate() {
        String sql = "UPDATE [dbo].[PointsOfSale]\n" +
                "SET \n" +
                "       [id] = %1$s\n" +
                "      ,[departmentId] = %2$s\n" +
                " WHERE [id] =  %1$s";
        return String.format(sql, remakeInSQL(id), remakeInSQL(departmentId));
    }

    @Override
    public String getSQLCheckById() {
        return "SELECT COUNT(id) FROM [dbo].[PointsOfSale]\n" +
                "WHERE id "  + remakeInSQLWere(id);
    }

    @Override
    public String getSQLCheckByAll() {
        String sql =  "SELECT COUNT(id) FROM [dbo].[PointsOfSale]\n" +
                "WHERE\n" +
                "       [id] %1$s AND\n" +
                "       [departmentId] %2$s";
        return String.format(sql, remakeInSQLWere(id), remakeInSQLWere(departmentId));
    }

    @Override
    public List<Pojo> getChildPojoList() {
        ArrayList<Pojo> pojos = new ArrayList<Pojo>();
        pojos.add(new Department(departmentId, alias));
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

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String toString() {
        return "PointOfSale{" +
                "id='" + id + '\'' +
                ", departmentId='" + departmentId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointOfSale that = (PointOfSale) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(departmentId, that.departmentId) &&
                Objects.equals(alias, that.alias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departmentId, alias);
    }
}
