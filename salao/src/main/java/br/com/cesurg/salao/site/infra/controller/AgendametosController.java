package br.com.cesurg.salao.site.infra.controller;

import br.com.cesurg.salao.site.core.domain.contract.AgendametosUseCase;
import br.com.cesurg.salao.site.core.domain.entity.Agendamentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class AgendametosController {

    @Autowired
    private AgendametosUseCase agendametosUseCase;

    @PostMapping("/agendamentos")
    public void insert(@RequestBody Agendamentos agendamentos) {

        agendametosUseCase.insert(agendamentos);
    }

    @GetMapping("/agendamentos")
    public List<Agendamentos> fetch() {
        return agendametosUseCase.fetch();
    }

    @PutMapping("/agendamentos/{id}")
    public void update(@PathVariable int id, @RequestBody Agendamentos Agendamentos) {
        agendametosUseCase.update(id, Agendamentos);
    }

    @DeleteMapping("/agendamentos/{id}")
    public void delete(@PathVariable int id) {
        agendametosUseCase.delete(id);
    }

    @GetMapping("/agendamentos/{id}")
    public Agendamentos get(@PathVariable int id) {
        return agendametosUseCase.get(id);
    }
}
