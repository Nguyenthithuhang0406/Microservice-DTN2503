package vti.dtn.account_service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vti.dtn.account_service.dto.AccountDto;
import vti.dtn.account_service.services.AccountService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/accounts")
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    public List<AccountDto> getListAccounts() {
        log.info("Fetching list of accounts");
        return accountService.getListAccounts();
    }
}
