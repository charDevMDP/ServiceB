import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class LogTest {

    LogService logService;
    LogControllerApi logController;


    @BeforeEach
    public void setUp() {
        logService = mock(LogService.class);
        logController = new LogController(logService);
    }

    @Test
    public void addTestOK() {
        Log log = new Log(123,2,"2020-09-02 22:32:32");
        when(logService.add(log).thenReturn(log));

        ResponseEntity<Log> response = logControllerApi.addLog(log);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(obj, response.getBody());
    }


}