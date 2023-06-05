import java.util.Comparator;

public class TamanhoComparator implements Comparator<Roupas> {
    public int compare(Roupas r1, Roupas r2) {
        return r1.getTamanho().compareTo(r2.getTamanho());
    }
}
