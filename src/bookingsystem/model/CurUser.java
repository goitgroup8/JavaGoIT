package bookingsystem.model;

public class CurUser {
    private User curUser;

    public User getCurUser() {
        return curUser;
    }

    public void setCurUser(User curUser) {
        this.curUser = curUser;
        System.out.println("Sign in with your profile: \n" + curUser);
        System.out.println();
    }
}
