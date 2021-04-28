package com.practise.signup.SignUpRepository;

import com.practise.signup.model.Inventory;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<Inventory, Long>, JpaSpecificationExecutor<Inventory> {

}
