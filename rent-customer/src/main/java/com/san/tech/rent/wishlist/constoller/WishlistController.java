package com.san.tech.rent.wishlist.constoller;

import com.san.tech.rent.wishlist.entity.Wishlist;
import com.san.tech.rent.wishlist.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/wishlist")
@ComponentScan("com.san.tech.rent.wishlist.serviceimpl")
public class WishlistController {
    private WishlistService service;

    @Autowired
    public WishlistController(WishlistService service) {
        this.service = service;
    }

    @GetMapping(path="{id}")
    public Wishlist read(@PathVariable("id") Long id){
        return service.read(id);
    }

    @GetMapping(path="{custId}")
    public List<Wishlist> readByCustomerId(@PathVariable("custId") Long custId){
        return service.readByMember(custId);
    }

    @PostMapping
    public void createWishlist(@RequestBody Wishlist wishlist){
        service.createWishlist(wishlist);
    }

    @DeleteMapping(path = "{id}")
    public void deleteWishlist(@PathVariable("id") Long id){
        service.deleteWishlist(id);
    }
}
