package com.san.tech.rent.wishlist.repository;

import com.san.tech.rent.wishlist.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

    @Query("SELECT w FROM Wishlist w where w.customerId = ?1")
    Optional<List<Wishlist>> findByCustomerId(Long id);
}
