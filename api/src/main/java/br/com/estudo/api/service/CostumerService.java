package br.com.estudo.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.estudo.api.model.Costumer;

@Service
public class CostumerService {
	
	private static List<Costumer> costumerList = new ArrayList<Costumer>();
	
	public List<Costumer> getAll() {
		return costumerList;
	}
	
	public Costumer get(Long id) {
		Costumer foundCostumer = null;
		for(Costumer c : costumerList) {
			if(c.getId() == id) {
				foundCostumer = c;
				break;
			}
		}
		return foundCostumer;
	}
	
    public void save(Costumer costumer) {
    	costumerList.add(costumer);
    }
    
    public void change(Long id, Costumer costumer) {
    	for(Costumer c : costumerList) {
			if(c.getId() == id) {
				if(costumer.getName() != null) {
					c.setName(costumer.getName());
				}
				if(costumer.getEmail() != null) {
					c.setEmail(costumer.getEmail());
				}
				if(costumer.getDataNascimento() != null) {
					c.setDataNascimento(costumer.getDataNascimento());
				}
				break;
			}
		}
    }
    
    public void delete(Long id) {
    	for(int i = 0; i < costumerList.size(); i++) {
			if(costumerList.get(i).getId() == id) {
				costumerList.remove(i);
				break;
			}
		}
    }

}
