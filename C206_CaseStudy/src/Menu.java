import java.util.ArrayList;

public class Menu {
	private String itemName;
	private String description;
	private double prices;

	public Menu(String itemName, String description, double prices) {
		super();
		this.itemName = itemName;
		this.description = description;
		this.prices = prices;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrices() {
		return prices;
	}

	public void setPrices(double prices) {
		this.prices = prices;
	}

}
