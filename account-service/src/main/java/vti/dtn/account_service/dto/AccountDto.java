package vti.dtn.account_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AccountDto {
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
}
