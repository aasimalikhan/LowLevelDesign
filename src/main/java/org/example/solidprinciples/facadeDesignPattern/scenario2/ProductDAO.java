package org.example.solidprinciples.facadeDesignPattern.scenario2;

public class ProductDAO {
    public Product getProduct(int productId)
    {
        return new Product();
    }
}
