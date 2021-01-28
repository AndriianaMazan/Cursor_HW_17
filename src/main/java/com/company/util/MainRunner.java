package com.company.util;

import com.company.model.Laptop;
import com.company.repository.LaptopRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainRunner implements CommandLineRunner {
    LaptopGenerator laptopGenerator;
    LaptopRepository laptopRepository;

    public MainRunner(LaptopGenerator laptopGenerator,
                      LaptopRepository laptopRepository) {
        this.laptopGenerator = laptopGenerator;
        this.laptopRepository = laptopRepository;
    }

    @Override
    public void run(String... args) {
        Laptop laptop;

        System.out.println("Generating laptops values...");
        for (int i = 0; i < 20; i++) {
            laptop = laptopGenerator.getLaptop();

            laptopRepository.save(laptop);
        }

        System.out.println("\nThese are all laptops: ");
        laptopRepository.findAll().forEach(System.out::println);

        System.out.println("\nThese are all laptops sorted by manufacturers: ");
        laptopRepository.findAllByOrderByBrandDesc().forEach(System.out::println);

        System.out.println("\nThese are all laptops with RAM > 16");
        laptopRepository.findAllByRamGreaterThan(16).forEach(System.out::println);

        System.out.println("\nThese are all used laptops: ");
        laptopRepository.findAllBySecondaryMarketIsTrue().forEach(System.out::println);

    }
}
