package business_objects;

public class UserFactory {

    public static UserBO createIafConsoleUser() {
        UserBO user = new UserBO("bhkb.jshcw@gqfozpkzgb.kbk", "password1");
        return user;
    }

    public static UserBO createSchedulerConsoleUser() {
        UserBO user = new UserBO("tomcat-jobs", "tomcat-jobs");
        return user;
    }
}
