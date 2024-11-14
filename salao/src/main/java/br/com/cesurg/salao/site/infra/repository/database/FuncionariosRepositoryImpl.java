package br.com.cesurg.salao.site.infra.repository.database;

import br.com.cesurg.salao.site.core.domain.contract.FuncionariosRepository;
import br.com.cesurg.salao.site.core.domain.entity.Funcionarios;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class FuncionariosRepositoryImpl implements FuncionariosRepository {

    @Autowired
    private EntityManager entityManager;


    @Transactional
    public void insert(Funcionarios funcionarios) {
        var query = """
            INSERT INTO funcionarios(nome, telefone, servico, duracao_minutos, horario_inicio, horario_fim, dias_trabalhos)
            VALUES (:nome, :telefone, :servico, :duracao_minutos, :horario_inicio, :horario_fim, :dias_trabalhos)
            """;
        entityManager.createNativeQuery(query, Funcionarios.class)
                .setParameter("nome", funcionarios.getNome())
                .setParameter("telefone", funcionarios.getTelefone())
                .setParameter("servico", funcionarios.getServico())
                .setParameter("duracao_minutos", funcionarios.getDuracaoMinutos())
                .setParameter("horario_inicio", funcionarios.getHorarioInicio())
                .setParameter("horario_fim", funcionarios.getHorarioFim())
                .setParameter("dias_trabalhos", funcionarios.getDiasTrabalhos())
                .executeUpdate();
    }


    @Transactional
    public void update(int id, Funcionarios funcionarios) {
        var query = """
            UPDATE funcionarios
            SET nome = :nome,
                telefone = :telefone,
                servico = :servico,
                duracao_minutos = :duracao_minutos,
                horario_inicio = :horario_inicio,
                horario_fim = :horario_fim,
                dias_trabalhos = :dias_trabalhos
            WHERE id = :id
            """;
        entityManager.createNativeQuery(query, Funcionarios.class)
                .setParameter("nome", funcionarios.getNome())
                .setParameter("telefone", funcionarios.getTelefone())
                .setParameter("servico", funcionarios.getServico())
                .setParameter("duracao_minutos", funcionarios.getDuracaoMinutos())
                .setParameter("horario_inicio", funcionarios.getHorarioInicio())
                .setParameter("horario_fim", funcionarios.getHorarioFim())
                .setParameter("dias_trabalhos", funcionarios.getDiasTrabalhos())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    public void delete(int id) {
        var query = """
            DELETE FROM funcionarios WHERE id = :id
            """;
        entityManager.createNativeQuery(query)
                .setParameter("id", id)
                .executeUpdate();
    }

    public List<Funcionarios> fetch() {
        var query = """
            SELECT * FROM funcionarios
            """;
        return entityManager.createNativeQuery(query, Funcionarios.class).getResultList();
    }

    public Funcionarios get(int id) {
        var query = """
            SELECT * FROM funcionarios WHERE id = :id
            """;
        return (Funcionarios) entityManager.createNativeQuery(query, Funcionarios.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
