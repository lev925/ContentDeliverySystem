package org.cds.controller;

import org.cds.model.Page;
import org.cds.model.Target;
import org.cds.service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
public class TargetController {
    @Autowired
    private TargetService targetService;
    @RequestMapping(path = "/target/get/{target-id}", method = RequestMethod.GET)
    public Target getContentById(@PathVariable("target-id") UUID id){
        return targetService.findById(id);
    }

    @RequestMapping(path = "/target/get", method = RequestMethod.GET)
    public List<Target> getAllTarget(){
        return targetService.getAllTarget();
    }
    @RequestMapping(path = "/target/save", method = RequestMethod.POST)
    public Target saveTarget(@RequestBody Target target){
        return targetService.saveTarget(target);
    }
    @PostMapping(path = "/target/get/{user-id}/{page-id}")
    public List<Target> getTargetByUserIdAndPage(@PathVariable("user-id") UUID userId,@PathVariable("page-id") Page page){
        return targetService.getTargetByUserIdAndPage(userId,page);
    }



}
