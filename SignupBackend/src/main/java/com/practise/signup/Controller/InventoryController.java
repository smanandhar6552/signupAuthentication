package com.practise.signup.Controller;

import com.practise.signup.Service.InventoryService;
import com.practise.signup.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/product")
    public void addProduct(@RequestBody Inventory inventory){
        inventoryService.addProduct(inventory);
    }

    @GetMapping("/products")
    public List<Inventory> getallrecords(){
        return inventoryService.getrecords();
    }

    @PutMapping("/product/{id}")
    public void getrecordById(@RequestBody Inventory inventory, @PathVariable("id") Long id){
        inventoryService.addById(inventory, id);

    }
    @DeleteMapping("/product/{id}")
    public void deleteById(@PathVariable("id") Long id){
        inventoryService.deleteData(id);
    }
    @GetMapping("product/{id}")
        public Inventory recordById(@PathVariable("id") Long id){
            return inventoryService.recordById(id);
        }

}
