package br.com.cicada.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class ETLProcessor {
	
	private static final Logger logger = LoggerFactory.getLogger(ETLProcessor.class);
	
	private MetascaleCore metascaleCore;

	public ETLProcessor(MetascaleCore metascaleCore) {
		this.metascaleCore = metascaleCore;
	}

	public void runETL(String resourceUrl, String key) {
		logger.info("Iniciando o processo de ETL...");

		// Verificação no DynamoDB
		JsonNode existingData = metascaleCore.getRepository().loadData(key);
		if (existingData != null) {
			logger.info("Dados já existentes no DynamoDB para a chave: " + key);
			return;
		}

		// Extração
		JsonNode data = metascaleCore.getClient().fetchData(resourceUrl);
		if (data == null) {
			logger.error("Falha ao extrair dados da URL: " + resourceUrl);
			return;
		}
		logger.info("Dados extraídos: " + data.toString());

		// Transformação
		JsonNode transformedData = transformData(data, metascaleCore.getMetadata());
		logger.info("Dados transformados: " + transformedData.toString());

		// Carregamento
		metascaleCore.getRepository().saveData(transformedData);
		logger.info("Dados carregados no DynamoDB com sucesso.");
	}

	private JsonNode transformData(JsonNode data, Metadata metadata) {
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode transformedData = objectMapper.createObjectNode();

		data.fields().forEachRemaining(entry -> {
			String key = entry.getKey();
			JsonNode value = entry.getValue();
			String canonicalKey = metadata.getMapping(key);

			if (value.isArray()) {
				ArrayNode transformedArray = objectMapper.createArrayNode();
				value.forEach(item -> transformedArray.add(transformData(item, metadata)));
				transformedData.set(canonicalKey, transformedArray);
			} else {
				transformedData.set(canonicalKey, value);
			}
		});

		return transformedData;
	}
}
