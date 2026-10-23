package ci553.happyshop.catalogue;

public class OrganisedTrolley extends Trolley{

    @Override
    public void addProduct(Product product) {
        /**
         * alice TODO
         * organised version of addProduct
         * groupProductsById() type subroutine
         * from CustomerModel
         *
         * should work differently to groupProductsById() as adding products to ordered list not ordering full unordered list
         * products ArrayList was originally private - have made it protected so can access here
         */

        // loop through products, checking if i.productID matches product's productID
        for (int i = 0; i <= products.size(); i++) {
            if (i == products.size()) { // if just checked last product (or trolley is empty)
                products.add(product);
                break;  // product added, stop looping
            } else if (products.get(i).getProductId().equals(product.getProductId())) { // product already in trolley
                products.get(i).setOrderedQuantity(products.get(i).getOrderedQuantity() + 1);
                /**
                 * PROBLEM
                 * doubles quantity in trolley every time
                 * are the product being added and the product in the list pointing to the same object?
                 * using "orderedQuantity" to mean the amount being added to the order in the case of product being added
                 * and the amount already in the order in the case of product in list
                 * @see Product
                 * ^idk if thats the right use of javadoc or if its helpful
                 * but basically the definition in there is:
                 * "orderedQuantity: Quantity involved in a customer's order"
                 *
                 * the item in products() that matches the productID of product
                 * -> is just product itself
                 * -> they're the same object from the database
                 * -> they've just been passed into this method via different routes
                 * -> but the "orderedQuantity"s being used here are really just one value
                 *
                 * current fix: assume the quantity being added must be 1
                 * as only possible to be 1 for now as not implemented granular control of items part
                 * but when making it possible to choose to add multiples of one product to trolley in future
                 * will have to adjust fix then
                 *
                 * -> although tbf that seems like will involve changing "orderedQuantity" in some way anyway
                 * error here was trying to account for change in definition of variable that hasnt happened yet
                 * and only on one side
                */
                break;  // product added, stop looping
            } else if (Integer.parseInt(products.get(i).getProductId()) > Integer.parseInt(product.getProductId())) {
                // got to a product that comes after what we're trying to add - product not in list
                products.add(i, product);   // insert product before first instance of higher productID
                break;  // product added, stop looping
            }
        }
    }
}
