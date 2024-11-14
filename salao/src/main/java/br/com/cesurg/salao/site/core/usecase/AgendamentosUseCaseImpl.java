package br.com.cesurg.salao.site.core.usecase;

import br.com.cesurg.salao.site.core.domain.contract.AgendamentosRepository;
import br.com.cesurg.salao.site.core.domain.contract.AgendametosUseCase;
import br.com.cesurg.salao.site.core.domain.entity.Agendamentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentosUseCaseImpl implements AgendametosUseCase {

    @Autowired
    private AgendamentosRepository agendametosRepository;

    @Override
    public void insert(Agendamentos agendamentos) {
        agendametosRepository.insert(agendamentos);
    }

    @Override
    public void update(int id, Agendamentos agendamentos) {
        agendametosRepository.update(id, agendamentos);
    }

    @Override
    public void delete(int id) {
        agendametosRepository.delete(id);
    }

    @Override
    public List<Agendamentos> fetch() {
        return agendametosRepository.fetch();
    }

    @Override
    public Agendamentos get(int id) {
        return agendametosRepository.get(id);
    }
}
