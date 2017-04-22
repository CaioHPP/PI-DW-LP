package br.com.utfpr.mavenproject;
import java.util.ArrayList;
import java.util.List;

public class DAOCliente extends DAOGenerico<Cliente> {

    public DAOCliente() {
        super(Cliente.class);
    }

    public int autoIdCliente() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idCliente) FROM Cliente e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Cliente> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Cliente e WHERE e.nome LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Cliente> listById(int id) {
        return em.createQuery("SELECT e FROM Cliente e WHERE e.idCliente = :id").setParameter("id", id).getResultList();
    }

    public List<Cliente> listInOrderNome() {
        return em.createQuery("SELECT e FROM Cliente e ORDER BY e.nome").getResultList();
    }

    public List<Cliente> listInOrderId() {
        return em.createQuery("SELECT e FROM Cliente e ORDER BY e.idCliente").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Cliente> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdCliente()
 + "-" + lf.get(i).getNome()
 + "-" + lf.get(i).getTelefone()
 + "-" + lf.get(i).getSexo()
 + "-" + lf.get(i).getCpf()
 + "-" + lf.get(i).getEmail()
 + "-" + lf.get(i).getDataN()
 + "-" + lf.get(i).getEndereco()
 + "-" + lf.get(i).getInstrumento()
);
        }
        return ls;
    }
}