package org.learning.finalprojectlibrary.comparator;

import org.learning.finalprojectlibrary.model.Book;

import java.util.Comparator;

public class BookPurchaseComparator implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        //ritorna -1 se il primo è più piccolo del secondo
        //+1 se il primo è più grande del secondo
        //0 se sono uguali

        return Integer.compare(book1.getAmountPurchases(), book2.getAmountPurchases());
    }
}
