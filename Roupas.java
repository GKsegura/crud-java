public class Roupas implements Comparable<Roupas> {
    private int id_roupa;
    private String modelo;
    private String marca;
    private String tamanho;
    private double preco;

    public int compareTo(Roupas outro) {
        return this.getModelo().compareTo(outro.getModelo());
    }

    Roupas() {
        setId(0);
        setModelo("");
        setMarca("");
        setTamanho("");
        setPreco(0.00);
    }

    public void setId(int i) {
        this.id_roupa = i;
    }

    public void setModelo(String m) {
        this.modelo = m;
    }

    public void setMarca(String mr) {
        this.marca = mr;
    }

    public void setTamanho(String t) {
        this.tamanho = t;
    }

    public void setPreco(double p) {
        this.preco = p;
    }

    public int getId() {
        return id_roupa;
    }

    public String getModelo() {
        return this.modelo;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getTamanho() {
        return this.tamanho;
    }

    public double getPreco() {
        return this.preco;
    }

    public void ToString() {
        System.out.println("ID: " + getId());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Marca: " + getMarca());
        System.out.println("Tamanho: " + getTamanho());
        System.out.println("Preço: " + getPreco());
    }

    public void emLinha() {
        System.out.print(getId() + "\t");
        System.out.print(getModelo() + "\t");
        System.out.print(getMarca() + "\t");
        System.out.print(getTamanho() + "\t");
        System.out.print(getPreco() + "\t");
    }
}// Class