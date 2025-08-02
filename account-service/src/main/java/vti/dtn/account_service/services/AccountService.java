package vti.dtn.account_service.services;

import vti.dtn.account_service.dto.AccountDto;

import java.util.List;

public interface AccountService {
    List<AccountDto> getListAccounts();
}
