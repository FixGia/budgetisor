package fr.fixgia.budgetisor;

import fr.fixgia.budgetisor.model.Protocol;

import java.util.List;
import java.util.UUID;

public interface ProtocolService {

    // Create
    void createProtocol(Protocol protocol);

    // Read
    Protocol getProtocolById(UUID id);
    // Update
    void updateProtocol(Protocol protocol);

    // Delete
    void deleteProtocol(UUID id);

    List<Protocol> getAllProtocols();
}
