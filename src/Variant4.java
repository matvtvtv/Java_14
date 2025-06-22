public class Variant4 {
    public static void validateCredentials(String login, String password, String confirmPassword) {
        try {
            // Проверка длины
            if (login.length() < 8 || login.length() > 20) {
                throw new PasswordException("Логин должен быть длиной от 8 до 20 символов");
            }
            if (password.length() < 8 || password.length() > 20) {
                throw new PasswordException("Пароль должен быть длиной от 8 до 20 символов");
            }

            // Проверка равенства паролей
            if (!password.equals(confirmPassword)) {
                throw new PasswordException("Пароль и подтверждение пароля не совпадают");
            }

            // Проверка допустимых символов в пароле
            if (!password.matches("^[a-zA-Z0-9()#@$]+$")) {
                throw new PasswordException("Пароль должен содержать только латинские буквы, цифры, скобки и знаки #, @, $");
            }

            // Проверка количества каждого вида символов
            int letterCount = 0, digitCount = 0, bracketCount = 0, specialCount = 0;
            for (char c : password.toCharArray()) {
                if (Character.isLetter(c)) letterCount++;
                else if (Character.isDigit(c)) digitCount++;
                else if (c == '(' || c == ')') bracketCount++;
                else if (c == '#' || c == '@' || c == '$') specialCount++;
            }
            if (letterCount < 3) {
                throw new PasswordException("Пароль должен содержать не менее 3 букв");
            }
            if (digitCount < 3) {
                throw new PasswordException("Пароль должен содержать не менее 3 цифр");
            }
            if (bracketCount < 3) {
                throw new PasswordException("Пароль должен содержать не менее 3 скобок");
            }
            if (specialCount < 3) {
                throw new PasswordException("Пароль должен содержать не менее 3 специальных символов (#, @, $)");
            }

            // Проверка на отсутствие трех одинаковых символов подряд
            for (int i = 0; i < password.length() - 2; i++) {
                if (password.charAt(i) == password.charAt(i + 1) &&
                        password.charAt(i + 1) == password.charAt(i + 2)) {
                    throw new PasswordException("Пароль не должен содержать 3 одинаковых символа подряд");
                }
            }

            System.out.println("Логин и пароль валидны");

        } catch (PasswordException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Ошибка: Один из параметров null");
        } finally {
            System.out.println("Проверка завершена");
        }
    }
}