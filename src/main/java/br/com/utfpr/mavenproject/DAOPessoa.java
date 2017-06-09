package br.com.utfpr.mavenproject;
import Entidades.Pessoa;
import java.util.ArrayList;
import java.util.List;

public class DAOPessoa extends DAOGenerico<Pessoa> {

    public DAOPessoa() {
        super(Pessoa.class);
    }

    public int autoIdPessoa() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idCliente) FROM Pessoa e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }
    public void RemoveIguais(){
        em.createQuery("delete from Pessoa where Pessoa.cpf in (select cpf_a from (select cpf as cpf_a from cliente group by Nome\n" +
"having Count(cpf)>1) as c ) and id_cliente not in (select min_id from (select Min(id_cliente) as min_id from cliente group by Nome having Count(cpf)>1) as d) ;");
   }

    public List<Pessoa> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Pessoa e WHERE e.nome LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Pessoa> listById(int id) {
        return em.createQuery("SELECT e FROM Pessoa e WHERE e.idCliente = :id").setParameter("id", id).getResultList();
    }

    public List<Pessoa> listInOrderNome() {
        return em.createQuery("SELECT e FROM Pessoa e ORDER BY e.nome").getResultList();
    }

    public List<Pessoa> listInOrderId() {
        return em.createQuery("SELECT e FROM Pessoa e ORDER BY e.idCliente").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Pessoa> lf;
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
 + "-" + lf.get(i).getLogin()
 + "-" + lf.get(i).getSenha()
 + "-" + lf.get(i).getTipo()
);
        }
        return ls;
    }
}
