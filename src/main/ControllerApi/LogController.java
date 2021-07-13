package ControllerApi;

import ControllerApi.Log;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ControllerApiservice.LogService;

import java.net.URI;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    LogService logService;

    // tracking
    @PostMapping
    public ResponseEntity addLog(@RequestBody Log logAdd) {
        Log log = logService.add(logAdd);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/log/{id}")
                .buildAndExpand(log, log.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    @GetMapping
    public ResponseEntity<Log> getAll(Pageable pageable) {
        Page<Log> log = logService.getAll(pageable);
        return response(log);
    }

    @GetMapping("/{id}")
    public ReponseEntity<Log> getById(@PathVariable Integer id) {
        Log log = logService.getById(id);
        return ResponseEntity.ok(log);
    }


}