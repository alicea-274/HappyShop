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
                products.get(i).setOrderedQuantity(products.get(i).getOrderedQuantity() + product.getOrderedQuantity());
                break;  // product added, stop looping
            } else if (Integer.parseInt(products.get(i).getProductId()) > Integer.parseInt(product.getProductId())) {
                // got to a product that comes after what we're trying to add - product not in list
                products.add(i, product);   // insert product before first instance of higher productID
                break;  // product added, stop looping
            }
        }
    }
}
