package controllers;

import java.util.List;

import models.Episode;
import models.Karya;
import play.db.jpa.JPABase;
import play.db.jpa.GenericModel.JPAQuery;
import play.mvc.Controller;

public class EpisodeApplication extends Controller {
    public static void create(Long id) {
        Karya karya = Karya.findById(id);
        render(karya);
    }

    public static void save(Episode episode, Long karya_id) {
        episode.save();
        Middleware.checkKarya(Security.session.get("username"), episode.karya);
        KaryaApplication.show(episode.karya.id);
    }

    public static void show(Long id) {
        Episode episode = Episode.findById(id);
        Karya karya = Karya.findById(episode.karya.id);
        render(episode, karya);
    }

    public static void edit(Long id) {
        Episode episode = Episode.findById(id);
        Karya karya = Karya.findById(episode.karya.id);
        Middleware.checkKarya(Security.session.get("username"), karya);
        render(karya, episode);
    }

    public static void delete(Long id) {
        Episode episode = Episode.findById(id);
        Middleware.checkKarya(Security.session.get("username"), episode.karya);
        episode.delete();
        KaryaApplication.show(episode.karya.id);
    }
}