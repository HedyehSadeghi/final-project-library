package org.learning.finalprojectlibrary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(nullable = false)
    private String name;
    @OneToMany(mappedBy = "supplier")
    private List<SupplierBookPurchase> supplierBookPurchaseList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SupplierBookPurchase> getSupplierBookPurchaseList() {
        return supplierBookPurchaseList;
    }

    public void setSupplierBookPurchaseList(List<SupplierBookPurchase> supplierBookPurchaseList) {
        this.supplierBookPurchaseList = supplierBookPurchaseList;
    }
}

