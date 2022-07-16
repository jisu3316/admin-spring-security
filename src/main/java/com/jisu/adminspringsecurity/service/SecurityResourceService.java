package com.jisu.adminspringsecurity.service;

import com.jisu.adminspringsecurity.domain.entity.Resources;
import com.jisu.adminspringsecurity.repository.ResourcesRepository;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class SecurityResourceService {

    private ResourcesRepository resourcesRepository;

    public SecurityResourceService(ResourcesRepository resourcesRepository) {
        this.resourcesRepository = resourcesRepository;
    }
    int i = 0;
    int j = 0;
    public LinkedHashMap<RequestMatcher, List<ConfigAttribute>> getResourceList() {

        LinkedHashMap<RequestMatcher, List<ConfigAttribute>> result = new LinkedHashMap<>();
        List<Resources> resourcesList = resourcesRepository.findAllResources(); // 디비에 있는 모든 자원을가져온다. 여기에는 리소스(자원)마다 여러개의 롤이있다. 그것을 다 가져온다.
        resourcesList.forEach(re -> {
            i++;
            System.out.println(i+ " re = " + re);
            List<ConfigAttribute> configAttributes = new ArrayList<>();
            re.getRoleSet().forEach(role -> {

                configAttributes.add(new SecurityConfig(role.getRoleName()));
                result.put(new AntPathRequestMatcher(re.getResourceName()), configAttributes);
                System.out.println(j+ " result = " + result);
            });

        });
        System.out.println("result = " + result);
        return result;
    }
}
