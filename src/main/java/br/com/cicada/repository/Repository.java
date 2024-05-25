package br.com.cicada.repository;

import com.fasterxml.jackson.databind.JsonNode;

public class Repository {
    public void saveData(Object data) {
        // Implementar a lógica para salvar dados no DynamoDB
    }

    public JsonNode loadData(String key) {
        // Implementar a lógica para carregar dados do DynamoDB
        return null;
    }
}