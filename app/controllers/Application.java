package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.ObjectArrayDeserializer;
import forms.LoginForm;
import forms.SignupForm;
import models.Profile;
import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;


import javax.inject.Inject;

/**
 * Created by lubuntu on 8/21/16.
 */
public class Application extends Controller {
    @Inject
    FormFactory FormFactory;
    @Inject
    ObjectMapper objectMapper;

    public Result signUp() {

        Form<SignupForm> form = FormFactory.form(SignupForm.class).bindFromRequest();
        if (form.hasErrors()) {
            form.data().get("");
            return ok(form.errorsAsJson());
        }

        Profile profile = new Profile(form.data().get("firstName"), form.data().get("lastName"));
        profile.db().save(profile);

        User user = new User(form.data().get("email"),
                form.data().get("password"));
        user.profile = profile;
        profile.db().save(user);
        return ok((JsonNode) objectMapper.valueToTree(user));
    }

    public Result logIn() {
        Form<LoginForm> form = FormFactory.form(LoginForm.class).bindFromRequest();
        if (form.hasErrors()) {
            return ok(form.errorsAsJson());
        }
        return ok();
    }
}
