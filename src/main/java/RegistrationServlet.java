import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "asuspro15";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve user input from the registration form
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            // Establish a connection to the database
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Prepare SQL statement for inserting user data
            String sql = "INSERT INTO users (first_name, last_name, email, age, username, password) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, email);
            statement.setInt(4, age);
            statement.setString(5, username);
            statement.setString(6, password);

            // Execute the SQL statement to insert user data
            statement.executeUpdate();

            // Close the connection to the database
            connection.close();

            // Redirect the user to the login page after successful registration
            response.sendRedirect("login.jsp");
        } catch (SQLException e) {
            throw new ServletException("Error in registration", e);
        }
    }
}