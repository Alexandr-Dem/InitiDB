package com.alexanderdem.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemOfNomenclature extends Pojo {
    private String id; //PK
    private int code;
    private int num;
    private String name;
    private String category; //NULL
    private String accountingCategory; //NULL
    private boolean deleted;
    private String type;
    private double defaultSalePrice;
    private String parent; //NULL

    public ItemOfNomenclature() {
        super("Nomenclature");
    }

/*-------------------------------------------------SQL------------------------------------------------------------------*/

    @Override
    public String getSQLInsert() {
        String sql = "INSERT INTO [dbo].[Nomenclature] " +
                "VALUES ( %1$s, %2$s, %3$s, %4$s, %5$s, %6$s, %7$s, %8$s, %9$s, %10$s) ";
        return String.format(sql, remakeInSQL(id), remakeInSQL(code), remakeInSQL(num), remakeInSQL(name),
                remakeInSQL(category), remakeInSQL(accountingCategory), remakeInSQL(deleted), remakeInSQL(type),
                remakeInSQL(defaultSalePrice), remakeInSQL(parent));
    }

    @Override
    public String getSQLUpdate() {
        String sql = "UPDATE [dbo].[Nomenclature]\n" +
                "   SET [id] = %1$s\n" +
                "      ,[code] = %2$s\n" +
                "      ,[num] = %3$s\n" +
                "      ,[name] = %4$s\n" +
                "      ,[category] = %5$s\n" +
                "      ,[accountingCategory] = %6$s\n" +
                "      ,[deleted] = %7$s\n" +
                "      ,[type] = %8$s\n" +
                "      ,[defaultSalePrice] = %9$s\n" +
                "      ,[parent] = %10$s\n" +
                " WHERE [id] = %1$s";
        return String.format(sql, remakeInSQL(id), remakeInSQL(code), remakeInSQL(num), remakeInSQL(name),
                remakeInSQL(category), remakeInSQL(accountingCategory), remakeInSQL(deleted), remakeInSQL(type),
                remakeInSQL(defaultSalePrice), remakeInSQL(parent));
    }

    @Override
    public String getSQLCheckById() {
        return "SELECT COUNT(id) FROM Nomenclature " +
                "WHERE id "  + remakeInSQLWere(id);
    }

    @Override
    public String getSQLCheckByAll() {
        String sql =  "SELECT COUNT(id) FROM Nomenclature\n" +
                "WHERE " +
                "[id] %1$s AND\n" +
                "[code] %2$s AND\n" +
                "[num] %3$s AND\n" +
                "[name] %4$s AND\n" +
                "[category] %5$s AND\n" +
                "[accountingCategory] %6$s AND\n" +
                "[deleted] %7$s AND\n" +
                "[type] %8$s AND\n" +
                "[defaultSalePrice]  %9$s AND\n" +
                "[parent] %10$s";
        return String.format(sql, remakeInSQLWere(id), remakeInSQLWere(code), remakeInSQLWere(num), remakeInSQLWere(name),
                remakeInSQLWere(category), remakeInSQLWere(accountingCategory), remakeInSQLWere(deleted), remakeInSQLWere(type),
                remakeInSQLWere(defaultSalePrice), remakeInSQLWere(parent));
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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAccountingCategory() {
        return accountingCategory;
    }

    public void setAccountingCategory(String accountingCategory) {
        this.accountingCategory = accountingCategory;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getDefaultSalePrice() {
        return defaultSalePrice;
    }

    public void setDefaultSalePrice(double defaultSalePrice) {
        this.defaultSalePrice = defaultSalePrice;
    }

    public String getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return "ItemOfNomenclature{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", accountingCategory='" + accountingCategory + '\'' +
                ", deleted='" + deleted + '\'' +
                ", type='" + type + '\'' +
                ", defaultSalePrice='" + defaultSalePrice + '\'' +
                ", parent='" + parent + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemOfNomenclature that = (ItemOfNomenclature) o;
        return code == that.code &&
                num == that.num &&
                deleted == that.deleted &&
                Double.compare(that.defaultSalePrice, defaultSalePrice) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(category, that.category) &&
                Objects.equals(accountingCategory, that.accountingCategory) &&
                Objects.equals(type, that.type) &&
                Objects.equals(parent, that.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, num, name, category, accountingCategory, deleted, type, defaultSalePrice, parent);
    }
}
