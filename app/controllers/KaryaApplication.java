package controllers;

import java.util.List;

import models.Episode;
import models.Genre;
import models.Karya;
import models.User;
import play.db.jpa.JPABase;
import play.db.jpa.GenericModel.JPAQuery;
import play.mvc.Controller;
import play.mvc.With;

public class KaryaApplication extends Controller {
    public static void index() {
        List<Karya> karyas = Karya.findAll();
        render(karyas);
    }

    public static void create() {
        if (!Security.isLoggedIn()) redirect("/login");;
        List<JPABase> genres = Genre.findAll();
        User user = User.find("username=?1", Security.connected()).first();
        render(genres, user);
    }

    public static void save(Karya karya) {
        Middleware.checkKarya(Security.session.get("username"), karya);
        karya.save();
        show(karya.getId());
    }

    public static void show(Long id) {
        Karya karya = Karya.find("id=?1", id).first();
        String username = Security.session.get("username");
        User user = User.find("username=?1", username).first();
        // JPAQuery episodes = Episode.find("karya_id=?1", karya.id);
        List<Episode> episodes = Episode.find("karya_id=?1", karya.id).fetch();

        render(karya, user, episodes);
    }

    public static void edit(Long id) {
        Karya karya = Karya.find("id=?1", id).first();
        Middleware.checkKarya(Security.session.get("username"), karya);
        List<JPABase> genres = Genre.findAll(); 
        render(karya, genres);
    }

    public static void delete(Long id) {
        Karya karya = Karya.findById(id);
        System.out.println("karya_id: " + karya.id);
        Middleware.checkKarya(Security.session.get("username"), karya);
        Episode.delete("karya_id=?1", karya.id);
        karya.delete();
        index();
    }

    

}