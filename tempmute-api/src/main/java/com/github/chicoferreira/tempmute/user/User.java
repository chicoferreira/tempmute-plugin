package com.github.chicoferreira.tempmute.user;

import java.util.UUID;

public interface User<E> {

    E getEntity();

    String getName();

    UUID getUUID();

}
