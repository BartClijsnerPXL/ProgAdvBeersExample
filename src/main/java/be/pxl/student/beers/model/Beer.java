package be.pxl.student.beers.model;

import java.io.Serializable;

public class Beer implements Serializable {

	int id;
	String name;
	float price;

	public Beer(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Beer{" +
				"id=" + id +
				", name='" + name + '\'' +
				", price=" + price +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Beer beer = (Beer) o;

		if (getId() != beer.getId()) return false;
		if (Float.compare(beer.getPrice(), getPrice()) != 0) return false;
		return getName() != null ? getName().equals(beer.getName()) : beer.getName() == null;
	}

	@Override
	public int hashCode() {
		int result = getId();
		result = 31 * result + (getName() != null ? getName().hashCode() : 0);
		result = 31 * result + (getPrice() != +0.0f ? Float.floatToIntBits(getPrice()) : 0);
		return result;
	}
}
