package View;

public class ClearScreen {

public static void clear() {
    for (int i = 0; i < 50; i++) {
        System.out.println();
    }
}


    /* public static void clear() {
        String os = System.getProperty("os.name"); // Detecta o sistema operacional

        try {
            if (os.contains("Windows")) {
                // Para Windows, usamos o comando "cls" com "cmd /c"
                Runtime.getRuntime().exec("cmd /c cls");  // Garanta que o comando seja executado corretamente
            } else {
                // Para sistemas Unix-like (Linux/Mac), usamos o comando "clear"
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     */
}
