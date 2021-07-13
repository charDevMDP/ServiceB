package Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import Repository.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Integer> {
}