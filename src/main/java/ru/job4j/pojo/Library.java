package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book book1 = new Book("Java: The Complete Reference", 1248);
        Book book2 = new Book("Clean code", 464);
        Book book3 = new Book("Grokking Algorithms", 256);
        Book book4 = new Book("Digital Design and Computer Architecture", 720);
        Book[] books = {book1, book2, book3, book4};
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " has " + books[i].getPage() + " pages.");
        }
        System.out.println();
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " has " + books[i].getPage() + " pages.");
        }
        System.out.println();
        for (Book book : books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + " has " + book.getPage() + " pages.");
            }
        }
    }
}
