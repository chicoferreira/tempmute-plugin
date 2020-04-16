package com.github.chicoferreira.tempmute.command;

import com.github.chicoferreira.tempmute.user.User;

public interface Command {

    String getName();

    void execute(User user, String[] args);

}
