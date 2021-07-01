package fr.almamy.controller;

import fr.almamy.model.TodoData;
import fr.almamy.model.TodoItem;
import fr.almamy.service.TodoItemService;
import fr.almamy.util.AttributeNames;
import fr.almamy.util.Mappings;
import fr.almamy.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoItemController {
    // == Fields ==
    private final TodoItemService todoItemService;

    // == Constructor ==
    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    // == Model Attributes ==
    @ModelAttribute
    public TodoData todoData(){
        return todoItemService.getData();
    }

    // == Handler Methods ==

    // http://localhost:8080/todo-list/items
    @GetMapping(Mappings.ITEMS)
    public String items(){
        return ViewNames.ITEMS_LIST;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem){
        return "redirect:/" + Mappings.ITEMS;
    }
}
