package com.github.chicoferreira.tempmute.commons.user;

import com.github.chicoferreira.tempmute.user.User;

import java.util.UUID;

public abstract class AbstractUser<E> implements User<E> {

    private final String name;
    private final UUID uuid;
    private final E entity;

    public AbstractUser(String name, UUID uuid, E entity) {
        this.name = name;
        this.uuid = uuid;
        this.entity = entity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public UUID getUUID() {
        return uuid;
    }

    @Override
    public E getEntity() {
        return entity;
    }
}
