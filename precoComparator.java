import java.util.*;

class precoComparator implements Comparator<Roupas> {
	public int compare(Roupas o1, Roupas o2) {
		Roupas r1 = (Roupas) o1;
		Roupas r2 = (Roupas) o2;
		if (r1.getPreco() == r2.getPreco())
			return 0;
		if (r1.getPreco() < r2.getPreco())
			return -1;
		return 1;
	}
}
