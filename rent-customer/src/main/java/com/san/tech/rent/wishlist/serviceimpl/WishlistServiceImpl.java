package com.san.tech.rent.wishlist.serviceimpl;

import com.san.tech.rent.wishlist.entity.Wishlist;
import com.san.tech.rent.wishlist.repository.WishlistRepository;
import com.san.tech.rent.wishlist.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class WishlistServiceImpl implements WishlistService {

    private WishlistRepository repository;

    @Autowired
    public WishlistServiceImpl(WishlistRepository repository) {
        this.repository = repository;
    }

    @Override
    public Wishlist read(Long id) {
        return repository.getById(id);
    }

    @Override
    public List<Wishlist> readByMember(Long custId) {
        return repository.findByCustomerId(custId).get();
    }

    @Override
    public void createWishlist(Wishlist wishlist) {
        repository.save(wishlist);
    }

    @Override
    public void deleteWishlist(Long id) {
        repository.deleteById(id);
    }
}
