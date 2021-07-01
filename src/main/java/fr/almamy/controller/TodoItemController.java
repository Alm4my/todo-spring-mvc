package fr.almamy.controller;

import fr.almamy.model.TodoData;
import fr.almamy.model.TodoItem;
import fr.almamy.service.TodoItemService;
import fr.almamy.util.AttributeNames;
import fr.almamy.util.Mappings;
import fr.almamy.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@Slf4j
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

    @GetMapping(Mappings.ADD_ITEM)
    public String addEdit(@RequestParam(required = false, defaultValue = "-1") int id,
                          Model model){
        log.info("Editing id = {}", id);
        var todoItem = todoItemService.getItem(id);

        if (todoItem == null)
            todoItem = new TodoItem("", "", LocalDateTime.now());

        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem){
        log.info("todoItem from form = {}", todoItem);
        if (todoItem.getId() == 0)
            todoItemService.addItem(todoItem);
        else
            todoItemService.updateItem(todoItem);

        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id){
        log.info("Deleting item with id = {}", id);
        todoItemService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam int id, Model model){
        log.info("Viewing item with id = {}", id);
        var todoItem = todoItemService.getItem(id);
        model.addAttribute("todoItem", todoItem);
        return ViewNames.EDIT_ITEM;
    }
}
