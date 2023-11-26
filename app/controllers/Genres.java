package controllers;

import play.mvc.Controller;
import play.mvc.With;

@Check("admin")
@With(Secure.class)
public class Genres extends CRUD {
    
}