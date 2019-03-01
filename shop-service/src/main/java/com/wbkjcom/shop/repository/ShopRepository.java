package com.wbkjcom.shop.repository;

import com.wbkjcom.shop.model.Shop;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.jpa.repository.JpaRepository;

@CacheConfig(cacheNames = "shops")
public interface ShopRepository extends JpaRepository<Shop,Long>{

    @CachePut
    Shop save(Shop user);

//    @CacheEvict
//    void delete(Long id);
}