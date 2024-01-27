package fr.fixgia.budgetisor.Controller;

import fr.fixgia.budgetisor.ProtocolService;
import fr.fixgia.budgetisor.model.Protocol;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/procotols")
@Slf4j
public class ProtocolController {


    private final ProtocolService protocolService;

    public ProtocolController(ProtocolService protocolService) {
        this.protocolService = protocolService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Protocol> getProtocol(@PathVariable UUID id) {

        Protocol protocol = protocolService.getProtocolById(id);

        return (protocol != null) ? ResponseEntity.ok(protocol) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Protocol>> getAllProtocols() {
        List<Protocol> protocols = protocolService.getAllProtocols();
        return ResponseEntity.ok(protocols);
    }

    @PostMapping
    public ResponseEntity<Void> saveProtocol(@RequestBody Protocol protocol) {
        log.debug("Controller ProtocolApplication: create Protocol - Called");
        protocolService.createProtocol(protocol);
        log.info("Le protocol avec le nom {} a été crée", protocol.getName());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProtocol(@PathVariable UUID id, @RequestBody Protocol protocol) {
        Protocol existingProtocol = protocolService.getProtocolById(id);

        if (existingProtocol != null) {
            protocolService.updateProtocol(protocol);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProtocol(@PathVariable UUID id) {
        Protocol existingProtocol = protocolService.getProtocolById(id);

        if (existingProtocol != null) {
            protocolService.deleteProtocol(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
