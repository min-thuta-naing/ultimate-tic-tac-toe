package th.mfu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ResetAutoIncrementService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void resetAutoIncrement(String tableName, String schemaName) {
        dropForeignKeyConstraint(tableName, schemaName);
        String resetSql = "ALTER TABLE " + schemaName + "." + tableName + " AUTO_INCREMENT = 1";
        jdbcTemplate.execute(resetSql);
    }

    public void dropForeignKeyConstraint(String tableName, String schemaName) {
        String foreignKeyName = "FKk6liqsjt69vc76wx8hn8p52gm";
        String dropFK = "ALTER TABLE " + schemaName + "." + tableName + " DROP FOREIGN KEY " + foreignKeyName;
        try {
            jdbcTemplate.execute(dropFK);
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
}
