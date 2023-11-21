package th.mfu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ResetAutoIncrementService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void resetAutoIncrement(String tableName) {
        String resetSql = "ALTER TABLE " + tableName + " AUTO_INCREMENT = 1";
        jdbcTemplate.execute(resetSql);

        // Additional statement for InnoDB engine
        String setEngineSql = "ALTER TABLE " + tableName + " ENGINE=InnoDB";
        jdbcTemplate.execute(setEngineSql);
    }
}
