package com.company.util;

import com.company.model.Laptop;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class LaptopGenerator {
    private final Random random = new Random();

    public Laptop getLaptop(){
        Laptop laptop = new Laptop();
        laptop.setModel(getModel());
        laptop.setBrand(getBrand());
        laptop.setProcessor(getProcessor());
        laptop.setRam(getRAM());
        laptop.setSecondaryMarket(isUsed());
        laptop.setCaseType(getCase());
        laptop.setPrice(getPrice());
        laptop.setDate(getReleaseDate());

        return laptop;
    }

    private String getModel(){
        String[] laptopModels = {
                "ROG Strix G15 G512LI-HN094",
                "ZenBook 14 UM431DA-AM005",
                "Nitro 5 AN515-55-56WH",
                "Aspire 5 A515-55G",
                "Envy Laptop 15-ep0004ur",
                "Laptop 15s-eq1003ua",
                "IdeaPad L320",
                "IdeaPad L340",
                "Latitude 3400",
                "Inspiron G5 5500"
        };

        return laptopModels[random.nextInt(laptopModels.length)];
    }

    private String getBrand(){
        String[] laptopBrand = {
                "Asus",
                "Acer",
                "HP",
                "Lenovo",
                "Dell"
        };

        return laptopBrand[random.nextInt(laptopBrand.length)];
    }

    private String getProcessor(){
        String[] laptopCPU = {
                "Intel® Core™ i5",
                "Intel® Core™ i7",
                "AMD Ryzen 5"
        };

        return laptopCPU[random.nextInt(laptopCPU.length)];
    }

    private int getRAM(){
        int[] laptopRAM = {16, 32, 64, 128, 256};

        return laptopRAM[random.nextInt(laptopRAM.length)];
    }

    private boolean isUsed(){
        return random.nextBoolean();
    }

    private String getCase(){
        String[] laptopCase = {"Metal", "Plastic"};

        return laptopCase[random.nextInt(laptopCase.length)];
    }

    private float getPrice(){
        return (float) random.nextInt(25_000) + 15_000;
    }

    private LocalDate getReleaseDate(){
        long minDay = LocalDate.of(2016, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2020, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);

        return LocalDate.ofEpochDay(randomDay);
    }
}
