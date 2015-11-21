package pe.edu.tecsup.model;

import pe.edu.tecsup.R;

public class MenuStaticModel {

    // Metodo que devuelve los contenidos para poder poner en las listas
    public static String[] getText() {
        return new String[]{
                "Cuenta de usuario",
                "Tomar una foto",
                "Salir de sesion"
        };
    }

    // Metodo que devuelve los iconos para poder poner en las listas
    public static  Integer[] getIcons() {
        return new Integer[]{
                R.drawable.user_logo,
                R.drawable.photo_logo,
                R.drawable.logout_logo,
        };
    }
}
