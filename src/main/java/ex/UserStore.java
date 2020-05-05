package ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for(int index = 0; index < users.length; index ++){
            if (users[index].getUsername().equals(login)) {
                return users[index];
            }
        }
        throw new UserNotFoundException("User by name " + login + " didn't find");
    }

    public static boolean validate(User user) throws UserInvalidException{
        if (!user.isValid()) {
            throw new UserInvalidException("User by name " + user.getUsername() + " is not valid");
        } if (user.getUsername().length() < 3) {
            throw new UserInvalidException("User name " + user.getUsername() + " is too small");
        }
            return true;
        }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e){
            System.out.println(e.getMessage());
        } catch (UserNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

}
