package com.san.tech.rent.wishlist.service;

import com.san.tech.rent.wishlist.entity.Wishlist;

import java.util.List;

public interface WishlistService {
    Wishlist read(Long id);
    List<Wishlist> readByMember(Long custId);
    void createWishlist(Wishlist wishlist);
    void deleteWishlist(Long id);
}
