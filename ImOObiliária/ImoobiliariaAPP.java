import java.lang.String;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.List;
import java.util.Set;
import java.util.Scanner;

import Exceptions.*;

public class ImoobiliariaAPP {
    // variáveis de instância
    private static Imoobiliaria atual; 
    private static Utilizador atualUser;
    private static boolean online;
    private static int comando;
    
    /**
     * Não interessa o construtor de ImoobiliariaAPP
     */
    private ImoobiliariaAPP() {}
    
    /**
     * Função responsável por fazer correr o programa
     */
    public static void main(String[] args) {
        online = false;
        atual = initApp();
        runApp();
        saida();
    }
    
    /**
     * Método de aceder ao utilizador atual
     */
    public static Utilizador getAtualUser() {
        return atualUser;
    }
    /**
     * Método que permite saber se o utilizador atual ainda está online
     */
    public static boolean estaOnline() {
        return online;
    }
    
    /**
     * Método que permite saber se o atual utilizador tem permissões de um dado tipo ("Vendedor" ou "Comprador")
     */
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
            Vendedor admin = new Vendedor("admin", "admin@email.com", "123", "n/a", "n/a");
            nova.registarUtilizador(admin);
            atualUser = admin;
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
            Moradia m1 = new Moradia("Avenida da Quinta dos Outeiros", 100000, 90000, "Banda", 300, 200, 100, 3, 4, 15);
            nova.registarImovel(m1);
            Moradia m2 = new Moradia("Rua da Igreja", 10000, 9500, "Isolada", 300, 200, 100, 3, 4, 11);
            nova.registarImovel(m2);
            Apartamento a1 = new Apartamento("Rua Nova de Santa Cruz", 50000, 45000, "Simples", 200, 17, "2E", 2, 1, true);
            nova.registarImovel(a1);
            Apartamento a2 = new Apartamento("Rua dos Batatas", 57000, 55000, "Duplex", 300, 18, "4D", 4, 3, true);
            nova.registarImovel(a2);
            Loja l1 = new Loja("Rua dos Vasos", 15000, 14000, true, 45, 450, "Restauração");
            nova.registarImovel(l1);
            Loja l2 = new Loja("Rua das Bananas", 25000, 23000, false, 69, 350, "Lavandaria");
            nova.registarImovel(l2);
            LojaHabitavel lh1 = new LojaHabitavel("Rua Nova de Santa Cruz", 25000, 23000, false, 69, 350, "Lavandaria", a1);
            nova.registarImovel(lh1);
            Terreno t1 = new Terreno("Rua dos Mecos", 50000, 49000, "Armazéns", 150, 16, true, true, 2);
            nova.registarImovel(t1);
        }
        catch(UtilizadorExistenteException e) {
            System.out.println(e.getMensagem());
        }
        catch(ImovelExisteException e) {
            System.out.println(e.getMensagem());
        }
        catch(SemAutorizacaoException e) {
            System.out.println(e.getMensagem());
        }
        return nova;
    }
    
    /**
     * Funções de impressão de cabeçalhos e menus
     */
    private static void cabecalho() {
        System.out.println("  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("|                                                                            |");
        System.out.println("|                                IMOOBILIARIA                                |");
        System.out.println("|                                                                            |");
        System.out.println("  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
    }
    private static void saida() {
        limpaTerminal();
        System.out.println("  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println("|                                                                           |");
        System.out.println("| Ana Esmeralda Fernandes                                                   |");
        System.out.println("| Diogo Gonçalves Machado                                                   |");
        System.out.println("| Miguel Dias Miranda                                                       |");
        System.out.println("| Rui Filipe Leite                                                          |");
        System.out.println("|                                                                           |");
        System.out.println("|                              PROGRAMA ENCERRADO                           |");
        System.out.println("|                                                                           |");
        System.out.println("  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n");
    }
    private static void menu_principal() {
        System.out.println("(1) - Iniciar sessão");
        System.out.println("(2) - Fazer registo\n");
        System.out.println("(3) - Mais opções\n");
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
        System.out.println("(2) - Mais opções\n");
        System.out.println("(0) - Fechar sessão");
    }
    private static void menu_sessaoIniciadaV() {
        System.out.println("(1) - Registar imóvel");
        System.out.println("(2) - Listar 10 últimas consultas aos imóveis em venda");
        System.out.println("(3) - Mais opções\n");
        System.out.println("(0) - Fechar sessão");
    }
    
    /**
     * Função que verifica se um email é válido, sintaticamente
     */
    private static boolean emailValido(String email) {
        if (!email.contains("@") || !email.contains(".")) return false;
        return true;
    }
    
    /**
     * Função responsável por passar os parâmetros de inicio de sessão (verifica se o email é válido)
     */
    private static boolean autenticacaoIO() throws SemAutorizacaoException {
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
     * Função responsável por fechar a sessão do utilizador atual
     */
    public static void fechaSessao() {
        online = false;
    }
    
    /**
     * Função responsável por passar os parâmetros de registo de utilizador
     */
    private static void registoUserIO() throws UtilizadorExistenteException {
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
     * Função responsável por criar um novo comando inteiro
     */
    private static int novoComandoInt() {
        System.out.print("-- Insira o comando: ");
        Scanner input = new Scanner(System.in);
        return (input.nextInt());
    }
    
    private static void voltar() {
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        System.out.print("-- Insira 0 para voltar. ");
        if (input.nextInt() == 0) return;
    }
    
    /**
     * Função responsável por lançar o menu principal
     */
    private static void runApp() {
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        boolean run = true;
        while (run) {
            limpaTerminal();
            cabecalho();
            menu_principal();
            try {
                comando = novoComandoInt();
                switch (comando) {
                    case 0: // sair
                        run = false;
                        break;
                    case 1: // iniciar sessão
                        boolean result = autenticacaoIO();
                        while (!result) {
                            System.out.println("A autenticação falhou. Verifique se introduziu um email válido.\n Pretende tentar de novo?     S | N");
                            String d = input.next();
                            if (d.equals("S")) autenticacaoIO();
                            else break;
                        }
                        if (result) {
                            if (temAutorizacao("Comprador")) interpretadorC();
                            else interpretadorV();
                        }
                        break;
                    case 2: // registar um utilizador
                        registoUserIO();
                        break;
                    case 3: // mais oções
                        interpretadorConjunto();
                        break;
                }
            }
            catch(SemAutorizacaoException e) {
                System.out.println(e.getMensagem());
                voltar();
            }
            catch(UtilizadorExistenteException e) {
                System.out.println(e.getMensagem());
                voltar();
            }
            catch (ClassNotFoundException e) {
                e.getCause();
                voltar();
            }
        }
    }
    
    /**
     * Função responsável por lançar o menu conjunto
     */
    private static void interpretadorConjunto() throws ClassNotFoundException {
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        boolean run = true;
        while (run) {
            limpaTerminal();
            menu_conjunto();
            try {
                comando = novoComandoInt();
                switch (comando) {
                    case 0: // sair
                        run = false;
                        break;
                    case 1: // listar imóveis de um dado tipo e até um dado preço
                        getImovelIO();
                }
            }
            catch (ClassNotFoundException e) {
                e.getCause();
                voltar();
            }
        }
    }
    
    private static void getImovelIO() throws ClassNotFoundException {
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("-- Introduza o tipo de imóvel");
        System.out.println("    (1) Moradia  (2) Apartamento  (3) Loja  (4) Terreno");
        int opcao = input.nextInt();
        String tipoM = new String();
        switch (opcao) {
            case 1:
                tipoM = "Moradia";
                break;
            case 2:
                tipoM = "Apartamento";
                break;
            case 3:
                tipoM = "Loja";
                break;
            case 4:
                tipoM = "Terreno";
                break;
        }
        System.out.print("-- Introduza o preço: ");
        int preco = input.nextInt();
        List<Imovel> lista = atual.getImovel(tipoM, preco);
        if (lista.size() == 0) {
            System.out.println("Não existem imóveis com as especificações apresentadas");
            voltar();
        }
        else {
            for (int imprimidos = 0; imprimidos < lista.size(); imprimidos++) {
                Imovel i = lista.get(imprimidos);
                if (imprimidos < 5) {
                    System.out.println("  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
                    System.out.println(i.toString());
                    if (i.getEstado().equals("Em venda")) registarConsulta(i.getReferencia());
                }
                else {
                    System.out.println("-- Pretende ver mais resultados?   S | N");
                    String SorN = input.next();
                    if (SorN.equals("N")) break;
                }
            }
            System.out.println("  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
            System.out.println("Não existem mais imóveis para mostrar");
            voltar();
        }
    }
    
    private static void registarConsulta (String ref) {
        Imovel i = atual.getImovel(ref);
        i.incConsulta();
        Vendedor proprietario = (Vendedor)atual.getUtilizador(i.getProprietario());
        if (estaOnline()) proprietario.adicionaConsulta(atualUser.getEmail(), ref);
        else proprietario.adicionaConsulta(ref);
    }
    
    /**
     * Função responsável por lançar o menu dos clientes
     */
    private static void interpretadorC() throws ClassNotFoundException {
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        boolean run = true;
        Comprador atual = (Comprador)atualUser;
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
                        fechaSessao();
                        break;
                    case 1: // marcar imóvel como favorito
                        System.out.print("-- Insira a referência do imóvel que pretende marcar como favorito");
                        String ref = input.next();
                        atual.setFavorito(ref);
                        break;
                    case 2: // mais opções
                        interpretadorConjunto();
                        break;
                }
            }
            catch (ImovelInexistenteException e) {
                System.out.println(e.getMensagem());
                voltar();
            }
            catch (SemAutorizacaoException e) {
                System.out.println(e.getMensagem());
                voltar();
            }
        }
    }
    
    /**
     * Função responsável por lançar o menu dos vendedores
     */
    private static void interpretadorV() throws ClassNotFoundException {
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        boolean run = true;
        while (run) {
            limpaTerminal();
            System.out.println("\nSessão iniciada como vendedor\n");
            System.out.println("Bem-vindo(a) " + atualUser.getNome());
            menu_sessaoIniciadaV();
            try {
                comando = novoComandoInt();
                switch (comando) {
                    case 0: // sair
                        run = false;
                        fechaSessao();
                        break;
                    case 1: // registar imóvel
                        registoImovelIO();
                        voltar();
                        break;
                    case 2: // listar 10 consultas
                        getConsultasIO();
                        voltar();
                        break;
                    case 3: // mais opções
                        interpretadorConjunto();
                        break;
                }
            }
            catch (ImovelExisteException e) {
                System.out.println(e.getMensagem());
                voltar();
            }
            catch (SemAutorizacaoException e) {
                System.out.println(e.getMensagem());
                voltar();
            }
        }
    }
    
    public static void getConsultasIO() throws SemAutorizacaoException {
        if (!temAutorizacao("Vendedor")) throw new SemAutorizacaoException();
        else {
            Vendedor v = (Vendedor)atualUser;
            List<Consulta> lista = v.getConsultas();
            if (lista.size() == 0) {
                System.out.println("Não existem consultas registadas");
                return;
            }
            System.out.println("Últimas 10 consultas aos imóveis do Vendedor " + atualUser.getNome());
            System.out.println("Referência \t\t Data \t\t Email");
            int t = lista.size() - 11;
            if (t < 0) t = lista.size() - 1;
            for (; t > 0; t--) System.out.println(lista.get(t).toString());
        }
    }
    
    /**
     * Função responsável por passar os parâmetros de registo de imóvel
     */
    private static void registoImovelIO() throws ImovelExisteException, SemAutorizacaoException {
        limpaTerminal();
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        Imovel novo = null;
        System.out.println("REGISTO DE IMÓVEL\n");
        System.out.println("-- Pretende registar que tipo de imóvel?");
        System.out.println("    (M) Moradia  (A) Apartamento  (L) Loja  (LA) - Loja Habitável  (T) Terreno");
        String tipo = input.next();
        System.out.print("-- Rua: ");
        String rua = input.next();
        System.out.print("-- Preço pedido: ");
        float precoPedido = input.nextFloat();
        System.out.print("-- Preço mínimo aceite: ");
        float precoMin = input.nextFloat();
        switch (tipo) {
            case "M":
                novo = registoMoradiaIO(rua, precoPedido, precoMin);
                break;
            case "A":
                novo = registoApartamentoIO(rua, precoPedido, precoMin);
                break;
            case "L":
                novo = registoLojaIO(rua, precoPedido, precoMin);
                break;
            case "LA":
                novo = registoLojaHabitavelIO(rua, precoPedido, precoMin);
                break;
            case "T":
                novo = registoTerrenoIO(rua, precoPedido, precoMin);
                break;
        }
        atual.registarImovel(novo);
    }
    
    /**
     * Função responsável por criar uma Moradia
     */
    private static Moradia registoMoradiaIO(String rua, float precoPedido, float precoMin) {
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("-- Qual o tipo de moradia que pretende registar?");
        System.out.println("    (1) Isolada  (2) Geminada  (3) Banda  (4) Gaveto");
        int opcao = input.nextInt();
        String tipoM = new String();
        switch (opcao) {
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
        return new Moradia(rua, precoPedido, precoMin, tipoM, areaImp, areaTCober, areaTEnvol, nQuartos, nWCs, nPorta);
    }
    /**
     * Função responsável por criar um Apartamento
     */
    private static Apartamento registoApartamentoIO(String rua, float precoPedido, float precoMin) {
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
        System.out.print("-- Andar: ");
        String nAndar = input.next();
        System.out.print("-- Possui garagem?  S | N: ");
        String SorN = input.next();
        boolean temGar = SorN.equals("S");
        return new Apartamento(rua, precoPedido, precoMin, tipoM, areaT, nPorta, nAndar, nQuartos, nWCs, temGar);
    }
    /**
     * Função responsável por criar uma Loja
     */
    private static Loja registoLojaIO(String rua, float precoPedido, float precoMin) {
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
        return new Loja(rua, precoPedido, precoMin, temWC, nPorta, areaT, tipoN); 
    }
    /**
     * Função responsável por criar uma Loja Habitável
     */
    private static LojaHabitavel registoLojaHabitavelIO(String rua, float precoPedido, float precoMin) {
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
        Apartamento aux = null;
        System.out.println("Insira informações do apartamento\n");
        aux = registoApartamentoIO(rua, precoPedido, precoMin);
        return new LojaHabitavel(rua, precoPedido, precoMin, temWC, nPorta, areaT, tipoN, aux); 
    }
    /**
     * Função responsável por criar um Terreno
     */
    private static Terreno registoTerrenoIO(String rua, float precoPedido, float precoMin) {
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
        System.out.print("-- Lote:");
        int lote = input.nextInt();
        return new Terreno(rua, precoPedido, precoMin, prop, diam, kWh, temRedeE, temRedeEsg, lote);
    }
    
    /**
     * Função responsável por limpar o terminal
     */
    public static void limpaTerminal() {
        for (int i = 0; i < 20; i++) System.out.println("");
    }
}