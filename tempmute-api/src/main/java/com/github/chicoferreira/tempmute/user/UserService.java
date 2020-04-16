package com.github.chicoferreira.tempmute.user;

import java.util.UUID;

public interface UserService {

    User getUserByName(String name);

    User getUserByUUID(UUID uuid);

    <E> User<E> getUserByEntity(E entity);

}
