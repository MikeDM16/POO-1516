import java.lang.String;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.Scanner;
import Exceptions.*;

public class ImoobiliariaAPP {
    // variáveis de instância
    private static Imoobiliaria atual = new Imoobiliaria();
    private static Utilizador atualUser;
    private boolean online;
    private int comando;
    
    public ImoobiliariaAPP() {
        initApp();
        runApp();
        saida();
    }
    
    private static void limpaTerminal() {
        for (int i = 0; i < 20; i++) System.out.println("");
    }
    
    /**
     * Função que insere utilizadores na aplicação
     */
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
            Comprador c3 = new Comprador("Nadine Oliveira", "nadine@email.com", "nadine", "Rua dos Outeiros, N.º15", "05-06-1997");
            atual.registarUtilizador(c3);
            Comprador c4 = new Comprador("Nira Fernandes", "nira@email.com", "nira", "Avenida de Brasil, N.º7", "18-07-1970");
            atual.registarUtilizador(c4);
        }
        catch(UtilizadorExistenteException e) {
            System.out.println(e.getMensagem());
        }
    }
    
    /**
     * Funções de impressão de cabeçalhos e menus
     */
    private static void cabecalho() {
        System.out.println("  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println("|                                                                             |");
        System.out.println("|                                 IMOOBILIARIA                                |");
        System.out.println("|                                                                             |");
        System.out.println("  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n");
    }
    private static void saida() {
        limpaTerminal();
        System.out.println("  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println("|                                                                             |");
        System.out.println("| Ana Esmeralda Fernandes                                                     |");
        System.out.println("| Diogo Gonçalves Machado                                                     |");
        System.out.println("| Miguel Dias Miranda                                                         |");
        System.out.println("| Rui Filipe Leite                                                            |");
        System.out.println("|                                                                             |");
        System.out.println("|                              PROGRAMA ENCERRADO                             |");
        System.out.println("|                                                                             |");
        System.out.println("  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n");
    }
    private static void menu_principal() {
        System.out.println("(1) - Iniciar sessão");
        System.out.println("(2) - Fazer registo");
        System.out.println("(0) - Sair\n");
    }
    private static void menu_conjunto() {
        System.out.println("(1) - Consultar imóveis de um tipo e até um preço");
        System.out.println("(2) - Consultar lista dos imóveis habitáveis, até um preço");
        System.out.println("(3) - Obter correspondência entre imóveis e vendedores");
        System.out.println("(0) - Sair\n");
    }
    private static void menu_sessaoIniciadaC() {
        System.out.println("(0) - Fechar sessão");
    }
    private static void menu_sessaoIniciadaV() {
        System.out.println("(0) - Fechar sessão");
    }
    
    /**
     * Função que verifica se um email é válido
     */
    public boolean emailValido(String email) {
        if (!email.contains("@") || !email.contains(".")) return false;
        return true;
    }
    
    /**
     * Função que inicia a sessao de um utilizador (o email que recebe é válido)
     */
    public void iniciaSessao(String email, String password) throws SemAutorizacaoException {
        Utilizador aux = atual.getUtilizadores().get(email);
        if (!aux.getPass().equals(password)) throw new SemAutorizacaoException();
        else {
            this.atualUser = aux;
            this.online = true;
        }
    }
    
    /**
     * Função responsável por passar os parâmetros de inicio de sessão a iniciaSessao (verifica se o email é válido)
     */
    private boolean autenticacao() throws SemAutorizacaoException {
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        System.out.print("Email: ");
        String email = input.next();
        if (!emailValido(email)) return false;
        if (!atual.getUtilizadores().containsKey(email)) return false;
        System.out.print("Password: ");
        String password = input.next();
        iniciaSessao(email, password);
        return true;
    }
    
    /**
     * Função responsável por fechar a sessão do utilizador atual
     */
    public void fechaSessao() {
        this.online = false;
    }
    
    /**
     * Função responsável por passar os parâmetros de registo de utilizador
     */
    private void registo() throws UtilizadorExistenteException {
        limpaTerminal();
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("REGISTO DE UTILIZADOR\n");
        Utilizador novo;
        System.out.println("Pretende registar-se como vendedor(V) ou comprador(C)?");
        String tipo = input.next();
        System.out.print("Nome: ");
        String nome = input.next();
        System.out.print("Email: ");
        String email = input.next();
        while(atual.getUtilizadores().containsKey(email)) {
            System.out.print("Email já existe. Introduza outro: ");
            email = input.next();
        }
        System.out.print("Password: ");
        String password = input.next();
        System.out.print("Morada: ");
        String morada = input.next();
        System.out.print("Data de nascimento: ");
        String dataN = input.next();
        if (tipo.equals("V")) novo = new Vendedor(nome, email, password, morada, dataN);
        else novo = new Comprador(nome, email, password, morada, dataN);
        atual.registarUtilizador(novo);
    }
    
    private static int novoComandoInt() {
        System.out.print("Insira o comando: ");
        Scanner input = new Scanner(System.in);
        return (input.nextInt());
    }
    
    public void runApp() {
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        boolean run = true, clean = true;
        while (run) {
            if (clean) limpaTerminal();
            cabecalho();
            menu_principal();
            try {
                this.comando = novoComandoInt();
                switch (comando) {
                    case 0:
                        run = false;
                        break;
                    case 1:
                        boolean result = autenticacao();
                        while (!result) {
                            System.out.println("A autenticação falhou. Verifique se introduziu um email válido.\n Pretende tentar de novo?     S | N");
                            String d = input.next();
                            if (d.equals("S")) autenticacao();
                            else break;
                        }
                        if (result) {
                            if (this.atualUser.getClass().getName().equals("Comprador")) interpretadorC();
                            else interpretadorV();
                        }
                        break;
                    case 2:
                        registo();
                        break;
                }
            }
            catch(SemAutorizacaoException e) {
                System.out.println(e.getMensagem());
                clean = false;
            }
            catch(UtilizadorExistenteException e) {
                System.out.println(e.getMensagem());
                clean = false;
            }
        }
    }
    
    public void interpretadorC() {
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        boolean run = true;
        System.out.println("Sessão iniciada como comprador");
        System.out.println("Bem-vindo " + atualUser.getNome());
        while (run) {
            limpaTerminal();
            menu_sessaoIniciadaC();
            /*try {*/
                this.comando = novoComandoInt();
                switch (comando) {
                    case 0:
                        run = false;
                        break;
                    }
            /*}*/
        }
    }
    
    public void interpretadorV() {
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        boolean run = true;
        System.out.println("Sessão iniciada como vendedor");
        System.out.println("Bem-vindo " + atualUser.getNome());
        while (run) {
            limpaTerminal();
            menu_sessaoIniciadaC();
            /*try {*/
                this.comando = novoComandoInt();
                switch (comando) {
                    case 0:
                        run = false;
                        break;
                    }
            /*}*/
        }
    }
}