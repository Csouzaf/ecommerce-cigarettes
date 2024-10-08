package api.ecommerce.br.apiecommerce.model;

import java.util.*;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.util.Optionals;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Pattern.Flag;
import lombok.*;

@Entity
@Table(name = "adm_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserAdm implements UserDetails{
   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    
    @NotEmpty(message = "Nome obrigatório")
    private String fullName;

    @NotNull
    @Column(unique = true)
    @NotEmpty(message = "Email obrigatório")
    @Email(message = "O email informado é inválido", flags = Flag.CASE_INSENSITIVE)
    @Pattern(regexp=".+@.+\\..+", message = "Insira um email válido com @ e um domínio")
    private String email;
    
    @NotEmpty(message = "Número obrigatório")
    @Column(name = "phone_number")
    private String phoneNumber;

    // @CPF
    @Column(name = "cpf", length = 11, unique = true)
    private String cpf;

    @NotEmpty(message = "CNPJ obrigatório")
    @Column(name = "cnpj", length = 14, unique = true)
    private String cnpj;

    @NotEmpty(message = "Endereco obrigatório")
    private String address;

    @NotEmpty(message = "Senha obrigatória")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));

        // throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
        
        // return List.of(new SimpleGrantedAuthority(role.email));
    }

    @Override
    public String getUsername() {
      
        return email;
    }

    @Override
    public String getPassword(){

        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
       return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

   
   
   

  
}
