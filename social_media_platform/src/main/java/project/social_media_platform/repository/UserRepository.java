package project.social_media_platform.repository;

import DB.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByphonenumber(String phonenumber);
}
