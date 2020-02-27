package com.alexanderdem.pojo;

import java.util.List;

/*
* Абстрактный класс, который наследуют все объекты POJO
* и благодаря которому осуществляется работа со всеми POJO как с объектами одного класа
* Так же хранит в себе название таблицы, к которой принадлежит класс и методы для SQL запросв
* */
public abstract class Pojo {

    private String tableName;

    Pojo(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    //Если поле не NULL, то ему требуются ковычки для вставки в базу данных
    String remakeInSQL(Object item) {
        if (item == null) {
            return "NULL";
        } else {
            return "'" + checkForQuotes(item.toString()) + "'";
        }
    }
    //Генерирует SQL строку для реализации выборки (WHERE), если переменная равна null, то выполняется IS NULL вместо равенства
    String remakeInSQLWere(Object item) {
        if (item == null) {
            return "IS NULL";
        } else {
            return " = '" + checkForQuotes(item.toString()) + "'";
        }
    }

    //Если текстовое поле содержит ковычку, например, "О'МОРЕ", то для корректной вставки данного поля в БД необходимо
    //добавить еще одну ковычку
    private String checkForQuotes(String item) {
        return item.replace("'", "''");
    }
    public abstract String getSQLInsert(); //Возвращает SQL-запрос на вставку данных
    public abstract String getSQLUpdate(); //Возвращает SQL-запрос на обновление данных
    public abstract String getSQLCheckById(); //Возвращает SQL-запрос на проверку данных по id (перед добавлением в таблицу)
    public abstract String getSQLCheckByAll();//Возвращает SQL-запрос на проверку данных по всем полям объекта (перед обновлением таблицы)

    //Выполняется перед тем как добвить POJO в таблицу
    //Возвращает объекты, котоыре необходимо проверить и добавить, в сдучаи их отсутствия, в другие таблицы,
    //где установленная связь по внешенму ключу
    public abstract List<Pojo> getChildPojoList();

    //Выполняется после добавления POJO в таблицу
    //Возвращает объекты, которые необходимо добавить с таблицы спутники (дополняющие основную таблицы такие как Платеж и Ордера для Покупок)
    public abstract List<Pojo> getSputnics();
}
