package br.com.cicada.core;

import java.util.Map;

public class Metadata {
	private Map<String, String> mappings;

	public Metadata(Map<String, String> mappings) {
		this.mappings = mappings;
	}

	public String getMapping(String key) {
		return mappings.get(key);
	}
}