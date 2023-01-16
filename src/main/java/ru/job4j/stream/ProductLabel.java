package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(p -> (p.getStandard() - p.getActual()) > -1)
                .filter(p -> (p.getStandard() - p.getActual()) < 4)
                .map(product -> (new Label(product.getName(), product.getPrice() / 2)).toString())
                .collect(Collectors.toList());
    }
}
