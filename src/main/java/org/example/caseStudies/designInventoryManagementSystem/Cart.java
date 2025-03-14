package org.example.caseStudies.designInventoryManagementSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Cart {
    private Map<String, Integer> productCountMap;

    public Cart()
    {
        productCountMap = new HashMap<>();
    }
    public void addItemToCart(Product product, Integer quantity)
    {
        productCountMap.put(product.getId(), quantity);
    }
    public void removeItemFromCart(Product product)
    {
        productCountMap.entrySet().removeIf(entry -> Objects.equals(entry.getKey(), product.getId()));
    }
    public void emptyCart()
    {
        productCountMap.clear();
    }
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Cart{");
        sb.append("productCountMap=");

        if (productCountMap.isEmpty()) {
            sb.append("Empty");
        } else {
            sb.append(productCountMap);
        }

        sb.append('}');
        return sb.toString();
    }
}
