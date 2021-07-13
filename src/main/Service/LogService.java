package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import Service.Log;
import Servicerepository.LogRepository;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    // agrego tracking
    public Log add(Log log) {
        return logRepository.save(log);
    }

    public List<Log> getAll() {
        List<Log> logs = logRepository.findAll();
        return logs;
    }
    public void deleteById(Integer id) {
        logRepository.delete(getById(id));
    }

    public Log getById(Integer id) {
        return logRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

}