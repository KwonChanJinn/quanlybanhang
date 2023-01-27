package com.vti.service;

import com.vti.DTO.AccountDTO;
import com.vti.entity.Account;
import com.vti.repository.IAccountRepository;
import com.vti.service.IService.IAccountService;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {


    private IAccountRepository accountRepo;

    public UserService(IAccountRepository accountRepo) {

        this.accountRepo = accountRepo;
    }

    //phân quyền
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account = accountRepo.findByUserName(username);
        if (account != null) {
            if (account.getUserName().equals(username)) {
                return new User(username, account.getPassword(), AuthorityUtils.createAuthorityList(account.getRole()));
            }
        }
        return null;
    }
}
