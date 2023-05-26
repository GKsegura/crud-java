import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.ArrayList;

public class Crud {
    public static String opcao;
    public static Scanner teclado;
    public static ArrayList<Roupas> listaligada;

    public static String xid, xmodelo, xmarca, xtamanho, xpreco;
    public static int id_roupa;
    public static double preco;

    public static String Digitar(String txt) {
        System.out.print(txt);
        opcao = teclado.nextLine();
        return opcao;
    }

    public static void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void mensagem(String txt) {
        System.out.print(txt);
        teclado.nextLine();
    }

    public static void Erro(String txt) {
        System.out.print(txt);
        teclado.nextLine();
    }

    public static void Erro(Exception ex) {
        System.out.print(ex);
        teclado.nextLine();
    }

    public static void main(String[] args) {
        listaligada = new ArrayList<Roupas>();
        teclado = new Scanner(System.in);
        Lertxt();
        while (true) {
            cls();
            System.out.println("==========================================");
            System.out.println(" Roupas - Create / Read / Update / Delete");
            System.out.println("==========================================");
            System.out.println("Quantidade de roupas cadastradas: " + listaligada.size());
            System.out.println("<1> Adicionar roupas");
            System.out.println("<2> Alterar roupas");
            System.out.println("<3> Excluir roupas");
            System.out.println("<4> Listar roupas");
            System.out.println("<5> Listar roupas em linha");
            System.out.println("<6> Gravar arquivo txt");
            System.out.println("<7> Ler arquivo txt");
            System.out.println("<8> Sair");
            opcao = Digitar("Qual opção(1-8): ");

            try {
                int op = Integer.parseInt(opcao);

                switch (op) {
                    case 1:
                        Incluir();
                        break;
                    case 2:
                        Alterar();
                        break;
                    case 3:
                        Excluir();
                        break;
                    case 4:
                        Listar();
                        break;
                    case 5:
                        ListarEmLinha();
                        mensagem("Pressione <enter>...");
                        break;
                    case 6:
                        Gravartxt();
                        break;
                    case 7:
                        Lertxt();
                        break;
                    case 8:
                        System.exit(0);
                    default:
                        Erro("Valor inválido! Pressione qualquer tecla...");
                }

            } catch (Exception ex) {
                Erro(ex);
            }
        }
    }// main

    public static int CriaID() {
        if (listaligada.isEmpty())
            return 1;
        int tam = listaligada.size();
        int ult = tam - 1;
        Roupas r = new Roupas();
        r = (Roupas) listaligada.get(ult);
        return r.getId() + 1;
    }

    public static void Incluir() {
        cls();
        System.out.println("==Incluir roupa==");
        System.out.println("Novo registro - ID = " + CriaID());
        xmodelo = Digitar("Modelo da roupa: ");
        xmarca = Digitar("Marca da roupa: ");
        xtamanho = Digitar("Tamanho da roupa: ");
        xpreco = Digitar("Preço da roupa: ");
        System.out.println("==Dados digitados==");
        System.out.println("Modelo: " + xmodelo);
        System.out.println("Marca: " + xmarca);
        System.out.println("Tamanho: " + xtamanho);
        System.out.println("Preço: " + xpreco);

        opcao = Digitar("Confima dados digitados(S/N)? ");
        if (opcao.toUpperCase().equals("S")) {
            Roupas r = new Roupas();
            r.setId(CriaID());
            r.setModelo(xmodelo);
            r.setMarca(xmarca);
            r.setTamanho(xtamanho);
            try {
                preco = Double.parseDouble(xpreco);
            } catch (Exception ex) {
                Erro(ex);
            }
            r.setPreco(preco);
            listaligada.add(r);
            Gravartxt();
            mensagem("Cadastrado com sucesso!");
        } else {
            mensagem("Cadastro cancelado!");
        }
    }

    public static void Alterar() {
        cls();
        System.out.println("==Alterar roupa==");
        ListarEmLinha();
        int ultimo = listaligada.size() - 1;
        opcao = Digitar("\nQual regitro deseja alterar? (0-" + ultimo + ")?");
        try {
            int registro = Integer.parseInt(opcao);
            if (registro >= 0 && registro <= ultimo) {
                AlterandoDados(registro);
                Gravartxt();
                mensagem("Alterado com sucesso!");
            } else
                throw new Exception();
        } catch (Exception ex) {
            System.out.println("Registro não encontrado!");
        }
    }

    public static void AlterandoDados(int pos) {
        Roupas r = (Roupas) listaligada.get(pos);
        cls();
        System.out.println("==Alterarando de roupa==");
        System.out.println("Registro:... " + pos);
        System.out.println("ID:......... " + r.getId());
        System.out.println("<1> Modelo:. " + r.getModelo());
        System.out.println("<2> Marca:.. " + r.getMarca());
        System.out.println("<3> Tamanho: " + r.getTamanho());
        System.out.println("<4> Preço:.. " + r.getPreco());
        System.out.println("<5> Fim opcoes");
        opcao = Digitar("Qual opção(1-5): ");
        try {
            int op = Integer.parseInt(opcao);
            switch (op) {
                case 1:
                    r.setModelo(Digitar("Digite o novo modelo: "));
                    break;
                case 2:
                    r.setMarca(Digitar("Digite a nova marca: "));
                    break;
                case 3:
                    r.setTamanho("Digite o novo tamanho: ");
                    break;
                case 4:
                    xpreco = Digitar("Digite o novo preco: ");
                    try {
                        preco = Double.parseDouble(xpreco);
                    } catch (Exception ex) {
                        mensagem("Preco inválido!");
                    }
                    break;
                case 5:
                    return;
                default:
                    Erro("Valor inválido! Pressione qualquer tecla...");
            }
        } catch (Exception ex) {
            Erro(ex);
        }
    }

    public static void Excluir() {
        cls();
        System.out.println("==Excluir roupa==");
        ListarEmLinha();
        int ultimo = listaligada.size() - 1;
        opcao = Digitar("\nQual regitro deseja excluir? (0-" + ultimo + ")?");
        try {
            int registro = Integer.parseInt(opcao);
            if (registro >= 0 && registro <= ultimo) {
                listaligada.remove(registro);
                mensagem("O registro " + registro + "foi excluido com sucesso!");
                Gravartxt();
                return;
            } else
                throw new Exception();
        } catch (Exception ex) {
            System.out.println("Registro não encontrado!");
        }
    }

    public static void Listar() {
        cls();
        if (listaligada.isEmpty()) {
            mensagem("Lista vazia!");
            return;
        }
        System.out.println("===============");

        for (int i = 0; i < listaligada.size(); i++) {
            Roupas r = new Roupas();
            r = (Roupas) listaligada.get(i);
            System.out.println("Registro: " + i);
            r.ToString();
            System.out.println("===============");
        }
        mensagem("Tecle <enter>...");
    }

    public static void ListarEmLinha() {
        if (listaligada.isEmpty()) {
            mensagem("Lista vazia!");
            return;
        }

        System.out.println("Registro\tId\tModelo\tMarca\tTamanho\tPreco");
        for (int i = 0; i < listaligada.size(); i++) {
            Roupas r = new Roupas();
            r = (Roupas) listaligada.get(i);
            System.out.print("\n" + i + "\t\t");
            r.emLinha();
        }
    }

    public static void Gravartxt() {
        try {
            if (listaligada.isEmpty()) {
                mensagem("A lista está vazia!");
                return;
            }
            Roupas r = new Roupas();
            Formatter arquivo = new Formatter("Roupas.txt");
            for (int i = 0; i < listaligada.size(); i++) {
                r = (Roupas) listaligada.get(i);
                xid = "" + r.getId();
                xmodelo = r.getModelo();
                xmarca = r.getMarca();
                xtamanho = r.getTamanho();
                xpreco = "" + r.getPreco();
                arquivo.format("%s,%s,%s,%s,%s\n",
                        xid, xmodelo, xmarca, xtamanho, xpreco);
            } // for
            arquivo.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro na gravacao: " + e);
        }
    }

    public static void Lertxt() {
        try {
            File arquivo = new File("Rodas.txt");
            if (!arquivo.exists()) {
                System.out.println("Arquivo nao existe!");
                teclado.close();
                return;
            }
            Scanner sc = new Scanner(arquivo);
            sc.useDelimiter("\\s*,\\s*");
            while (sc.hasNext()) {
                xid = sc.next();
                xmodelo = sc.next();
                xmarca = sc.next();
                xtamanho = sc.next();
                xpreco = sc.next();
                Roupas r = new Roupas();
                r.setId(Integer.parseInt(xid));
                r.setModelo(xmodelo);
                r.setMarca(xmarca);
                r.setTamanho(xtamanho);
                try {
                    preco = Double.parseDouble(xpreco);
                } catch (Exception ex) {
                    Erro(ex);
                }
                r.setPreco(preco);
                listaligada.add(r);
                System.out.println("lendo=" + sc.next());
                teclado.nextLine();
            } /// while
            sc.close();
        } catch (FileNotFoundException e) {
            mensagem("Erro na leitura: " + e);
        }
        teclado.close();
    }
}
