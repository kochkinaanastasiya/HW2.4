public class Main {
    public static void main(String[] args) {
        String login = "123qwe1";
        String password = "qqwe_12";
        String confirmPassword = "qqwe_12";
        System.out.println(informationUsers(login, password, confirmPassword));

    }

    public static boolean informationUsers(String login, String password, String confirmPassword){
        boolean valid = false;
        try {
             valid = checkValidation(login)
                    && checkValidation(password)
                    && checkLengthLogin(login)
                    && checkLengthPassword(password)
                    && checkEqualityPassword(password, confirmPassword);
        }
        catch (WrongLoginException e) {
            System.out.println("Некорректный логин: " + e.getMessage());
        } catch (WrongPasswordException e){
            System.out.println("Некорректный пароль: " + e.getMessage());
        }
        return valid;
    }
    public static boolean checkValidation(String checkWord){

        if(checkWord == null){
            System.out.println("Введите данные в поле");
        }
        if(checkWord.matches("\\w+")){
            return true;
        }
        System.out.println("Введены недопустимые символы в" + checkWord);
        return false;
    }
    public static boolean checkLengthLogin(String login){
        if(login.length() > 20){
            throw new WrongLoginException("Слишком длинный логин");
        }
        return true;
    }

    public static boolean checkLengthPassword (String password){
        if(password.length() < 20){
            return true;
        }
        throw new WrongPasswordException("Слишком длинный пароль");
    }
    public static boolean  checkEqualityPassword(String password, String confirmPassword){
        if(password.equals(confirmPassword)){
            return true;
        } throw new WrongPasswordException("Пароли не совпадают. Попробуйте еще раз");
    }

}