package app.restController;

import app.model.Contato;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ContatoResource {

    private Map<Integer, Contato> contatos;

    public ContatoResource() {
        this.contatos = new HashMap<Integer, Contato>();

        Contato c1 = new Contato(1, "Workshop Rest", "24hs");
        Contato c2 = new Contato(2, "Workshop Spring MVC", "24hs");
        Contato c3 = new Contato(3, "Desenvolvimento Web com JSF 2", "60hs");

        contatos.put(1, c1);
        contatos.put(2, c2);
        contatos.put(3, c3);
    }

    @ResponseBody
    @RequestMapping(value = "/contatos", method = RequestMethod.GET)
    public ResponseEntity<List<Contato>> listar() {
        return new ResponseEntity<List<Contato>>(new ArrayList<Contato>(contatos.values()), HttpStatus.OK);
    }
}
