package com.bs.boot.webstore.services.Impl;

import com.bs.boot.webstore.domain.Cart;
import com.bs.boot.webstore.domain.ShoppingHistory;
import com.bs.boot.webstore.domain.User;
import com.bs.boot.webstore.repository.ShoppingHistoryRepository;
import com.bs.boot.webstore.services.ShoppingHistoryService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Blazej on 30.10.2018.
 */
@Service
public class ShoppingHistoryServiceImpl implements ShoppingHistoryService {

    private ShoppingHistoryRepository  shoppingHistoryRepository;

    @Autowired
    public ShoppingHistoryServiceImpl(ShoppingHistoryRepository shoppingHistoryRepository) {
        this.shoppingHistoryRepository = shoppingHistoryRepository;
    }

    @Override
    public Optional<ShoppingHistory> findById(Long id) {
        return shoppingHistoryRepository.findById(id);
    }

    @Override
    public Optional<ShoppingHistory> findByOwner(User owner) {
        return shoppingHistoryRepository.findByOwner(owner);
    }

    @Override
    public ShoppingHistory save(Cart cart) {

        ShoppingHistory shoppingHistory = new ShoppingHistory();
        String productsInfoJSON = new Gson().toJson(cart.getItems().stream().map(item -> item.getProduct()));
        String cartTotalCost = new Gson().toJson(cart.getTotalPrice());
        shoppingHistory.setShopping_details(productsInfoJSON + cartTotalCost);
        shoppingHistory.setOwner(cart.getUser());
        return shoppingHistoryRepository.save(shoppingHistory);
    }

    @Override
    public void deleteById(Long id) {
        shoppingHistoryRepository.deleteById(id);
    }
}
