package api.ecommerce.br.apiecommerce.config.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import api.ecommerce.br.apiecommerce.model.UserAdm;
import api.ecommerce.br.apiecommerce.model.UserModel;

@Service
public class VerifyAuthentication {
    
    public boolean verifyUserIsAuthenticated() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated()) {
            return false;
        }
        return true;
    }

    public boolean verifyIsAdminRole() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        boolean hasAdminRole = auth.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ADMIN"));

        if (!hasAdminRole) {
            return false;
        }
        return true;
    }

    public boolean verifyIsOwnerRole() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        boolean hasAdminRole = auth.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("OWNER"));

        if (!hasAdminRole) {
            return false;
        }
        return true;
    }

    public UserModel userAuthenticated() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserModel userModel = (UserModel) authentication.getPrincipal();

        return userModel;
    }

    public UserAdm userAdmAuthenticated() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserAdm userAdm = (UserAdm) authentication.getPrincipal();

        return userAdm;
    }

}
