package com.zepp.translate.controllers;

import com.zepp.translate.entities.dtos.LanguageTranslateDto;
import com.zepp.translate.entities.request.LanguageTranslateRequest;
import com.zepp.translate.services.LanguageTranslateService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final String LANG_FORM_URL = "admin/add-lang";
    private LanguageTranslateService languageTranslateService;
    private ModelMapper modelMapper;

    @Autowired
    public AdminController(LanguageTranslateService languageTranslateService, ModelMapper modelMapper) {
        this.languageTranslateService = languageTranslateService;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin-dashboard")
    public String getAdminPage() {
        return "admin/admin-panel";
    }

    @GetMapping("/lang/add")
    public String getAddLangForm(Model model) {
        LanguageTranslateRequest language = new LanguageTranslateRequest();
        model.addAttribute("msg", "");
        model.addAttribute("language", language);
        return "admin/add-lang";
    }

    @PostMapping("/lang/add")
    public String addLang(@ModelAttribute("language") LanguageTranslateDto lang, Model model) {
        List<LanguageTranslateDto> list = languageTranslateService.findAll();
        for(int i = 0; i < list.size(); i++) {
            if(lang.getTargetLangName().equalsIgnoreCase(list.get(i).getTargetLangName()) || lang.getTarget().equalsIgnoreCase(list.get(i).getTarget())) {
                model.addAttribute("msg", "Postoji jezik sa nazivom '" + list.get(i).getTargetLangName() + "'!!!");
                return LANG_FORM_URL;
            }
        }
        lang.setSource("en");
        LanguageTranslateDto dto = languageTranslateService.saveEntity(lang);
        System.out.println(dto);
        return "redirect:/admin/admin-dashboard";
    }
}
