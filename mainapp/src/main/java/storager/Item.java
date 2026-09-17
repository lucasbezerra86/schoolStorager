package storager;

public class Item {

  private String itemName;
  private int itemQt;

  public Item(String itemName, int itemQt) {
    this.itemName = itemName;
    this.itemQt = itemQt;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;

  }

  public int getItemQt() {
    return itemQt;
  }

  public void setItemQt(int itemQt) {
    this.itemQt = itemQt;

  }

}
