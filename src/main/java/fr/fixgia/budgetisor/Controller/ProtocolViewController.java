package fr.fixgia.budgetisor.Controller;

import fr.fixgia.budgetisor.ProtocolService;
import fr.fixgia.budgetisor.model.Protocol;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller("/showprotocol")
public class ProtocolViewController {

    private final ProtocolService protocolService;

    public ProtocolViewController(ProtocolService protocolService) {
        this.protocolService = protocolService;
    }

    @GetMapping("/")
    public String getProtocol(@PathVariable("id")final UUID uuid, Model model) {

        Protocol protocol = protocolService.getProtocolById(uuid);

        model.addAttribute("name", protocol.getName());
        model.addAttribute("reagents", protocol.getReagentList());
        model.addAttribute("consumables", protocol.getConsumableList());

        return "protocol";
    }

    @GetMapping({"/list"})
    public String getProtocolList(
            final Model model,
            @Param("keyword") final String keyword) {

        model.addAttribute("protocols", protocolService.getAllProtocols());

        model.addAttribute("keyword", keyword);

        return "protocol/list";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") final UUID uuid, Model model) {

        Protocol protocol = protocolService.getProtocolById(uuid);
        model.addAttribute("protocolRequest", protocol);

        return "protocol/update";

    }
    }