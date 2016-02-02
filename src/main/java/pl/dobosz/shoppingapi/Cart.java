package pl.dobosz.shoppingapi;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.googlecode.objectify.ObjectifyService;
import pl.dobosz.shoppingapi.models.CartItem;
import pl.dobosz.shoppingapi.models.CartItemStatus;
import com.google.api.server.spi.ServiceException;

import java.util.List;

@Api(
        name = "cart",
        version = "v1"
)
public class Cart {

  @ApiMethod(name = "itemSave", httpMethod = "POST")
  public CartItemStatus save(CartItem cartItem) {
    long id = ObjectifyService.ofy().save().entity(cartItem).now().getId();
    return new CartItemStatus(id);
  }

  @ApiMethod(name = "itemFetch", httpMethod = "GET")
  public List<CartItem> fetch() {
    return ObjectifyService.ofy().load().type(CartItem.class).list();
  }

  @ApiMethod(name = "itemDelete", httpMethod = "DELETE")
  public void delete(@Named("id")long id) throws ServiceException {
    CartItem cartItem = ObjectifyService.ofy().load().type(CartItem.class).id(id).now();
    if (cartItem != null)
      ObjectifyService.ofy().delete().entities(cartItem);
    else
      throw new ServiceException(404, "CartItem don't exist");
  }

  @ApiMethod(name = "itemMark", httpMethod = "POST")
  public void mark(@Named("id")long id, @Named("mark")boolean mark) throws ServiceException {
    CartItem cartItem = ObjectifyService.ofy().load().type(CartItem.class).id(id).now();
    if (cartItem != null) {
      cartItem.setMarked(mark);
      ObjectifyService.ofy().save().entity(cartItem).now();
    }
    else
      throw new ServiceException(404, "CartItem don't exist");
  }

}
