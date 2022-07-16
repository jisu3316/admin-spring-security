package com.jisu.adminspringsecurity.repository;


import com.jisu.adminspringsecurity.domain.entity.Resources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResourcesRepository extends JpaRepository<Resources, Long> {

    com.jisu.adminspringsecurity.domain.entity.Resources findByResourceNameAndHttpMethod(String resourceName, String httpMethod);

    @Query("select r from Resources r join fetch r.roleSet where r.resourceType = 'url' order by r.orderNum desc")
    List<com.jisu.adminspringsecurity.domain.entity.Resources> findAllResources();

    @Query("select r from Resources r join fetch r.roleSet where r.resourceType = 'method' order by r.orderNum desc")
    List<com.jisu.adminspringsecurity.domain.entity.Resources> findAllMethodResources();

    @Query("select r from Resources r join fetch r.roleSet where r.resourceType = 'pointcut' order by r.orderNum desc")
    List<com.jisu.adminspringsecurity.domain.entity.Resources> findAllPointcutResources();
}