package br.com.estudo.api.controller;

import java.util.ArrayList;
import java.util.List;

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


@RestController
@RequestMapping(path = "/costumer")
public class HTTPMethodsController {
	
	@GetMapping("/getAll")
    public List<Costumer> getAllClient() {
		List<Costumer> costumerList = new ArrayList<Costumer>();
		costumerList.add(new Costumer(1L, "a", "a@a.com"));
		costumerList.add(new Costumer(2L, "b", "b@b.com"));
		
        return costumerList;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Costumer> getClient(@PathVariable Long id) {
		List<Costumer> costumerList = new ArrayList<Costumer>();
		costumerList.add(new Costumer(1L, "a", "a@a.com"));
		costumerList.add(new Costumer(2L, "b", "b@b.com"));
		
		Costumer foundCostumer = null;
		for(Costumer c : costumerList) {
			if(c.getId() == id) {
				foundCostumer = c;
				break;
			}
		}
		
		return new ResponseEntity<Costumer>(foundCostumer, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Costumer> createClient(@RequestBody Costumer client) {
        return new ResponseEntity<Costumer>(client, HttpStatus.OK);
    }
    
    //warning
    @PutMapping("/change/{id}")
    public ResponseEntity updateClient(@PathVariable Long id, @RequestBody Costumer client) {
        return new ResponseEntity<Costumer>(client, HttpStatus.OK);
    }

    //muito usado a identificação pelo método http apenas, sem definir nome
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

}

