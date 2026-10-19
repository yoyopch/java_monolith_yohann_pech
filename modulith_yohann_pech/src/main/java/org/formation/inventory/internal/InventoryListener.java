package org.formation.inventory.internal;

import org.formation.catalog.CoffeeCreated;
import org.formation.catalog.internal.CoffeeRepository;
import org.springframework.modulith.ApplicationModule;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Component
class InventoryListener {
    private final StockRepository repository;

    InventoryListener(StockRepository repository){
        this.repository = repository;
    }

    @ApplicationModuleListener
    void onn(CoffeeCreated event){
        repository.save(new StockEntity(event.coffeeId(), 0));
    }
}
