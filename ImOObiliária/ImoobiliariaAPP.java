import java.lang.String;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import Exceptions.*;

public class ImoobiliariaAPP {
    // variáveis de instância
    private static Imoobiliaria atual = new Imoobiliaria();
    private static Utilizador atualUser;
    
    public static void initApp() {
        try {
            Vendedor v1 = new Vendedor("Esmeralda Fernandes", "esmeralda@email.com", "esmeralda", "Rua da Universidade, N.º 1", "01-02-1996");
            atual.registarUtilizador(v1);
            Vendedor v2 = new Vendedor("Diogo Machado", "diogo@email.com", "diogo", "Rua do Paraíso, N.º 2", "03-04-1996");
            atual.registarUtilizador(v2);
            Vendedor v3 = new Vendedor("Miguel Miranda", "miguel@email.com", "miguel", "Travessa dos Machados, N.º 3", "05-06-1996");
            atual.registarUtilizador(v3);
            Vendedor v4 = new Vendedor("Rui Leite", "rui@email.com", "rui", "Rua dos Peões, N.º4", "07-08-1996");
            atual.registarUtilizador(v4);
            Comprador c1 = new Comprador("Maria Almeida", "maria@email.com", "maria", "Rua das Árvores, N.º5", "01-01-1981");
            atual.registarUtilizador(c1);
            Comprador c2 = new Comprador("Ana Marques", "anamarques@email.com", "ana", "Rua das Árvores, N.º4", "02-01-1996");
            atual.registarUtilizador(c2);
            Comprador c3 = new Comprador("Nadine Oliveira", "nadine@email.com", "nadine", "Rua dos Outeiros, N.º15", "05-06-1997");        }
        catch(UtilizadorExistenteException e) {
            System.out.println(e.getMensagem());
        }
    }
    
    public void iniciaSessao(String email, String password) throws SemAutorizacaoException {
        if (!atual.getUtilizadores().containsKey(email)) throw new SemAutorizacaoException();
        else {
            Utilizador aux = atual.getUtilizadores().get(email);
        }
    }
}