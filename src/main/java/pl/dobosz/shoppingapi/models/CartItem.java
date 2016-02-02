package pl.dobosz.shoppingapi.models;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import java.io.Serializable;

/**
 * Created by dobosz on 9/29/15.
 */
@Entity
public class CartItem implements Serializable{

    @Id
    private long id;
    private String name;
    private String description;
    private int quantity;
    private boolean marked;

    public CartItem() {
    }

    public CartItem(String name, String description, int quantity) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    public CartItem(String name, String description, int quantity, boolean marked) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.marked = marked;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }
}
