package controllers;

import java.util.List;

import models.Usuario;

public class Usuarios extends Application {
	public static void list(String search, Integer size, Integer page) {
        List<Usuario> docen = null;
        page = page != null ? page : 1;
        if(search.trim().length() == 0) {
            docen = Usuario.all().fetch(page, size);
        } else {
            search = search.toLowerCase();
            docen = Usuario.find("lower(nombre) like ?1 OR lower(cedula) like ?2 ", "%"+search+"%", "%"+search+"%").fetch(page, size);
        }
        render(docen, search, size, page);
        System.out.println("Si se llama a la funcion");
    }
}
