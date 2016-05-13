import java.lang.String;
import Exceptions.*;
import java.io.*;
import java.util.*;

public class ImoobiliariaAPP {
    // variáveis de instância
    private static Imoobiliaria atual;
    private static int comando;
    
    /**
     * Não interessa o construtor de ImoobiliariaAPP
     */
    private ImoobiliariaAPP() {}
    
    public static Imoobiliaria getAtual() {
        return atual;
    }
    
    /**
     * Função responsável por fazer correr o programa
     */
    public static void main(String[] args) {
        carregarDados();
        atual.setOnline(false);
        runApp();
        saida();
    }
    
     private static void carregarDados() {
        try {
            atual = Imoobiliaria.leObj("estado.tabemp");
        }
        catch (IOException e) {
            System.out.println("Não consegui ler os dados!\nErro de leitura.");
            atual = initApp();
        } 
        catch (ClassNotFoundException e) {
            System.out.println("Não consegui ler os dados!\nFicheiro com formato desconhecido.");
            atual = initApp();
        }
        catch (ClassCastException e) {
            System.out.println("Não consegui ler os dados!\nErro de formato."); 
            atual = initApp();
        }
    }
    
     /**
     * Função que insere utilizadores na aplicação
     */
    public static Imoobiliaria initApp() {
        Imoobiliaria nova = new Imoobiliaria();
        Vendedor admin = (Vendedor)nova.getAdmin();
        try {
            nova.registarUtilizador(admin);
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
            Moradia m1 = new Moradia(nova.getCount(), admin.getEmail(), "Avenida da Quinta dos Outeiros", 100000, 90000, "Banda", 300, 200, 100, 3, 4, 15);
            nova.registaImovel(m1);
            Moradia m2 = new Moradia(nova.getCount(), admin.getEmail(), "Rua da Igreja", 10000, 9500, "Isolada", 300, 200, 100, 3, 4, 11);
            nova.registaImovel(m2);
            Apartamento a1 = new Apartamento(nova.getCount(), admin.getEmail(), "Rua Nova de Santa Cruz", 50000, 45000, "Simples", 200, 17, "2E", 2, 1, true);
            nova.registaImovel(a1);
            Apartamento a2 = new Apartamento(nova.getCount(), admin.getEmail(), "Rua dos Batatas", 57000, 55000, "Duplex", 300, 18, "4D", 4, 3, true);
            nova.registaImovel(a2);
            Loja l1 = new Loja(nova.getCount(), admin.getEmail(), "Rua dos Vasos", 15000, 14000, true, 45, 450, "Restauração");
            nova.registaImovel(l1);
            Loja l2 = new Loja(nova.getCount(), admin.getEmail(), "Rua das Bananas", 25000, 23000, false, 69, 350, "Lavandaria");
            nova.registaImovel(l2);
            LojaHabitavel lh1 = new LojaHabitavel(nova.getCount(), admin.getEmail(), "Rua Nova de Santa Cruz", 25000, 23000, false, 69, 350, "Lavandaria", a1);
            nova.registaImovel(lh1);
            Terreno t1 = new Terreno(nova.getCount(), admin.getEmail(), "Rua dos Mecos", 50000, 49000, "Armazéns", 150, 16, true, true, 2);
            nova.registaImovel(t1);
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
    private static boolean iniciaSessaoIO() throws SemAutorizacaoException {
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        System.out.print("Email: ");
        String email = input.next();
        if (!emailValido(email)) return false;
        if (!atual.getUtilizadores().containsKey(email)) return false;
        System.out.print("Password: ");
        String password = input.next();
        atual.iniciaSessao(email, password);
        return true;
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
     * Função de impressão do menu principal
     */
    private static void menu_principal() {
        System.out.println("(1) - Iniciar sessão");
        System.out.println("(2) - Fazer registo\n");
        System.out.println("(3) - Mais opções\n");
        System.out.println("(4) - Guardar estado do programa");
        System.out.println("(0) - Sair\n");
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
                        boolean result = iniciaSessaoIO();
                        while (!result) {
                            System.out.println("A autenticação falhou. Verifique se introduziu um email válido.\n Pretende tentar de novo?     S | N");
                            String d = input.next();
                            if (d.equals("S")) result = iniciaSessaoIO();
                            else break;
                        }
                        if (result) {
                            if (atual.temAutorizacao("Comprador")) interpretadorC();
                            else interpretadorV();
                        }
                        break;
                    case 2: // registar um utilizador
                        registoUserIO();
                        break;
                    case 3: // mais oções
                        interpretadorConjunto();
                        break;
                    case 4: // guardar estado do programa
                        atual.gravaObj("estado.tabemp");
                        atual.log("log.txt", true);
                        voltar();
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
                System.out.println(e.getCause());
                voltar();
            }
            catch (InputMismatchException e) {
                System.out.println(e.getCause());
                voltar();
            }
            catch (EstadoInvalidoException e) {
                System.out.println(e.getMensagem());
                voltar();
            }
            catch (IOException e) {
                System.out.println("Não consegui gravar os dados!");
                voltar();
            }
            catch (LeilaoTerminadoException e) {
                System.out.println(e.getMensagem());
                voltar();
            }
        }
    }
    
    /**
     * Função de impressão do menu conjunto
     */
    private static void menu_conjunto() {
        System.out.println("(1) - Consultar imóveis de um dado tipo e até um preço");
        System.out.println("(2) - Consultar lista dos imóveis habitáveis, até um preço");
        System.out.println("(3) - Obter correspondência entre imóveis e vendedores");
        System.out.println("(0) - Sair\n");
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
                        voltar();
                        break;
                    case 2: // listar imóveis habitáveis ate um dado preço
                        getHabitaveisIO();
                        voltar();
                        break;
                    case 3: // apresentar mapeamento entre imóveis e vendedor
                        getMapeamentoImoveisIO();
                        voltar();
                        break;
                }
            }
            catch (ClassNotFoundException e) {
                e.getCause();
                voltar();
            }
            catch (InputMismatchException e) {
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
        if (lista.size() == 0)
            System.out.println("Não existem imóveis com as especificações apresentadas");
        else {
            int imprimidos = 0;
            for (int o = 0; o < lista.size(); o++) {
                Imovel i = lista.get(o);
                if (imprimidos < 5) {
                    System.out.println("  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
                    System.out.println(i.toString());
                    imprimidos++;
                }
                else {
                    System.out.println("-- Pretende ver mais resultados?   S | N");
                    String SorN = input.next();
                    if (SorN.equals("N")) break;
                    imprimidos = 0;
                    o--;
                }
            }
            System.out.println("  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
            System.out.println("Não existem mais imóveis para mostrar");
        }
    }
    
    public static void getHabitaveisIO() {
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        System.out.print("-- Introduza o preço máximo: ");
        int preco = input.nextInt();
        List<Habitavel> lista = atual.getHabitaveis(preco);
        if (lista.size() == 0)
            System.out.println("Não existem imóveis com as especificações apresentadas");
        else {
            int imprimidos = 0;
            for (int o = 0; o < lista.size(); o++) {
                Habitavel h = lista.get(o);
                Imovel i = (Imovel)h;
                if (imprimidos < 5) {
                    System.out.println("  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
                    System.out.println(i.toString());
                    imprimidos++;
                }
                else {
                    System.out.println("-- Pretende ver mais resultados?   S | N");
                    String SorN = input.next();
                    if (SorN.equals("N")) break;
                    imprimidos = 0;
                    o--;
                }
            }
            System.out.println("  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
            System.out.println("Não existem mais imóveis para mostrar");
        }
    }
    
    public static void getMapeamentoImoveisIO() {
        Map<Imovel, Vendedor> mapeamento = atual.getMapeamentoImoveis();
        if (mapeamento.size() == 0) System.out.println("Não existem imóveis para mostrar");
        else {
            System.out.println("Referência \tNome do vendedor \tEmail"); 
            for (Map.Entry<Imovel, Vendedor> i: mapeamento.entrySet()) {
                Imovel aux = i.getKey();
                Vendedor v = i.getValue();
                System.out.println(aux.getId() + "\t\t" + v.getNome() + "\t\t\t" + v.getEmail()); 
            }
        }
    }
    
    /**
     * Função de impressão do menu do comprador
     */
    private static void menu_sessaoIniciadaC() {
        System.out.println("(1) - Registar um imóvel como favorito");
        System.out.println("(2) - Consultar imóveis favoritos ordenados por preço");
        System.out.println("(3) - Participar num leilão");
        System.out.println("(4) - Mais opções\n");
        System.out.println("(0) - Fechar sessão");
    }
    
    /**
     * Função responsável por lançar o menu dos clientes
     */
    private static void interpretadorC() throws ClassNotFoundException, LeilaoTerminadoException {
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        boolean run = true;
        while (run) {
            limpaTerminal();
            System.out.println("\nSessão iniciada como comprador\n");
            System.out.println("Bem-vindo(a) " + atual.getUtilizador(atual.getAtualUser()).getNome());
            menu_sessaoIniciadaC();
            try {
                comando = novoComandoInt();
                switch (comando) {
                    case 0: //sair
                        run = false;
                        atual.fechaSessao();
                        break;
                    case 1: // marcar imóvel como favorito
                        System.out.print("-- Insira a referência do imóvel que pretende marcar como favorito: ");
                        String ref = input.next();
                        atual.setFavorito(ref);
                        break;
                    case 2: // consultar imóveis favoritos
                        getFavoritosIO();
                        voltar();
                        break;
                    case 3: // participar num leilão
                        participaLeilaoIO();
                        voltar();
                        break;
                    case 4: // mais opções
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
            catch (InputMismatchException e) {
                e.getCause();
                voltar();
            }
        }
    }
    
    public static void getFavoritosIO() throws SemAutorizacaoException {
        TreeSet<Imovel> favoritos = atual.getFavoritos();
        if (favoritos.size() == 0) System.out.println("Não existem imóveis para mostrar");
        else {
            System.out.println("Referência \tTipo do Imóvel \t\tPreço"); 
            for (Imovel i: favoritos) System.out.println(i.getId() + "\t\t" + i.getClass().getName() + "\t\t\t" + i.getPrecoPedido());
        }
    }
    
    public static void participaLeilaoIO() throws LeilaoTerminadoException {
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        Map<String, Leilao> leiloes = atual.getLeiloes();
        if (leiloes.size() == 0) {
            System.out.println("Não existem leilões!");
            return;
        }
        System.out.println("Existem os seguintes leilões:");
        System.out.println("Referência \t\t Duração");
        for(Map.Entry<String, Leilao> e: leiloes.entrySet())
            System.out.println(e.getValue().toString());
        System.out.print("-- Insira a referência do imóvel: ");
        String id = input.next();
        System.out.print("-- Insira o limite que pretende gastar: ");
        double limite = input.nextDouble();
        System.out.print("-- Insira o valor dos incrementos: ");
        double incrementos = input.nextDouble();
        System.out.print("-- Insira o intervalo de tempo entre incrementos (em seg): ");
        double minutos = input.nextDouble();
        atual.participaLeilao(id, limite, incrementos, minutos);
    }
    
    /**
     * Função de impressão do menu do vendedor
     */
     private static void menu_sessaoIniciadaV() {
        System.out.println("(1) - Registar imóvel");
        System.out.println("(2) - Listar 10 últimas consultas aos imóveis em venda");
        System.out.println("(3) - Alterar o estado de um imóvel");
        System.out.println("(4) - Apresentar os códigos dos seus imóveis com mais de N consultas");
        System.out.println("(5) - Criar leilão");
        System.out.println("(6) - Inicar leilao");
        System.out.println("(7) - Mais opções\n");
        System.out.println("(0) - Fechar sessão");
    }
    
    /**
     * Função responsável por lançar o menu dos vendedores
     */
    private static void interpretadorV() throws ClassNotFoundException, EstadoInvalidoException, LeilaoTerminadoException {
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        boolean run = true;
        while (run) {
            limpaTerminal();
            System.out.println("\nSessão iniciada como vendedor\n");
            System.out.println("Bem-vindo(a) " + atual.getUtilizador(atual.getAtualUser()).getNome());
            menu_sessaoIniciadaV();
            try {
                comando = novoComandoInt();
                switch (comando) {
                    case 0: // sair
                        run = false;
                        atual.fechaSessao();
                        break;
                    case 1: // registar imóvel
                        registoImovelIO();
                        voltar();
                        break;
                    case 2: // listar 10 consultas
                        getConsultasIO();
                        voltar();
                        break;
                    case 3: // alterar estado de um imóvel
                        setEstadoIO();
                        voltar();
                        break;
                    case 4: // apresentar imóveis com mais de N consultas
                        getTopImoveisIO();
                        voltar();
                        break;
                    case 5: // criar leilão
                        criaLeilaoIO();
                        voltar();
                        break;
                    case 6: // iniciar leilão
                        arrancaLeilaoIO();
                        voltar();
                        break;
                    case 7: // mais opções
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
            catch (InputMismatchException e) {
                e.getCause();
                voltar();
            }
            catch (ImovelInexistenteException e) {
                System.out.println(e.getMensagem());
                voltar();
            }
            catch (LeilaoTerminadoException e) {
                System.out.println(e.getMensagem());
                voltar();
            }
        }
    }
    
    public static void criaLeilaoIO() throws SemAutorizacaoException {
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        System.out.print("-- Insira a referência do imóvel que pretende leiloar: ");
        String idImovel = input.next();
        System.out.print("-- Insira o número de minutos em que o leilão estará aberto: ");
        int horas = input.nextInt();
        atual.adicionaLeilao(idImovel, horas);
    }
    
    public static void arrancaLeilaoIO() throws LeilaoTerminadoException {
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        System.out.print("-- Insira a referência do imóvel em leilão: ");
        String idImovel = input.next();
        atual.arrancaLeilaoAux(idImovel);
    }
    
    public static void getConsultasIO() throws SemAutorizacaoException {
        if (!atual.temAutorizacao("Vendedor")) throw new SemAutorizacaoException();
        List<Consulta> lista = atual.getConsultas();
        if (lista.size() == 0) {
            System.out.println("Não existem consultas registadas");
            return;
        }
        System.out.println("Últimas 10 consultas aos seus imóveis");
        System.out.println("Referência\t Data \t\t\t Email");
        int imprimidos = 0;
        for (Consulta c: lista) {
            if (imprimidos < 10) {
                System.out.println(c.toString());
                imprimidos++;
            }
            else break;
        }
    }

    public static void setEstadoIO() throws ImovelInexistenteException, SemAutorizacaoException, EstadoInvalidoException {
        if (!atual.temAutorizacao("Vendedor")) throw new SemAutorizacaoException();
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        System.out.print("--Insira a referência do imóvel de que pretende alterar o estado: ");
        String idImovel = input.next();
        Vendedor v = (Vendedor)atual.getUtilizador(atual.getAtualUser());
        if (!v.possuiImovel(idImovel)) throw new ImovelInexistenteException();
        System.out.print("--Insira o estado: ");
        String estado = input.next();
        if (!estadoValido(estado)) throw new EstadoInvalidoException();
        atual.setEstado(idImovel, estado);
        v.atualizaPortHist(idImovel, estado);
        System.out.println("Estado do(a) " + atual.getImovel(idImovel).getClass().getName() + " " + idImovel + " alterado para: " + estado);
    }
    
    public static boolean estadoValido(String estado) {
        return (estado.equals("Em venda") || estado.equals("Reservado") || estado.equals("Vendido"));
    }
    
    public static void getTopImoveisIO() {
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        System.out.print("--Introduza o valor mínimo de consultas: ");
        int n = input.nextInt();
        Set<String> colecao = atual.getTopImoveis(n);
        if (colecao.size() == 0) {
            System.out.println("Não existem dados com as especificações indicadas");
            return;
        }
        System.out.println("Referência \t\t Número de consultas");
        for (String s: colecao) {
            System.out.println(s + "\t\t\t\t" + atual.getNConsultas(s));
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
        atual.registaImovel(novo);
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
        return new Moradia(atual.getCount(), atual.getAtualUser(), rua, precoPedido, precoMin, tipoM, areaImp, areaTCober, areaTEnvol, nQuartos, nWCs, nPorta);
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
        return new Apartamento(atual.getCount(), atual.getAtualUser(), rua, precoPedido, precoMin, tipoM, areaT, nPorta, nAndar, nQuartos, nWCs, temGar);
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
        return new Loja(atual.getCount(), atual.getAtualUser(), rua, precoPedido, precoMin, temWC, nPorta, areaT, tipoN); 
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
        return new LojaHabitavel(atual.getCount(), atual.getAtualUser(), rua, precoPedido, precoMin, temWC, nPorta, areaT, tipoN, aux); 
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
        return new Terreno(atual.getCount(), atual.getAtualUser(), rua, precoPedido, precoMin, prop, diam, kWh, temRedeE, temRedeEsg, lote);
    }
    
    /**
     * Função responsável por limpar o terminal
     */
    public static void limpaTerminal() {
        for (int i = 0; i < 20; i++) System.out.println("");
    }
}