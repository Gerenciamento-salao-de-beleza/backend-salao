package br.com.cesurg.salao.site.core.domain.contract;

import br.com.cesurg.salao.site.core.domain.entity.Funcionarios;

import java.util.List;

public interface FuncionariosRepository {
    public void insert (Funcionarios funcionarios);
    public void update (int id, Funcionarios funcionarios);
    public void delete (int id);
    public List<Funcionarios> fetch();
    public Funcionarios get (int id);
}
