import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String nameUser = "root";
        String pass = "Misha06122000)))";

        Connection connection = DriverManager.getConnection(url, nameUser, pass);
        Statement statement = connection.createStatement();
        statement.execute("UPDATE courses SET name='SQL for developments' " +
                "WHERE id=46");

        ResultSet resultSet = statement.executeQuery("SELECT * FROM courses");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int duration = resultSet.getInt("duration");
            String courseType = resultSet.getString("type");
            String description = resultSet.getString("description");
            int teacherId = resultSet.getInt("teacher_id");
            int studentsCount = resultSet.getInt("students_count");
            int price = resultSet.getInt("price");
            float pricePerHour = resultSet.getFloat("price_per_hour");

            Course course = new Course();
            course.setId(id);
            course.setName(name);
            course.setDuration(duration);
            course.setCourseType(CourseType.valueOf(courseType));
            course.setDescription(description);
            course.setTeacherId(teacherId);
            course.setStudentsCount(studentsCount);
            course.setPrice(price);
            course.setPricePerHour(pricePerHour);
            System.out.println(course);
        }

        statement.close();
        connection.close();
    }
}
