package app.restController;

import app.model.Contato;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.*;

@RestController
public class ContatoResource {

    private Map<Integer,Contato> contatos;

    public ContatoResource() {
        this.contatos = new TreeMap<>();

        Contato c1 = new Contato(1, "Naelio Freires", "(85) 8856-8989");
        Contato c2 = new Contato(2, "Maria Roberta", "(88) 8856-8966");
        Contato c3 = new Contato(3, "Francisco Nacelio", "(85) 9986-5412");

        contatos.put(1, c1);
        contatos.put(2, c2);
        contatos.put(3, c3);
    }

    @ResponseBody
    @RequestMapping(value = "/contatos", method = RequestMethod.GET)
    public ResponseEntity<List<Contato>> listar() {
        return new ResponseEntity<List<Contato>>(new ArrayList<Contato>(contatos.values()), HttpStatus.OK);
    }

    @RequestMapping(value="/contatos", method = RequestMethod.POST, produces="application/json")
    public void addContato(@RequestBody Contato contato){
        contato.setId(this.contatos.size()+1);
        this.contatos.put(contato.getId(),contato);
    }

    @RequestMapping(value="/contatos/{id}/delete", method = RequestMethod.DELETE, produces="application/json")
    public  void deleteContato(@PathVariable Integer id){
        System.out.println(id);
        this.contatos.remove(id);
    }


}
