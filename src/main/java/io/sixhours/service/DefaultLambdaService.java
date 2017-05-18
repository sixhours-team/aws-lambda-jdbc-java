package io.sixhours.service;

import io.sixhours.db.Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Default lambda service.
 *
 * @author Igor Bolic
 */
public class DefaultLambdaService implements LambdaService {

    private static volatile LambdaService instance;

    private DefaultLambdaService() {
    }

    public static LambdaService instance() {
        if (instance == null) {
            synchronized (DefaultLambdaService.class) {
                if (instance == null) {
                    instance = new DefaultLambdaService();
                }
            }
        }
        return instance;
    }

    @Override
    public void find() {
        try (PreparedStatement ps = Database.connection().prepareStatement("")) {
            // to be implemented
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
