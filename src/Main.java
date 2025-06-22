public class Main {
    public static void main(String[] args) {
        Variant4.validateCredentials("user12345", "abc123()@#$", "abc123()@#$"); // Валидно
        Variant4.validateCredentials("user123", "abc123()@#$", "abc123()@#$"); // Ошибка: логин короче 8
        Variant4.validateCredentials("user12345", "abc123()@#$", "abc123()@#"); // Ошибка: пароли не совпадают
        Variant4.validateCredentials("user12345", "abc123()!", "abc123()!"); // Ошибка: недопустимый символ
        Variant4.validateCredentials("user12345", "abc123()@", "abc123()@"); // Ошибка: мало специальных символов
        Variant4.validateCredentials("user12345", "aaa123()@#$", "aaa123()@#$"); // Ошибка: три 'a' подряд
    }
}