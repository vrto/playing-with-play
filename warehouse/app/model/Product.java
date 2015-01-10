package model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import play.data.validation.Constraints;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Constraints.Required
    public String ean;

    @Constraints.Required
    public String name;

    public String description;

    private static List<Product> products;

    static {
        products = new ArrayList<>();
        products = new ArrayList<Product>();
        products.add(new Product("1111111111111", "Paperclips 1", "Paperclips description 1"));
        products.add(new Product("2222222222222", "Paperclips 2", "Paperclips description "));
        products.add(new Product("3333333333333", "Paperclips 3", "Paperclips description 3"));
        products.add(new Product("4444444444444", "Paperclips 4", "Paperclips description 4"));
        products.add(new Product("5555555555555", "Paperclips 5", "Paperclips description 5"));
    }

    @Override
    public String toString() {
        return String.format("%s - %s", ean, name);
    }

    public static List<Product> findAll() {
        return new ArrayList<>(products);
    }

    public static Optional<Product> findByEan(String ean) {
        return products.stream()
                .filter(p -> ean.toLowerCase().equals(p.ean.toLowerCase()))
                .findFirst();
    }

    public static List<Product> findByName(String term) {
        return products.stream()
                .filter(p -> p.name.toLowerCase().contains(term.toLowerCase()))
                .collect(toList());
    }

    public static boolean remove(Product product) {
        return products.remove(product);
    }

    public void save() {
        Optional<Product> product = findByEan(this.ean);
        if (product.isPresent()) {
            products.remove(product.get());
        }
        products.add(this);
    }
}
