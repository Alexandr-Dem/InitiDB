package com.alexanderdem.json;

import com.alexanderdem.InitDB;
import com.alexanderdem.pojo.CashSession;
import com.alexanderdem.pojo.ItemOfNomenclature;
import com.alexanderdem.pojo.Pojo;
import com.alexanderdem.pojo.SalesCS;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class JsonConvert  {
    private InitDB initDB;

    public JsonConvert(InitDB initDB) {
        this.initDB = initDB;
    }

    public List<Pojo> convertJsonToPojo (String json, Pojo pojo) {

        ObjectMapper objectMapper = new ObjectMapper();
        List<Pojo> list = null;
        try {
            //определяем класс Pojo и прочитываем  JSON
            if (pojo instanceof ItemOfNomenclature) {
                list = Arrays.asList(objectMapper.readValue(json, ItemOfNomenclature[].class));
            } else {
                if (pojo instanceof CashSession) {
                    list = Arrays.asList(objectMapper.readValue(json, CashSession[].class));
                } else {
                    list = Arrays.asList(objectMapper.readValue(json, SalesCS[].class));
                }
            }
            initDB.showMessage("3. JSON преобразован в POJO");
        } catch (JsonProcessingException e) {
            initDB.showMessage("ОШИБКА в конвертации JSON в POJO");
            initDB.showMessage(e.getMessage());
            e.printStackTrace();
        }
        return list;
    }
}
