package ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for(int index = 0; index < users.length; index ++){
            if (users[index].getUsername().equals(login)) {
                return users[index];
            } else {
                throw new UserNotFoundException("User by name " + login + " didn't find");
            }
        }
        return null;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.isValid() == false) {
            throw new UserInvalidException("User by name " + user.getUsername() + " is not valid");
        } else {
            return true;
        }

    }

    public static void main(String[] args) throws UserNotFoundException {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
          User user = findUser(users, "Petr Arsentev");
        }
        catch (UserNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            if (validate(findUser(users, "Petr Arsentev"))) {
                System.out.println("This user has an access");
            }
        }
        catch (UserInvalidException e){
            System.out.println(e.getMessage());
        }
    }

}
