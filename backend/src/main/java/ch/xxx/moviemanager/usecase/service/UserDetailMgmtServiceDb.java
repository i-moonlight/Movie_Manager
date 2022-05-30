/**
 *    Copyright 2019 Sven Loesekann
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
       http://www.apache.org/licenses/LICENSE-2.0
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package ch.xxx.moviemanager.usecase.service;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ch.xxx.moviemanager.domain.model.entity.RevokedTokenRepository;
import ch.xxx.moviemanager.domain.model.entity.UserRepository;
import ch.xxx.moviemanager.usecase.mapper.RevokedTokenMapper;
import ch.xxx.moviemanager.usecase.mapper.UserMapper;

@Profile("kafka & prod-kafka")
@Transactional
@Service
public class UserDetailMgmtServiceDb extends UserDetailsMgmtService {

	public UserDetailMgmtServiceDb(UserRepository userRepository, PasswordEncoder passwordEncoder,
			RevokedTokenRepository revokedTokenRepository, JavaMailSender javaMailSender,
			JwtTokenService jwtTokenService, UserMapper userMapper, RevokedTokenMapper revokedTokenMapper) {
		super(userRepository, passwordEncoder, revokedTokenRepository, javaMailSender, jwtTokenService, userMapper, revokedTokenMapper);
	}

}
