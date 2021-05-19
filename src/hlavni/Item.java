package hlavni;

public class Item {

	private String nazev, popis;
	private ItemType typ;
	private int hodnota;

	public Item(String nazev, String popis, ItemType typ, int hodnota) {
		super();
		this.nazev = nazev;
		this.popis = popis;
		this.typ = typ;
		this.hodnota=hodnota;
	}

	@Override
	public String toString() {
		return "nazev "+nazev + ", popis: " + popis + ", hodnota "+ hodnota;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nazev == null) ? 0 : nazev.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (nazev == null) {
			if (other.nazev != null)
				return false;
		} else if (!nazev.equals(other.nazev))
			return false;
		return true;
	}

	public ItemType getTyp() {
		return typ;
	}

	public void setTyp(ItemType typ) {
		this.typ = typ;
	}

	public String getNazev() {
		return nazev;
	}

	public void setNazev(String nazev) {
		this.nazev = nazev;
	}

	public String getPopis() {
		return popis;
	}

	public void setPopis(String popis) {
		this.popis = popis;
	}

	public int getHodnota() {
		return hodnota;
	}

	public void setHodnota(int hodnota) {
		this.hodnota = hodnota;
	}
	
	
	
	
}
