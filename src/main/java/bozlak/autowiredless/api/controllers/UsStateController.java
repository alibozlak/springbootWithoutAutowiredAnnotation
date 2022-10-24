package bozlak.autowiredless.api.controllers;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bozlak.autowiredless.IocConfig;
import bozlak.autowiredless.business.abstracts.UsStateService;
import bozlak.autowiredless.entities.UsState;

@RestController
@RequestMapping("/api/usStates")
public class UsStateController {
    
    private UsStateService usStateService
    = new AnnotationConfigApplicationContext(IocConfig.class)
    .getBean("usStateService", UsStateService.class);

    @GetMapping("/getAll")
    public List<UsState> getAll() {
        return usStateService.getAll();
    }

    @GetMapping("/getById/{stateId}")
    public UsState getById(@PathVariable int stateId) {
        return usStateService.getById(stateId);
    }

    @PostMapping("/add")
    public void add(@RequestBody UsState usState) {
        usStateService.add(usState);
    }

    @PutMapping("/update")
    public void update(@RequestBody UsState usState) {
        usStateService.update(usState);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody UsState usState) {
        usStateService.delete(usState);
    }
}
