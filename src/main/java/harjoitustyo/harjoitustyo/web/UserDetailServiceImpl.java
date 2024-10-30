package harjoitustyo.harjoitustyo.web;

import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import harjoitustyo.harjoitustyo.domain.AppUser;
import harjoitustyo.harjoitustyo.domain.AppUserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final AppUserRepository userRepository;

    @Autowired
    public UserDetailServiceImpl(AppUserRepository userRepository) {
        this.userRepository = userRepository;
    };

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser curruser = userRepository.findByUsername(username);
        if (curruser == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return new org.springframework.security.core.userdetails.User(
                curruser.getUsername(),
                curruser.getPasswordHash(),
                AuthorityUtils.createAuthorityList(curruser.getRole()));
    }
}
