package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("=====");
        System.out.printf("Error activity:    %b%s", active, System.lineSeparator());
        System.out.printf("Error status: %8d%s", status, System.lineSeparator());
        System.out.printf("Error description: %s%s", message, System.lineSeparator());
        System.out.println("=====");
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error error416 = new Error(false, 416, "Range Not Satisfiable");
        Error error404 = new Error(true, 404, "Not Found");
        error.printInfo();
        error404.printInfo();
        error416.printInfo();

    }

}
