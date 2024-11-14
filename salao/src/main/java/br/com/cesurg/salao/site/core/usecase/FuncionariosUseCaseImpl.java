package br.com.cesurg.salao.site.core.usecase;

import br.com.cesurg.salao.site.core.domain.contract.AgendamentosRepository;
import br.com.cesurg.salao.site.core.domain.contract.AgendametosUseCase;
import br.com.cesurg.salao.site.core.domain.contract.FuncionariosRepository;
import br.com.cesurg.salao.site.core.domain.contract.FuncionariosUseCase;
import br.com.cesurg.salao.site.core.domain.entity.Agendamentos;
import br.com.cesurg.salao.site.core.domain.entity.Funcionarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionariosUseCaseImpl implements FuncionariosUseCase {

    @Autowired
    private FuncionariosRepository funcionariosRepository;

    @Override
    public void insert(Funcionarios funcionarios) {
        funcionariosRepository.insert(funcionarios);
    }

    @Override
    public void update(int id, Funcionarios funcionarios) {
        funcionariosRepository.update(id, funcionarios);
    }

    @Override
    public void delete(int id) {
        funcionariosRepository.delete(id);
    }

    @Override
    public List<Funcionarios> fetch() {
        return funcionariosRepository.fetch();
    }

    @Override
    public Funcionarios get(int id) {
        return funcionariosRepository.get(id);
    }
}
