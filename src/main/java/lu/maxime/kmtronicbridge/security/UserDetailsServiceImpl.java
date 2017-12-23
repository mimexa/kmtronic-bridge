package lu.maxime.kmtronicbridge.security;

import static java.util.Collections.emptyList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lu.maxime.kmtronicbridge.domain.User;
import lu.maxime.kmtronicbridge.utils.Constants;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = Constants.getUser();
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				emptyList());
	}
}