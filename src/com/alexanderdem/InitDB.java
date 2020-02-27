package com.alexanderdem;

import com.alexanderdem.db.DatabaseHandler;
import com.alexanderdem.gui.Window;
import com.alexanderdem.json.JsonConvert;
import com.alexanderdem.http.HttpHandler;
import com.alexanderdem.http.UriList;
import com.alexanderdem.pojo.*;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class InitDB {

    private UriList uriList; //Хранить в себе спсиок всех URI, а так же умеет их генерировать на основе входных данных
    private HttpHandler httpHandler;//Осуществляет GET зпрос и возвращает JSON
    private JsonConvert jsonConvert;//Преобразует JSON в POJO
    private DatabaseHandler databaseHandler;//Работает с БД, проверяет данные на актуальность, а после добавляет, обновляет или игнорирует их
    private Window window;//GUI
    private String alias;
    private HashMap<String, Integer> changesInTables = new HashMap<String, Integer>(); //реестр, который хранит информацию о том сколько строк поменялось
                                                                        //в каждой затронутой таблице и название этой таблицы

    public static void main(String[] args) {
        new InitDB();
    }

    private InitDB() {
        window = new Window(this);
        uriList = new UriList(this);
        httpHandler = new HttpHandler(this);
        jsonConvert = new JsonConvert(this);
        databaseHandler = new DatabaseHandler(this);
        //инициализируем номенклатуру
        initialisationDB(uriList.getNomenclatureUri(), new ItemOfNomenclature());
        //разрешаем пользователю работать с GUI
        window.ready();
    }

    public void go(String alias, String date) {
        this.alias = alias;
        initialisationDB(uriList.getUri(alias, date), new CashSession());
    }

    private void initialisationDB(URI uri, Pojo pojo) {

        try {
            //получаем JSON
            String json = ((String) httpHandler.requestGET(uri).body());

            //Конвертируем JSON в POJO
            List<Pojo> items = jsonConvert.convertJsonToPojo(json, pojo);

            if (items.size() == 0) return;

            //Если получили CashSession, то добавляем им нужный Alias, так как в JSON алианс не содержится, а он важен
            if (items.get(0) instanceof CashSession) {
                for (Pojo item : items) {
                    ((CashSession) item).setDepartmentAlias(alias);
                }
            }

            //Обрабатываем POJO в базе данных
            databaseHandler.uploadToDB(items);

            //выводмт в GUI количество измененных в таблицах строк
            showTableChange();

            //Если добавили POJO в таблицу CashSession, то необходимо сделать новый HTTP - запрос и добавить в базу SalesCS
            if (items.get(0) instanceof CashSession) {
                for (Pojo item : items) {
                    initialisationDB(uriList.getUri(((CashSession) item).getId()), new SalesCS());
                }
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            showMessage("ОШИБКА в конвертации JSON в POJO \n" + e.getMessage());
        } catch (IOException | InterruptedException e) {
            showMessage("ОШИБКА в HTTP-запросе!\n" + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            showMessage("ОШИБКА добавления POJO в базу данных!\n" + e.getMessage());
        }
    }

    public void showMessage(String message) {
        window.showMessage(" " + message + "\n");
    }

    public void tableChange (String name) {
        if (changesInTables.containsKey(name)) {
            changesInTables.put(name, changesInTables.get(name) + 1);
        } else {
            changesInTables.put(name, 1);
        }
    }

    private void showTableChange(){
        String result = "4. Работа с базой данных:\n";
        if (changesInTables.size() == 0) {
            result += "База данных актуальна, изменения не произведены.\n";
        } else {
            for (String s : changesInTables.keySet()) {
                result += "Изменены данные в таблице '" + s + "'. Количество строк: " + changesInTables.get(s) + ".\n";
            }
        }
        result += "--------------------------------------------------------------------------";
        showMessage(result);
        changesInTables.clear();
    }
}
