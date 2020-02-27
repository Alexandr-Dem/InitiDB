package com.alexanderdem.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department extends Pojo {
    private String id;
    private String alias;

    public Department() {
        super("Departments");
    }


    public Department(String departmentId, String departmentAlias) {
        this();
        id = departmentId;
        alias = departmentAlias;
    }

    /*-------------------------------------------------SQL------------------------------------------------------------------*/

    @Override
    public String getSQLInsert() {
        String sql = "INSERT INTO [dbo].[Departments] " +
                "VALUES ( %1$s, %2$s)";
        return String.format(sql, remakeInSQL(id), remakeInSQL(alias));
    }

    @Override
    public String getSQLUpdate() {
        String sql = "UPDATE [dbo].[Departments]\n" +
                "SET \n" +
                "       [id] = %1$s\n" +
                "      ,[alias] = %2$s\n" +
                " WHERE [id] =  %1$s";
        return String.format(sql, remakeInSQL(id), remakeInSQL(alias));
    }

    @Override
    public String getSQLCheckById() {
        return "SELECT COUNT(id) FROM [dbo].[Departments]\n" +
                "WHERE id "  + remakeInSQLWere(id);
    }

    @Override
    public String getSQLCheckByAll() {
        String sql =  "SELECT COUNT(id) FROM [dbo].[Departments]\n" +
                "WHERE\n" +
                "       [id] %1$s AND\n" +
                "       [alias] %2$s";
        return String.format(sql, remakeInSQLWere(id), remakeInSQLWere(alias));
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(alias, that.alias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, alias);
    }
}
