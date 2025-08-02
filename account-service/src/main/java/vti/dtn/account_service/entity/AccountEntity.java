
package vti.dtn.account_service.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "accounts")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String username;
    String firstName;
    String lastName;
}

// Đây là mẫu của một entity, phải có 2 annotation là @Entity và @Table.
// Sau đó phải có một khóa chính @Id, @GeneratedValue là định nghĩa cái PK, ở đây IDENTITY là tự tăng.