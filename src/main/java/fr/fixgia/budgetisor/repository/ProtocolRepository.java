package fr.fixgia.budgetisor.repository;

import fr.fixgia.budgetisor.model.Protocol;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProtocolRepository extends MongoRepository<Protocol, String> {


    Optional<Protocol> getProtocolById(UUID uuid);

    Optional<Protocol> getProtocolByName(String name);
}
