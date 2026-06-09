package com.pluralsight.sneakerdrops;

import com.pluralsight.sneakerdrops.service.DropService;
import com.pluralsight.sneakerdrops.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {
    private final DropService dropService;
    private final InventoryService inventoryService;

    @Autowired
    public StartupRunner(DropService dropService, InventoryService inventoryService) {
        this.dropService = dropService;
        this.inventoryService = inventoryService;
    }

    @Override
    public void run(String... args) {
        System.out.println(dropService.getStatus());
        System.out.println(inventoryService.getStatus());
    }
}
