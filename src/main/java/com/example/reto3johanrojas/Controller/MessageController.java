package com.example.reto3johanrojas.Controller;

import com.example.reto3johanrojas.Model.Message;
import com.example.reto3johanrojas.Model.Message;
import com.example.reto3johanrojas.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*" , methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
@RestController
@RequestMapping("/api/Message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/all")     // ->>>>      localhost.../api/Message/all
    public List<Message> getAll(){
        return messageService.getAll();
    }

    @GetMapping("/{id}")  // ->>>> localhost..../api/Message/12
    public Optional<Message> getMessage(@PathVariable int id){
        return messageService.getMessage(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message Save(@RequestBody Message message){
        return messageService.save(message);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update (@RequestBody Message message){
        return messageService.update(message);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable int id){
        return messageService.delete(id);
    }
}

