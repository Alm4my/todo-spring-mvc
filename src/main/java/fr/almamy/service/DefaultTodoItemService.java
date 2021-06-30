package fr.almamy.service;

import fr.almamy.model.TodoData;
import fr.almamy.model.TodoItem;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class DefaultTodoItemService implements TodoItemService {
    // == Fields ==
    @Getter
    private final TodoData data = new TodoData();

    // == Public Methods ==
    @Override
    public void addItem(TodoItem todoItem) {
        data.addItem(todoItem);
    }

    @Override
    public void removeItem(int id) {
        data.removeItem(id);
    }

    @Override
    public void updateItem(TodoItem todoItem) {
        data.updateItem(todoItem);
    }

    @Override
    public TodoItem getItem(int id) {
        return data.getItem(id);
    }
}
