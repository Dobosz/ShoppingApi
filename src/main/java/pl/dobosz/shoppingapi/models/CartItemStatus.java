package pl.dobosz.shoppingapi.models;

/**
 * Created by dobosz on 2/1/16.
 */
public class CartItemStatus {
  private long id;

  public CartItemStatus(long id) {
    this.id = id;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
