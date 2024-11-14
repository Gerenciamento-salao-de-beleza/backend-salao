package br.com.cesurg.salao.site.infra.repository.database;

import br.com.cesurg.salao.site.core.domain.contract.AgendamentosRepository;
import br.com.cesurg.salao.site.core.domain.entity.Agendamentos;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AgendamentoRepositoryImpl implements AgendamentosRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void insert(Agendamentos agendamentos) {
        var query = """
            INSERT INTO agendamentos(funcionario_id, nome_cliente, telefone_cliente, data_hora, servico, status)
            VALUES(:funcionario_id, :nome_cliente, :telefone_cliente, :data_hora, :servico, :status)
            """;
        entityManager.createNativeQuery(query)
                .setParameter("funcionario_id", agendamentos.getFuncionarioID())
                .setParameter("nome_cliente", agendamentos.getNomeCliente())
                .setParameter("telefone_cliente", agendamentos.getTelefoneCliente())
                .setParameter("data_hora", agendamentos.getDataHora())
                .setParameter("servico", agendamentos.getServico())
                .setParameter("status", agendamentos.getStatus())
                .executeUpdate();
    }

    @Transactional
    public void update(int id, Agendamentos agendamentos) {
        var query = """
            UPDATE agendamentos
            SET funcionario_id = :funcionario_id,
                nome_cliente = :nome_cliente,
                telefone_cliente = :telefone_cliente,
                data_hora = :data_hora,
                servico = :servico,
                status = :status
            WHERE id = :id
            """;
        entityManager.createNativeQuery(query)
                .setParameter("funcionario_id", agendamentos.getFuncionarioID())
                .setParameter("nome_cliente", agendamentos.getNomeCliente())
                .setParameter("telefone_cliente", agendamentos.getTelefoneCliente())
                .setParameter("data_hora", agendamentos.getDataHora())
                .setParameter("servico", agendamentos.getServico())
                .setParameter("status", agendamentos.getStatus())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    public void delete(int id) {
        var query = """
            DELETE FROM agendamentos WHERE id = :id;
            """;
        entityManager.createNativeQuery(query)
                .setParameter("id", id)
                .executeUpdate();
    }

    public List<Agendamentos> fetch() {
        var query = """
            SELECT * FROM agendamentos;
            """;
        return entityManager.createNativeQuery(query, Agendamentos.class).getResultList();
    }

    public Agendamentos get(int id) {
        var query = """
            SELECT * FROM agendamentos WHERE id = :id;
            """;
        return (Agendamentos) entityManager.createNativeQuery(query, Agendamentos.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
