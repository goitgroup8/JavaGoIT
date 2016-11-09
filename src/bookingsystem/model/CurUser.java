package bookingsystem.model;

import static bookingsystem.model.Controller.userDAO;

public class CurUser {
    private User curUser;

    public User getCurUser() {
        return curUser;
    }

    public void setCurUser(User curUser) {
        if (userDAO.getAll().contains(curUser)) {
            this.curUser = curUser;
            System.out.println("You set current user: " + curUser.getFirstName() + " " + curUser.getLastName());
        } else {
            System.out.println("You can't set current user: " + curUser.getFirstName() + " " + curUser.getLastName() + "\nUser not register");
        }
    }
}
