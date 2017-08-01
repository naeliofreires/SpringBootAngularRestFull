package app.restController;

import app.model.Contato;
import app.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ContatoResource {

    @Autowired
    private ContatoRepository contRepo;

    public ContatoResource() { }

    @RequestMapping(value = "/contatos", method = RequestMethod.GET,  produces="application/json")
    public ResponseEntity<List<Contato>> listar() {
        return new ResponseEntity<List<Contato>>((ArrayList) this.contRepo.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value="/contatos", method = RequestMethod.POST, produces="application/json")
    public void addContato(@RequestBody Contato contato){
        this.contRepo.save(contato);
    }

    @RequestMapping(value="/contatos/{id}/delete", method = RequestMethod.DELETE, produces="application/json")
    public void deleteContato(@PathVariable Integer id){
        this.contRepo.delete(id);
    }

    @RequestMapping(value = "/contatos", method = RequestMethod.PUT, produces="application/json")
    public void updateContato(@RequestBody Contato contato){
        this.contRepo.save(contato);
    }


}
