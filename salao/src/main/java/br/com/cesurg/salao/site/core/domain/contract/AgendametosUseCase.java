package br.com.cesurg.salao.site.core.domain.contract;

import br.com.cesurg.salao.site.core.domain.entity.Agendamentos;

import java.util.List;

public interface AgendametosUseCase {
    public void insert (Agendamentos agendamentos);
    public void update (int id, Agendamentos agendamentos);
    public void delete (int id);
    public List<Agendamentos> fetch();
    public Agendamentos get (int id);
}
