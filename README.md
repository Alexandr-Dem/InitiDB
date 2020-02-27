# InitiDB
Данная программа инициализирует базу данных (MS SQL) на основе полученной информации по HTTP протоколу. 
Демонстрирует работу с:  HTTP, JSON (JACKJSON), POJO, JDBC,  MS SQL, Swing.

### Настройка

#### MS SQL SERVER: 
С помощью скрипта необходимо создать базу данных
+ [Script_create_DB.sql](Script_create_DB.sql) - скрипт

#### Библиотеки: 
Необходимо подключить библиотеки, которые хранятся в папке **lib**. 
  1. Три библиотеки для работы с **JACKSON**:
  1.1 jackson-annotations-2.10.2.jar
  1.2 jackson-core-2.10.2.jar
  1.3jackson-databind-2.10.2.jar
  
  2. Драйвер **JDBC** (mssql-jdbc-7.4.1.jre12.jar) Данная библиотека предназначена для работы только с SQL Server
  
#### Настройки класса DataBase:
Путь к классу - com.alexanderdem.db.DataBase
необходимо заполнить следующие поля согласно свой конфигурации SQL сервера
+ dbServerName = "localhost"; //ip SQL Server или имя SQL Server в формате serverName\instanceName
+ dbPort = "5678";            //Порт, который прослушивает SQL Server
+ dbUserName = "Alexander";   //Пользователь базы данных
+ dbPass = "12345";           //Пароль пользователя базы данных

### Запуск 
Класс, с которого запускается программа - com.alexanderdem.**InitDB**
