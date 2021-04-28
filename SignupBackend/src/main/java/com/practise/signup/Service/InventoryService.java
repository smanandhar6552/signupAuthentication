package com.practise.signup.Service;

import com.practise.signup.SignUpRepository.InventoryRepository;
import com.practise.signup.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    public void addProduct(Inventory inventory) {
        inventoryRepository.save(inventory);
    }

    public List<Inventory> getrecords() {
        return (List<Inventory>) inventoryRepository.findAll();
    }

    public void addById(Inventory inventory, Long id) {
        inventory.setId(Long.valueOf(id));
        inventoryRepository.save(inventory);
    }

    public void deleteData(Long id) {
        inventoryRepository.deleteById(id);
    }

    public Inventory recordById(Long id) {
        return (Inventory) inventoryRepository.findById(id).get();
    }
}
