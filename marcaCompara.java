import java.util.*;

class marcaCompara implements Comparator<Roupas> {
	public int compare(Roupas r1, Roupas r2) {
		return r1.getMarca().compareTo(r2.getMarca());
	}
}
