package br.com.cicada.core;

import br.com.cicada.client.Client;
import br.com.cicada.repository.Repository;

public class MetascaleCore {
	private Client client;
	private Metadata metadata;
	private Repository repository;

	public MetascaleCore(Client client, Metadata metadata, Repository repository) {
		this.client = client;
		this.metadata = metadata;
		this.repository = repository;
	}

	public Client getClient() {
		return client;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public Repository getRepository() {
		return repository;
	}

	public void process() {

	}
}
