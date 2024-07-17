/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Yumxpress.pojo;

import java.awt.Image;

/**
 *
 * @author AMAN JHA
 */
public class ProductPojo {

    @Override
    public String toString() {
        return "ProductPojo{" + "productId=" + productId + ", companyId=" + companyId + ", ProductName=" + ProductName + ", productPrice=" + productPrice + ", productImage=" + productImage + ", productImageType=" + productImageType + '}';
    }
    public ProductPojo(){
        
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public Image getProductImage() {
        return productImage;
    }

    public void setProductImage(Image productImage) {
        this.productImage = productImage;
    }

    public String getProductImageType() {
        return productImageType;
    }

    public void setProductImageType(String productImageType) {
        this.productImageType = productImageType;
    }

    public ProductPojo(String productId, String companyId, String ProductName, double productPrice, Image productImage, String productImageType) {
        this.productId = productId;
        this.companyId = companyId;
        this.ProductName = ProductName;
        this.productPrice = productPrice;
        this.productImage = productImage;
        this.productImageType = productImageType;
    }
    private String productId;
    private String companyId;
    private String ProductName;
    private double productPrice;
    private Image  productImage;
    private String productImageType;
    
}