package org.learning.finalprojectlibrary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "ClientPurchases")
public class ClientPurchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    @NotNull(message = "cant be null")
    @PastOrPresent
    private LocalDate date;
    @Column(nullable = false)
    @NotNull(message = "cant be null")
    private int amount;

    @ManyToOne
    private Book book;

    public BigDecimal getPrice() {
        BigDecimal result = book.getPrice().multiply(BigDecimal.valueOf(amount));
        return result;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    /*public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

     */
}

