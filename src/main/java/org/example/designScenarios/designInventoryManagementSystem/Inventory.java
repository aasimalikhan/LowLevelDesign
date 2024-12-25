package org.example.designScenarios.designInventoryManagementSystem;

import java.util.*;
import java.util.stream.Collectors;

public class Inventory {
    private List<Product> products;

    public Inventory()
    {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product)
    {
        products.add(product);
    }
    public void removeProduct(Product product)
    {
        products.remove(product);
    }
    public void removeProduct(String id)
    {
        products = products.stream().filter(item -> Objects.equals(item.getId(), id)).toList();
    }

    public boolean isOrderFulfillable(Map<String, Integer> productCountMap)
    {
        boolean orderFulfillable = true;
        for(Map.Entry<String, Integer> entry : productCountMap.entrySet())
        {
            Optional<Product> product = products.stream().filter(item -> item.getId() == entry.getKey()).findFirst();
            if(!product.isPresent())
            {
                return false;
            }
            Integer quantityAvailable = product.get().getStock();
            if(entry.getValue() > quantityAvailable)
            {
                return false;
            }
        }
        return true;
    }

    public void fulfillOrder(Map<String, Integer> productCountMap) throws Exception {
        if(isOrderFulfillable(productCountMap))
        {
            for(Map.Entry<String, Integer> entry : productCountMap.entrySet())
            {
                Optional<Product> product = products.stream().filter(item -> Objects.equals(item.getId(), entry.getKey())).findFirst();
                if(product.isPresent())
                {
                    int currentStock = product.get().getStock();
                    product.get().setStock(currentStock - entry.getValue());
                }
            }
        }
        else
        {
            throw new Exception("Order cannot be fulfilled as some items aren't available");
        }
    }
}
