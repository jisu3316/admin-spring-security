package com.jisu.adminspringsecurity.service;



import com.jisu.adminspringsecurity.domain.dto.AccountDto;
import com.jisu.adminspringsecurity.domain.entity.Account;

import java.util.List;

public interface UserService {

    void createUser(Account account);

    void modifyUser(AccountDto accountDto);

    List<Account> getUsers();

    AccountDto getUser(Long id);

    void deleteUser(Long idx);
}
