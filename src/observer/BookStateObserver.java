package observer;

import models.Book;

//TODO Step 2
public interface BookStateObserver {
    void onBookStatusChanged(Book book);
}
