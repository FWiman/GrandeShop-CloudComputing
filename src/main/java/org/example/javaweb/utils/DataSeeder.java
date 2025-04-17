package org.example.javaweb.utils;

import com.github.javafaker.Faker;
import org.example.javaweb.model.Product;
import org.example.javaweb.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DataSeeder {
    @Autowired
    ProductRepository productRepository;

    Faker faker = new Faker();

    public void Seed() throws URISyntaxException {
        if(productRepository.count() > 0 ){
            return;
        }
        for(int i =0; i < 100; i++) {
            productRepository.save(RandomProduct());
        }
    }

    private Product RandomProduct() throws URISyntaxException {
        Product product = new Product();
        product.setName(faker.commerce().productName());
        product.setCategory(faker.commerce().department());
        product.setDescription(faker.lorem().sentence());
        product.setPrice(faker.number().numberBetween(3000,20000));
        product.setStock(faker.number().numberBetween(1,100));
        product.setImage("/images/dogs/" + getRandomImage());
        return product;
    }

    private String getRandomImage() throws URISyntaxException {
        //Get all files in dir
        URL resource = getClass().getClassLoader().getResource("static/images/dogs");
        Path dir = Paths.get(resource.toURI());

        Set<String> allFiles =  Stream.of(Objects.requireNonNull(new File(String.valueOf(dir)).listFiles()))
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());

        return getByRandomClass(allFiles);
    }

    public static <T> T getByRandomClass(Set<T> set) {
        if (set == null || set.isEmpty()) {
            throw new IllegalArgumentException("The Set cannot be empty.");
        }
        int randomIndex = new Random().nextInt(set.size());
        int i = 0;
        for (T element : set) {
            if (i == randomIndex) {
                return element;
            }
            i++;
        }
        throw new IllegalStateException("Something went wrong while picking a random element.");
    }
}
