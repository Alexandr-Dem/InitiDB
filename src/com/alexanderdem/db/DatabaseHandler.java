package com.alexanderdem.db;

import com.alexanderdem.InitDB;
import com.alexanderdem.pojo.Pojo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends DataBase {
    private Statement statement;

    public DatabaseHandler(InitDB initDB) {
        super(initDB);
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            initDB.showMessage("Ошибка при получении statement");
        }
    }

    /*
    * Проверяет список на актуальность, делит список на два: список для добавления и список для обновления и запускает обработку
    * */
    public void uploadToDB(List<Pojo> items) throws SQLException {
        List<Pojo> insertList = new ArrayList<Pojo>();
        List<Pojo> updateList = new ArrayList<Pojo>();

        for (Pojo item : items) {
            int resultCheck = checkOnRepetitions(item); //проверка на актуальность
            if (resultCheck == 0) {
                insertList.add(item);
            } else {
                if (resultCheck == 1) {
                    updateList.add(item);
                }
            }
        }

        if (insertList.size() > 0) insert(insertList);
        if (updateList.size() > 0) update(updateList);
    }



    //Возвращает -1 елси объект уже имееться в базе данных
    //Возвращает 0, если объект необходимо добавить в базу данных
    //Возвращает 1, если объект необходимо обновить в базе данных
    private int checkOnRepetitions(Pojo item) throws SQLException {
        ResultSet result;

        //Проверка по ID
        result = statement.executeQuery(item.getSQLCheckById());
        result.next();
        if (result.getInt(1) == 0)
            return 0;

        //Проверка по всем полям
        result = statement.executeQuery(item.getSQLCheckByAll());
        result.next();
        if (result.getInt(1) == 0) {
            return 1;
        }

        //Не прошел обе проверки
        return -1;
    }

    private void insert (List<Pojo> insertList) throws SQLException {
        for (Pojo item : insertList) {
            //Проверяю надо ли трогать дочерние таблицы перед добавлением основной (соблюдение ограничения FK)
            //Если у Pojo имеются дочерние Pojo, то рекурсивно запускается UploadToDB с дочерними
            uploadToDB(item.getChildPojoList());
            //Загружаю основную таблицу
            statement.executeUpdate(item.getSQLInsert());
            //Загружаю таблицы спутники,  так же рекрсивно
            uploadToDB(item.getSputnics());
            //Если были добавления, то они запишутся в реестр и потом отобразятся в GUI
            initDB.tableChange(item.getTableName());
        }
    }

    private void update(List<Pojo> updateList) throws SQLException {
        for (Pojo item : updateList) {
            //Проверяю надо ли трогать дочерние таблицы перед обновлением основной (соблюдение ограничения FK)
            //Если у Pojo имеются дочерние Pojo, то рекурсивно запускается UploadToDB с дочерними
            uploadToDB(item.getChildPojoList());
            //Обновлею основную таблицу
            statement.executeUpdate(item.getSQLUpdate());
            //Загружаю таблицы спутники, так же рекрсивно
            uploadToDB(item.getSputnics());
            initDB.tableChange(item.getTableName());
        }
    }
}
