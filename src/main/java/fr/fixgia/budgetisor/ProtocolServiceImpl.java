package fr.fixgia.budgetisor;

import fr.fixgia.budgetisor.model.Protocol;
import fr.fixgia.budgetisor.repository.ProtocolRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class ProtocolServiceImpl implements ProtocolService{
    private final ProtocolRepository protocolRepository;

    public ProtocolServiceImpl(ProtocolRepository protocolRepository) {
        this.protocolRepository = protocolRepository;
    }

    @Override
    public void createProtocol(Protocol protocol) {
      Optional<Protocol> protocolToCreate = protocolRepository.getProtocolById(protocol.getId());
      if(protocolToCreate.isEmpty()) {
          protocol.setId(UUID.randomUUID());
          protocolRepository.save(protocol);
          log.info(" le protocol avec l'id {} a été crée", protocol.getId());
      }
    }

    @Override
    public Protocol getProtocolById(UUID id) {
        Optional<Protocol> protocolToGet = protocolRepository.getProtocolById(id);
        return protocolToGet.orElse(null);
    }

    @Override
    public void updateProtocol(Protocol protocol) {
        Optional<Protocol> protocolToUpdate = protocolRepository.getProtocolById(protocol.getId());

        if(protocolToUpdate.isPresent()) {
            protocolToUpdate.get().setName(protocol.getName());
            protocolToUpdate.get().setConsumableList(protocol.getConsumableList());
            protocolToUpdate.get().setReagentList(protocol.getReagentList());
            protocolRepository.save(protocolToUpdate.get());
        }
    }

    @Override
    public void deleteProtocol(UUID id) {

        Optional<Protocol> protocolToDelete = protocolRepository.getProtocolById(id);
        protocolToDelete.ifPresent(protocolRepository::delete);
    }

    @Override
    public List<Protocol> getAllProtocols() {
        return protocolRepository.findAll();
    }
}
