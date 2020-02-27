package com.alexanderdem.db;

import com.alexanderdem.InitDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DataBase {
    //Введите следующие обязательные данные:
    private final String dbServerName = "localhost"; //ip SQL Server или имя SQL Server в формате serverName\instanceName
    private final String dbPort = "5678";            //Порт, который прослушивает SQL Server.
    private final String dbName = "Sushi";      //Имя базы данных
    private final String dbUserName = "Alexander";   //Пользователь базы данных
    private final String dbPass = "12345";           //Пароль пользователя базв данных

    Connection connection;
    InitDB initDB;

    DataBase(InitDB initDB) {
        this.initDB = initDB;
        try {
            //Подключение драйвера
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            //инициализация подключения к SQL серверу
            String connectionString =
                    "jdbc:sqlserver://" + dbServerName +
                            ":" + dbPort +
                            ";databaseName=" + dbName +
                            ";userName=" + dbUserName +
                            ";password=" + dbPass;

            connection = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            e.printStackTrace();
            initDB.showMessage("Error connection SQL server");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            initDB.showMessage("Error connection JDBC");
        }
    }

}
