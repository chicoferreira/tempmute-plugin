package com.github.chicoferreira.tempmute.commons.user;

import com.github.chicoferreira.tempmute.user.User;

import java.util.UUID;

public abstract class AbstractUser<E> implements User<E> {

    private String name;
    private UUID uuid;
    private E entity;

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
