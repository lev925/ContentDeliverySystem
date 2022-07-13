package org.cds.controller;

import org.cds.model.Page;
import org.cds.model.Target;
import org.cds.model.web.WebTarget;
import org.cds.model.web.WebTargetASM;
import org.cds.model.web.WebTargetFilter;
import org.cds.service.TargetService;
import org.cds.service.web.WebTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
public class TargetController {
    @Autowired
    private WebTargetService webTargetService;
    @RequestMapping(path = "/target/get/{target-id}", method = RequestMethod.GET)
    public WebTarget getContentById(@PathVariable("target-id") UUID id){
        return webTargetService.findById(id);
    }

    @RequestMapping(path = "/target/get", method = RequestMethod.GET)
    public List<WebTarget> getAllTarget(){
        return webTargetService.getAllTarget();
    }
    @RequestMapping(path = "/target/save", method = RequestMethod.POST)
    public ResponseEntity saveTarget(@RequestBody WebTargetASM webTargetASM){

        webTargetService.saveTarget(webTargetASM);
        return ResponseEntity.ok().build();
    }
    @PostMapping(path = "/target/get")
    public List<WebTarget> getTargetByUserIdAndPage(@RequestBody WebTargetFilter webTargetFilter){
        return webTargetService.getAllTargetsByUserAndPage(webTargetFilter);
    }



}
