package br.com.cicada.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client {
	private static final Logger logger = LoggerFactory.getLogger(Client.class);

	/**
	 * Busca dados de uma URL fornecida e retorna os dados como um objeto JsonNode.
	 *
	 * O método realiza uma requisição HTTP GET à URL fornecida e processa a
	 * resposta. Em caso de sucesso, os dados da resposta são convertidos para um
	 * objeto JsonNode usando Jackson.
	 *
	 * @param resourceUrl A URL da qual buscar os dados. Não pode ser nula ou vazia.
	 * @return Um objeto JsonNode contendo os dados buscados, ou null em caso de
	 *         falha.
	 * @throws IllegalArgumentException se a URL fornecida for nula ou vazia.
	 */
	public JsonNode fetchData(String resourceUrl) throws IllegalArgumentException {
		if (resourceUrl == null || resourceUrl.trim().isEmpty()) {
			logger.error("A URL da requisição não pode ser nula ou vazia.");
			throw new IllegalArgumentException("A URL da requisição não pode ser nula ou vazia.");
		}

		HttpURLConnection connection = null;
		try {
			// Abre uma conexão HTTP
			URL url = new URL(resourceUrl);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			int responseCode = connection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				// Lê os dados da resposta
				try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
					StringBuilder content = new StringBuilder();
					String inputLine;

					// Lê cada linha da resposta e adiciona ao StringBuilder
					while ((inputLine = in.readLine()) != null) {
						content.append(inputLine);
					}

					ObjectMapper objectMapper = new ObjectMapper();
					JsonNode result = objectMapper.readTree(content.toString());
					logger.info("Dados extraídos com sucesso da URL: " + resourceUrl);
					return result;
				}
			} else {
				logger.error("Requisição GET falhou com o status: " + responseCode);
				return null;
			}
		} catch (Exception e) {
			logger.error("Erro ao tentar buscar dados da URL: " + resourceUrl, e);
			return null;
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}
}
