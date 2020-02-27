package com.alexanderdem.http;

import com.alexanderdem.InitDB;

import java.net.URI;

public class UriList {
    private final URI nomenclatureUti;
    private InitDB initDB;

    public UriList(InitDB initDB) {
        this.initDB = initDB;
        nomenclatureUti = URI.create("http://185.220.32.104:8080/test-sales/api/nomenclature");
    }

    public URI getUri(String alias, String date) {
        initDB.showMessage("1. Сгенерирован URI: запрос о кассовых сменах (" + alias + ", " + date + ")");
        return URI.create("http://185.220.32.104:8080/test-sales/api/departments/" + alias + "/cashsessions/" + date);
    }
    public URI getUri(String id) {
        initDB.showMessage("1. Сгенерирован URI: запрос о продажах кассовой смены");
        return URI.create("http://185.220.32.104:8080/test-sales/api/cashsessions/"+ id+"/orders/content");
    }

    public URI getNomenclatureUri() {
        initDB.showMessage("1. Сгенерирован URI: Инициализация номенклатуры");
        return nomenclatureUti;
    }
}
