package org.cds.controller;

import org.cds.model.Viewed;
import org.cds.service.ViewedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ViewedController {

    @Autowired
    ViewedService viewedService;
}
