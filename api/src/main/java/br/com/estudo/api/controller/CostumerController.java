package br.com.estudo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudo.api.model.Costumer;
import br.com.estudo.api.service.CostumerService;


@RestController
@RequestMapping(path = "/costumer")
public class CostumerController {
	
	@Autowired
	CostumerService costumerService;
	
	@GetMapping("/getAll")
    public List<Costumer> getAll() {		
        return costumerService.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Costumer> get(@PathVariable Long id) {		
		return new ResponseEntity<Costumer>(costumerService.get(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Costumer> createClient(@RequestBody Costumer costumer) {
    	costumerService.save(costumer);
        return new ResponseEntity<Costumer>(costumer, HttpStatus.CREATED);
    }
    
    @PutMapping("/change/{id}")
    public ResponseEntity<Costumer> updateClient(@PathVariable Long id, @RequestBody Costumer costumer) {
    	costumerService.change(id, costumer);
        return new ResponseEntity<Costumer>(costumer, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {
        //return ResponseEntity.ok().build();
    	costumerService.delete(id);
        return new ResponseEntity<String>("Deletado com sucesso", HttpStatus.OK);
    }

}

