package edu.escuelaing.app.controller;

import com.google.gson.Gson;
import edu.escuelaing.app.model.Log;
import edu.escuelaing.app.model.LogDao;
import edu.escuelaing.app.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/logs")
public class LogController {
    @Autowired
    LogService logService;

    @GetMapping()
    public ResponseEntity<?> getLastEvents(){
        return new ResponseEntity<>(new Gson().toJson(logService.getLastLogs()), HttpStatus.ACCEPTED);
    }

    @PostMapping()
    public ResponseEntity<?> createEvent(@RequestBody String log){
        logService.createLog(new Log(new LogDao(log, new Date())));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
