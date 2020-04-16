package com.github.chicoferreira.tempmute.commons.user;

import com.github.chicoferreira.tempmute.user.User;
import com.github.chicoferreira.tempmute.user.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserServiceImpl implements UserService {

    private final Map<String, User> userNameMap = new HashMap<>();
    private final Map<UUID, User> userUuidMap = new HashMap<>();
    private final Map<Object, User> userEntityMap = new HashMap<>();

    @Override
    public User getUserByName(String name) {
        return userNameMap.get(name);
    }

    @Override
    public User getUserByUUID(UUID uuid) {
        return userUuidMap.get(uuid);
    }

    @Override
    public <E> User<E> getUserByEntity(E entity) {
        return userEntityMap.get(entity);
    }

    public void create(User user) {
        userNameMap.put(user.getName(), user);
        userUuidMap.put(user.getUUID(), user);
        userEntityMap.put(user.getEntity(), user);
    }
}
