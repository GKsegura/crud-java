import java.util.Scanner;
import java.util.ArrayList;

public class Crud {
    public static String opcao;
    public static Scanner teclado;
    public static ArrayList<Roupas> listaligada;

    public static String xmodelo, xmarca, xtamanho, xpreco;
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
        while (true) {
            cls();
            System.out.println("==========================================");
            System.out.println(" Roupas - Create / Read / Update / Delete");
            System.out.println("==========================================");
            System.out.println("<1> Adicionar roupas");
            System.out.println("<2> Alterar roupas");
            System.out.println("<3> Excluir roupas");
            System.out.println("<4> Listar roupas");
            System.out.println("<5> Gravar arquivo.txt");
            System.out.println("<6> Ler arquivo.txt");
            System.out.println("<7> Fim opcoes");
            opcao = Digitar("Qual opção(1-7): ");

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
                        Gravartxt();
                        break;
                    case 6:
                        Lertxt();
                        break;
                    case 7:
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
                preco = 1.00;
                Erro(ex);
            }
            r.setPreco(preco);
            listaligada.add(r);
            mensagem("Cadastrado com sucesso");
        } else {
            mensagem("Cadastro cancelado");
        }
    }

    public static void Alterar() {
        cls();
        System.out.println("==Alterar roupa==");
        id_roupa = Integer.parseInt(Digitar("ID da roupa: "));
        int pos = -1;
        for (int i = 0; i < listaligada.size(); i++) {
            Roupas r = new Roupas();
            r = (Roupas) listaligada.get(i);
            if (r.getId() == id_roupa) {
                pos = i;
                break;
            }
        }
        if (pos == -1) {
            mensagem("ID não encontrado!");
            return;
        }
        Roupas r = new Roupas();
        r = (Roupas) listaligada.get(pos);
        System.out.println("==Dados atuais==");
        r.ToString();
        System.out.println("==Novos dados==");
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
            r.setModelo(xmodelo);
            r.setMarca(xmarca);
            r.setTamanho(xtamanho);
            try {
                preco = Double.parseDouble(xpreco);
            } catch (Exception ex) {
                preco = 1.00;
                Erro(ex);
            }
            r.setPreco(preco);
            listaligada.set(pos, r);
            mensagem("Alterado com sucesso");
        } else {
            mensagem("Alteração cancelada");
        }
    }

    public static void Excluir() {
        cls();
        System.out.println("==Excluir roupa==");
        id_roupa = Integer.parseInt(Digitar("ID da roupa: "));
        int pos = -1;
        for (int i = 0; i < listaligada.size(); i++) {
            Roupas r = new Roupas();
            r = (Roupas) listaligada.get(i);
            if (r.getId() == id_roupa) {
                pos = i;
                break;
            }
        }
        if (pos == -1) {
            mensagem("ID não encontrado!");
            return;
        }
        Roupas r = new Roupas();
        r = (Roupas) listaligada.get(pos);
        System.out.println("==Dados atuais==");
        r.ToString();

        opcao = Digitar("Confima exclusão(S/N)? ");
        if (opcao.toUpperCase().equals("S")) {
            listaligada.remove(pos);
            mensagem("Excluído com sucesso");
        } else {
            mensagem("Exclusão cancelada");
        }
    }

    public static void Listar() {
        if (listaligada.isEmpty()) {
            mensagem("Lista vazia!");
            return;
        }

        System.out.println("===============");

        for (int i = 0; i < listaligada.size(); i++) {
            listaligada.get(i).ToString();
            System.out.println("===============");
        }

        /*
         * for(int i = 0 ; i < listaligada.size() ; i++)
         * {
         * Roupas r = new Roupas();
         * r = (Roupas)listaligada.get(i);
         * System.out.println("Registro: " +i);
         * r.ToString();
         * }
         */

        mensagem("Tecle <enter>");
    }

    public static void Gravartxt() {
    }

    public static void Lertxt() {
    }
}
