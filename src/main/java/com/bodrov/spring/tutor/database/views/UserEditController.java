package com.bodrov.spring.tutor.database.views;

import com.bodrov.spring.tutor.database.entity.User;
import com.bodrov.spring.tutor.database.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class UserEditController {

    @Autowired
    private UserRepository userRepository;

    @Nullable
    private String id;

    @NotNull
    private User user = new User();

    public void init() {
        @Nullable final User user = userRepository.getOne(id);
        if (user != null) this.user = user;
    }

    @NotNull
    public String save() {
        userRepository.save(user);
        return "/secure/user-list";
    }

    @Nullable
    public String getId() {
        return id;
    }

    public void setId(@Nullable final String id) {
        this.id = id;
    }

    @NotNull
    public User getUser() {
        return user;
    }

    public void setUser(@NotNull final User user) {
        this.user = user;
    }
}
