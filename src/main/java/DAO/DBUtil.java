package DAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class DBUtil {
    private static EntityManagerFactory emf = null;

    // Sử dụng khối static để khởi tạo chỉ một lần
    static {
        try {
            // Lấy chuỗi kết nối từ biến môi trường của Render
            String databaseUrl = System.getenv("DATABASE_URL");
            
            if (databaseUrl != null) {
                // Nếu có biến DATABASE_URL (khi deploy trên Render)
                System.out.println("Connecting to Render PostgreSQL...");
                URI dbUri = new URI(databaseUrl);

                String username = dbUri.getUserInfo().split(":")[0];
                String password = dbUri.getUserInfo().split(":")[1];
                // Thêm ?sslmode=require để kết nối an toàn trên Render
                String jdbcUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";

                Map<String, String> properties = new HashMap<>();
                properties.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
                properties.put("javax.persistence.jdbc.url", jdbcUrl);
                properties.put("javax.persistence.jdbc.user", username);
                properties.put("javax.persistence.jdbc.password", password);
                
                // Thêm các thuộc tính khác của Hibernate nếu cần
                properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
                
                emf = Persistence.createEntityManagerFactory("userAdminPU", properties);
            } else {
                // Nếu không có (khi chạy trên máy local), dùng cấu hình từ persistence.xml
                System.out.println("Connecting to local database via persistence.xml...");
                emf = Persistence.createEntityManagerFactory("userAdminPU");
            }
        } catch (URISyntaxException e) {
            System.err.println("Error parsing DATABASE_URL: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Failed to initialize EntityManagerFactory: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
}
