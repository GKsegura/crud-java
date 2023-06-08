import java.util.*;

class MarcaComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		Roupas r1 = (Roupas) o1;
		Roupas r2 = (Roupas) o2;
		return r1.getMarca().compareTo(r2.getMarca());
	}
}
