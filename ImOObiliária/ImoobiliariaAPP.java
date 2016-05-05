import java.lang.String;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.Scanner;
import Exceptions.*;

public class ImoobiliariaAPP {
    // variáveis de instância
    private static Imoobiliaria atual;
    private static Utilizador atualUser;
    private static boolean online;
    private static int comando;
    
    private ImoobiliariaAPP() {}
    
    public static void main(String[] args) {
        atual = initApp();
        runApp();
        saida();
    }
    
    public static Utilizador getAtualUser() {
        return atualUser;
    }
    public static boolean estaOnline() {
        return online;
    }
    public static void limpaTerminal() {
        for (int i = 0; i < 20; i++) System.out.println("");
    }
    
    public static boolean temAutorizacao(String nomeClasse) {
        if (atualUser.getClass().getName().equals(nomeClasse)) return true;
        return false;
    }
    
    /**
     * Função que insere utilizadores na aplicação
     */
    public static Imoobiliaria initApp() {
        Imoobiliaria nova = new Imoobiliaria();
        try {
            Vendedor v1 = new Vendedor("Esmeralda Fernandes", "esmeralda@email.com", "esmeralda", "Rua da Universidade, N.º 1", "01-02-1996");
            nova.registarUtilizador(v1);
            Vendedor v2 = new Vendedor("Diogo Machado", "diogo@email.com", "diogo", "Rua do Paraíso, N.º 2", "03-04-1996");
            nova.registarUtilizador(v2);
            Vendedor v3 = new Vendedor("Miguel Miranda", "miguel@email.com", "miguel", "Travessa dos Machados, N.º 3", "05-06-1996");
            nova.registarUtilizador(v3);
            Vendedor v4 = new Vendedor("Rui Leite", "rui@email.com", "rui", "Rua dos Peões, N.º4", "07-08-1996");
            nova.registarUtilizador(v4);
            Comprador c1 = new Comprador("Maria Almeida", "maria@email.com", "maria", "Rua das Árvores, N.º5", "01-01-1981");
            nova.registarUtilizador(c1);
            Comprador c2 = new Comprador("Ana Marques", "anamarques@email.com", "ana", "Rua das Árvores, N.º4", "02-01-1996");
            nova.registarUtilizador(c2);
            Comprador c3 = new Comprador("Nadine Oliveira", "nadine@email.com", "nadine", "Rua dos Outeiros, N.º15", "05-06-1997");
            nova.registarUtilizador(c3);
            Comprador c4 = new Comprador("Nira Fernandes", "nira@email.com", "nira", "Avenida de Brasil, N.º7", "18-07-1970");
            nova.registarUtilizador(c4);
        }
        catch(UtilizadorExistenteException e) {
            System.out.println(e.getMensagem());
        }
        return nova;
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
        System.out.println("(1) - Consultar imóveis de um dado tipo e até um preço");
        System.out.println("(2) - Consultar lista dos imóveis habitáveis, até um preço");
        System.out.println("(3) - Obter correspondência entre imóveis e vendedores");
        System.out.println("(0) - Sair\n");
    }
    private static void menu_sessaoIniciadaC() {
        System.out.println("(1) - Registar um imóvel como favorito");
        System.out.println("(0) - Fechar sessão");
    }
    private static void menu_sessaoIniciadaV() {
        System.out.println("(1) - Registar imóvel");
        System.out.println("(0) - Fechar sessão");
    }
    
    /**
     * Função que verifica se um email é válido
     */
    private static boolean emailValido(String email) {
        if (!email.contains("@") || !email.contains(".")) return false;
        return true;
    }
    
    /**
     * Função que inicia a sessao de um utilizador (o email que recebe é válido)
     */
    public static void iniciaSessao(String email, String password) throws SemAutorizacaoException {
        Utilizador aux = atual.getUtilizadores().get(email);
        if (!aux.getPass().equals(password)) throw new SemAutorizacaoException();
        else {
            atualUser = aux;
            online = true;
        }
    }
    
    /**
     * Função responsável por passar os parâmetros de inicio de sessão (verifica se o email é válido)
     */
    private static boolean autenticacao() throws SemAutorizacaoException {
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
    private static void registoUser() throws UtilizadorExistenteException {
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
    
    /**
     * Função responsável por criar uma Moradia
     */
    private static Moradia registoMoradia(String rua, float precoPedido, float precoMin) {
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("-- Qual o tipo de moradia que pretende registar?");
        System.out.println("    (1) Isolada  (2) Geminada  (3) Banda  (4) Gaveto");
        int tipoMoradia = input.nextInt();
        String tipoM = new String();
        switch (tipoMoradia) {
            case 1:
                tipoM = "Isolada";
                break;
            case 2:
                tipoM = "Geminada";
                break;
            case 3:
                tipoM = "Banda";
                break;
            case 4:
                tipoM = "Gaveto";
                break;
        }
        System.out.print("-- Área de implantação: ");
        double areaImp = input.nextDouble();
        System.out.print("-- Área total coberta: ");
        double areaTCober = input.nextDouble();
        double areaTEnvol = areaImp - areaTCober;
        System.out.println("-- Área do terreno envolvente: " + areaTEnvol);
        System.out.print("-- Número de quartos: ");
        int nQuartos = input.nextInt();
        System.out.print("-- Número de WCs: ");
        int nWCs = input.nextInt();
        System.out.print("-- Número de porta: ");
        int nPorta = input.nextInt();
        return new Moradia(rua, precoPedido, precoMin, atual.geraReferencia("M", rua, nPorta), tipoM, areaImp, areaTCober, areaTEnvol, nQuartos, nWCs, nPorta);
    }
    /**
     * Função responsável por criar um Apartamento
     */
    private static Apartamento registoApartamento(String rua, float precoPedido, float precoMin) {
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("-- Qual o tipo de apartamento que pretende registar?");
        System.out.println("    (1) Simples  (2) Duplex  (3) Triplex");
        int tipoMoradia = input.nextInt();
        String tipoM = new String();
        switch (tipoMoradia) {
            case 1:
                tipoM = "Simples";
                break;
            case 2:
                tipoM = "Duplex";
                break;
            case 3:
                tipoM = "Triplex";
                break;
        }
        System.out.print("-- Área total: ");
        double areaT = input.nextDouble();
        System.out.print("-- Número de quartos: ");
        int nQuartos = input.nextInt();
        System.out.print("-- Número de WCs: ");
        int nWCs = input.nextInt();
        System.out.print("-- Número de porta: ");
        int nPorta = input.nextInt();
        System.out.print("-- Número de andar: ");
        int nAndar = input.nextInt();
        System.out.print("-- Possui garagem?  S | N: ");
        String SorN = input.next();
        boolean temGar = SorN.equals("S");
        return new Apartamento(rua, precoPedido, precoMin, atual.geraReferencia("A", rua, nPorta), tipoM, areaT, nPorta, nAndar, nQuartos, nWCs, temGar);
    }
    /**
     * Função responsável por criar uma Loja
     */
    private static Loja registoLoja(String rua, float precoPedido, float precoMin) {
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        System.out.print("-- Número de porta: ");
        int nPorta = input.nextInt();
        System.out.print("-- Área total: ");
        double areaT = input.nextDouble();
        System.out.print("-- Tipo de negócio viável: ");
        String tipoN = input.next();
        System.out.print("-- Possui WC?  S | N: ");
        String SorN = input.next();
        boolean temWC = SorN.equals("S");
        System.out.print("-- Possui parte habitacional?  S | N: ");
        SorN = input.next();
        boolean temParteHab = SorN.equals("S");
        Apartamento aux = null;
        if (temParteHab) {
            System.out.println("Insira informações do apartamento\n");
            aux = registoApartamento(rua, precoPedido, precoMin);
        }
        return new Loja(rua, precoPedido, precoMin, atual.geraReferencia("L", rua, nPorta), temWC, nPorta, areaT, tipoN, temParteHab, aux); 
    }
    /**
     * Função responsável por criar um Terreno
     */
    private static Terreno registoTerreno(String rua, float precoPedido, float precoMin) {
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        System.out.print("-- O terreno é para construção de habitação (H) ou de armazéns (A)?");
        String prop = input.next();
        if (prop.equals("H")) prop = "Habitação";
        else prop = "Armazéns";
        System.out.print("-- Diâmetro das canalizações (milímetros): ");
        float diam = input.nextFloat();
        System.out.print("-- kWh máximo suportados pela rede elétrica: ");
        int kWh = input.nextInt();
        System.out.print("-- Possui rede elétrica?  S | N: ");
        String SorN = input.next();
        boolean temRedeE = SorN.equals("S");
        System.out.print("-- Tem acesso à rede de esgotos?  S | N: ");
        SorN = input.next();
        boolean temRedeEsg = SorN.equals("S");
        return new Terreno(rua, precoPedido, precoMin, atual.geraReferencia("T", rua, kWh), prop, diam, kWh, temRedeE, temRedeEsg);
    }
    
    /**
     * Função responsável por passar os parâmetros de registo de imóvel
     */
    private static void registoImovel() throws ImovelExisteException, SemAutorizacaoException {
        limpaTerminal();
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        Imovel novo = null;
        System.out.println("REGISTO DE IMÓVEL\n");
        System.out.println("-- Pretende registar que tipo de imóvel?");
        System.out.println("    (M) Moradia  (A) Apartamento  (L) Loja  (T) Terreno");
        String tipo = input.next();
        System.out.print("-- Rua: ");
        String rua = input.next();
        System.out.print("-- Preço pedido: ");
        float precoPedido = input.nextFloat();
        System.out.print("-- Preço mínimo aceite: ");
        float precoMin = input.nextFloat();
        switch (tipo) {
            case "M":
                novo = registoMoradia(rua, precoPedido, precoMin);
                break;
            case "A":
                novo = registoApartamento(rua, precoPedido, precoMin);
                break;
            case "L":
                novo = registoLoja(rua, precoPedido, precoMin);
                break;
            case "T":
                novo = registoTerreno(rua, precoPedido, precoMin);
                break;
        }
        atual.registarImovel(novo);
    }
    
    private static int novoComandoInt() {
        System.out.print("-- Insira o comando: ");
        Scanner input = new Scanner(System.in);
        return (input.nextInt());
    }
    
    private static void runApp() {
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        boolean run = true, clean = true;
        while (run) {
            if (clean) limpaTerminal();
            cabecalho();
            menu_principal();
            try {
                comando = novoComandoInt();
                switch (comando) {
                    case 0: // sair
                        run = false;
                        break;
                    case 1: // iniciar sessão
                        boolean result = autenticacao();
                        while (!result) {
                            System.out.println("A autenticação falhou. Verifique se introduziu um email válido.\n Pretende tentar de novo?     S | N");
                            String d = input.next();
                            if (d.equals("S")) autenticacao();
                            else break;
                        }
                        if (result) {
                            if (temAutorizacao("Comprador")) interpretadorC();
                            else interpretadorV();
                        }
                        break;
                    case 2: // registar um utilizador
                        registoUser();
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
    
    private static void interpretadorConjunto() {
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        boolean run = true, clean = true;
        while (run) {
            limpaTerminal();
            menu_conjunto();
            /*try {*/
                comando = novoComandoInt();
                switch (comando) {
                    case 0: //sair
                        run = false;
                        break;
                    }
            /*}*/
        }
    }
    
    private static void interpretadorC() {
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        boolean run = true, clean = true;
        while (run) {
            limpaTerminal();
            System.out.println("\nSessão iniciada como comprador\n");
            System.out.println("Bem-vindo(a) " + atualUser.getNome());
            menu_sessaoIniciadaC();
            try {
                comando = novoComandoInt();
                switch (comando) {
                    case 0: //sair
                        run = false;
                        break;
                    case 1: // marcar imóvel como favorito

                        System.out.print("-- Insira a referência do imóvel que pretende marcar como favorito");
                        String ref = input.next();
                        Comprador.setFavorito(ref);
                        break;
                    }
            }
            catch (ImovelInexistenteException e) {
                System.out.println(e.getMensagem());
                clean = false;
            }
            catch (SemAutorizacaoException e) {
                System.out.println(e.getMensagem());
                clean = false;
            }
        }
    }
    
    private static void interpretadorV() {
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        boolean run = true, clean = true;
        while (run) {
            if (clean) limpaTerminal();
            System.out.println("\nSessão iniciada como vendedor\n");
            System.out.println("Bem-vindo(a) " + atualUser.getNome());
            menu_sessaoIniciadaV();
            try {
                comando = novoComandoInt();
                switch (comando) {
                    case 0: // sair
                        run = false;
                        break;
                    case 1: // registar imóvel
                        registoImovel();
                        clean = false;
                        break;
                }
            }
            catch (ImovelExisteException e) {
                System.out.println(e.getMensagem());
                clean = false;
            }
            catch (SemAutorizacaoException e) {
                System.out.println(e.getMensagem());
                clean = false;
            }
        }
    }
}