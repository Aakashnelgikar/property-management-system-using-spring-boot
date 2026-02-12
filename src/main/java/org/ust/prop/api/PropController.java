package org.ust.prop.api;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ust.prop.model.Prop;
import org.ust.prop.service.PropService;
@RestController
@RequestMapping("/api/v1/Prop")
public class PropController {
     @Autowired
    public PropService service;

    public PropController(PropService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Prop>> getAllProperties(){
        List<Prop> p= service.getAllProp();
        return new ResponseEntity<>(p,HttpStatus.CREATED);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Prop addProp(@RequestBody Prop prop){
        return service.addProp(prop);
    }

    @PatchMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Prop updateProp(Long id,Prop prop){
        return service.updateProp(id, prop);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletePropById(@PathVariable Long id){
         service.deleteProp(id);
    }

}
