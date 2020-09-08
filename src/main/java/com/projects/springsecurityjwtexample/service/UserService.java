package com.projects.springsecurityjwtexample.service;

import com.projects.springsecurityjwtexample.domain.User;
import com.projects.springsecurityjwtexample.exception.domain.EmailExistException;
import com.projects.springsecurityjwtexample.exception.domain.EmailNotFoundException;
import com.projects.springsecurityjwtexample.exception.domain.UserNotFoundException;
import com.projects.springsecurityjwtexample.exception.domain.UsernameExistException;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public interface UserService {

    User register(String firstName, String lastName, String username, String email) throws UserNotFoundException, UsernameExistException, EmailExistException, MessagingException;

    List<User> getUsers();

    User findUserByUsername(String username);

    User findUserByEmail(String email);

    User addNewUser(String firstName, String lastName, String username, String email, String role, boolean isNonLocked, boolean isActive, MultipartFile profileImage) throws UserNotFoundException, UsernameExistException, EmailExistException, IOException;

    User updateUser(String currentUserName, String newFirstName, String newLastName, String newUsername, String newEmail, String role, boolean isNonLocked, boolean isActive, MultipartFile profileImage) throws UserNotFoundException, UsernameExistException, EmailExistException, IOException;

    void deleteUser(long id);

    void resetPassword(String email) throws EmailNotFoundException, MessagingException;

    User updateProfileImage(String username, MultipartFile profileImage) throws UserNotFoundException, UsernameExistException, EmailExistException, IOException;
}
