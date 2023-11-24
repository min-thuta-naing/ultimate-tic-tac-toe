package th.mfu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ResetAutoIncrementService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // public void resetAutoIncrement(String tableName) {

    //     dropForeignKeyConstraint(tableName); 
    //     String resetSql = "ALTER TABLE " + tableName + " AUTO_INCREMENT = 1";
    //     jdbcTemplate.execute(resetSql);

    //     // Additional statement for InnoDB engine
    //     // String setEngineSql = "ALTER TABLE " + tableName + " ENGINE=InnoDB";
    //     // jdbcTemplate.execute(setEngineSql);
    // }

    // public void dropForeignKeyConstraint(String tableName) {
    //     // String checkForeignKeySql = "SELECT COUNT(*) FROM information_schema.table_constraints WHERE constraint_name = 'FKk6liqsjt69vc76wx8hn8p52gm'";
    //     // int count = jdbcTemplate.queryForObject(checkForeignKeySql, Integer.class);
    
    //     // if (count > 0) {
    //     //     String dropFK = "ALTER TABLE " + tableName + " DROP FOREIGN KEY FKk6liqsjt69vc76wx8hn8p52gm";
    //     //     jdbcTemplate.execute(dropFK);
    //     // }
    //     String foreignKeyName = "FKk6liqsjt69vc76wx8hn8p52gm";
    //     String dropFK = "ALTER TABLE " + tableName + " DROP FOREIGN KEY " + foreignKeyName;
    //     try {
    //         jdbcTemplate.execute(dropFK);
    //     } catch (Exception e) {
    //         e.printStackTrace(); // Log the exception
    //     }
    // }

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
            e.printStackTrace(); // Log the exception
        }
    }
    
    // public void resetAutoIncrement(String tableName) {
    //     String resetSql = "TRUNCATE TABLE " + tableName;
    //     jdbcTemplate.execute(resetSql);
    // }
}
