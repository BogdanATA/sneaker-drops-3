package com.pluralsight.sneakerdrops;

import com.pluralsight.sneakerdrops.data.BrandRepository;
import com.pluralsight.sneakerdrops.models.Brand;
import com.pluralsight.sneakerdrops.service.DropService;
import com.pluralsight.sneakerdrops.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {
    private final DropService dropService;
    private final InventoryService inventoryService;
    private final BrandRepository brandRepository;

    @Autowired
    public StartupRunner(DropService dropService, InventoryService inventoryService, BrandRepository brandRepository) {
        this.dropService = dropService;
        this.inventoryService = inventoryService;
        this.brandRepository = brandRepository;
    }

    @Override
    public void run(String... args) {
        seedData();

        for (Brand brand : brandRepository.findAll()) {
            System.out.println("Brand: " + brand.getId() + " - " + brand.getName());
        }
    }

    private void seedData() {
        if (brandRepository.count() == 0) {
            brandRepository.save(new Brand("Nike"));
            brandRepository.save(new Brand("Adidas"));
            brandRepository.save(new Brand("New Balance"));
            System.out.println("Brands seeded.");
        }
    }
}
