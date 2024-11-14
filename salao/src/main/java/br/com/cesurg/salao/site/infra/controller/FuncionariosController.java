package br.com.cesurg.salao.site.infra.controller;

import br.com.cesurg.salao.site.core.domain.contract.FuncionariosUseCase;
import br.com.cesurg.salao.site.core.domain.entity.Funcionarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class FuncionariosController {

    @Autowired
    private FuncionariosUseCase funcionariosUseCase;

    @PostMapping("/funcionarios")
    public void insert(@RequestBody Funcionarios funcionarios) {
        funcionariosUseCase.insert(funcionarios);
    }

    @GetMapping("/funcionarios")
    public List<Funcionarios> fetch() {
        return funcionariosUseCase.fetch();
    }

    @PutMapping("/funcionarios/{id}")
    public void update(@PathVariable int id, @RequestBody Funcionarios funcionarios) {
        funcionariosUseCase.update(id, funcionarios);
    }

    @DeleteMapping("/funcionarios/{id}")
    public void delete(@PathVariable int id) {
        funcionariosUseCase.delete(id);
    }

    @GetMapping("/funcionarios/{id}")
    public Funcionarios get(@PathVariable int id) {
        return funcionariosUseCase.get(id);
    }
}

