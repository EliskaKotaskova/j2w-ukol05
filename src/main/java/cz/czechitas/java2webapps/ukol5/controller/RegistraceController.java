package cz.czechitas.java2webapps.ukol5.controller;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

/**
 * Kontroler obsluhující registraci účastníků dětského tábora.
 */
@Controller
@RequestMapping("/")
public class RegistraceController {
  private final Random random = new Random();

  @GetMapping("")
  public ModelAndView index() {
    ModelAndView modelAndView = new ModelAndView("/formular");
    modelAndView.addObject("form", new RegistraceForm());
    return modelAndView;
  }

  @PostMapping("")
  public Object form(@ModelAttribute("form") @Valid RegistraceForm form, BindingResult bindingResult) throws ParseException {

    if (bindingResult.hasErrors()) {
      return "/formular";
    }

    if (form.getSporty() == null ||form.getSporty().size() < 2) {
      bindingResult.rejectValue("sporty", "", "To by nešlo. Musí být vybrané minimálně 2 sporty.");
      return "/formular";
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate localDate = LocalDate.parse(form.getDatum(), formatter);
    Period period = localDate.until(LocalDate.now());
    int vek = period.getYears();

      if (vek < 9 || vek > 15) {
        bindingResult.rejectValue("datum", "", "To by nešlo. Účastník musí být ve věku 9 - 15 let.");
        return "/formular";
      }


    return new ModelAndView("/zaregistrovano")
            .addObject("kod", Math.abs(random.nextInt()))
            .addObject("email", form.getEmail())
            .addObject("jmeno", form.getJmeno())
            .addObject("prijmeni", form.getPrijmeni())
            .addObject("datum", form.getDatum())
            .addObject("pohlavi", form.getPohlavi())
            .addObject("telefon", form.getTelefon())
            .addObject("turnus", form.getTurnus())
            .addObject("sporty", form.getSporty());


  }

}
