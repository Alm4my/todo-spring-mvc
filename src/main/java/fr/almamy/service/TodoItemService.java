package fr.almamy.service;

import fr.almamy.model.TodoData;
import fr.almamy.model.TodoItem;

public interface TodoItemService {
    void addItem(TodoItem toAdd);
    void removeItem(int id);
    void updateItem(TodoItem toUpdate);
    TodoItem getItem(int id);
    TodoData getData();

}
