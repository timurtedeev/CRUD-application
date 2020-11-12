package net.proselyte.console.rest;

import net.proselyte.console.model.Human;
import net.proselyte.console.service.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 */
@RestController
@RequestMapping("/api/v1/humans/")
public class HumanREStControllerV1 {
    @Autowired
    private HumanService humanService;

    @RequestMapping(value = "{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Human> getHuman(@PathVariable("id") Long humanId){
        if(humanId == null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Human human = this.humanService.getBuId(humanId);
        if (human == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(human,HttpStatus.OK);
    }
    @RequestMapping(value = "",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Human> postHuman(@RequestBody  Human human){
        HttpHeaders headers = new HttpHeaders();
        if (human == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.humanService.post(human);
        return new ResponseEntity<>(human,headers,HttpStatus.CREATED);

    }
    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Human> putHuman(@RequestBody Human human, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if(human == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.humanService.post(human);

        return new ResponseEntity<>(human,headers,HttpStatus.OK);
    }
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Human> deleteHuman(@PathVariable("id") Long id){
         Human human = this.humanService.getBuId(id);
         if(human == null){
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }

         this.humanService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
