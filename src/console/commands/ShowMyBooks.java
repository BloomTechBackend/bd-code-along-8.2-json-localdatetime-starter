package console.commands;

import models.User;

public class ShowMyBooks {


    public static void start() {
        User.currentUser.getBooks();

    }
}
