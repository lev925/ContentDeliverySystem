package org.cds.controller;

import org.cds.model.Target;
import org.cds.service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
@RestController
public class TargetController {
    @Autowired
    private TargetService targetService;
//    @RequestMapping(path = "/target/get/{user-id}", method = RequestMethod.GET)
//    public List<Target> getContentById(@PathVariable("user-id") UUID id){
//        return targetService.getTargetByUserIdAndPage(id);
//    }

    @RequestMapping(path = "/target/get", method = RequestMethod.GET)
    public List<Target> getAllTarget(){
        return targetService.getAllTarget();
    }



}
