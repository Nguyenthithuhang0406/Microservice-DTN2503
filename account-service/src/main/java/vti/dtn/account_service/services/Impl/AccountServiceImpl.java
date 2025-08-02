package vti.dtn.account_service.services.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vti.dtn.account_service.dto.AccountDto;
import vti.dtn.account_service.entity.AccountEntity;
import vti.dtn.account_service.repository.AccountRepository;
import vti.dtn.account_service.services.AccountService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl  implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public List<AccountDto> getListAccounts() {
        List<AccountEntity> accountEntities = accountRepository.findAll();
        return accountEntities.stream().map(accountEntity -> new AccountDto(
                accountEntity.getId(),
                accountEntity.getUsername(),
                accountEntity.getFirstName(),
                accountEntity.getLastName())).toList();
    }

}
