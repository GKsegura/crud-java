import java.util.*;

public class precoCompara implements Comparator<Roupas> {
    public int compare(Roupas r1, Roupas r2) {
        Double preco1 = r1.getPreco();
        Double preco2 = r2.getPreco();
        return preco1.compareTo(preco2);
    }
}