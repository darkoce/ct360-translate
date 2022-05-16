package com.zepp.translate.bootstrap;

import com.zepp.translate.config.SecurityUtility;
import com.zepp.translate.entities.LanguageTranslate;
import com.zepp.translate.entities.user.User;
import com.zepp.translate.entities.user.security.Role;
import com.zepp.translate.entities.user.security.UserRole;
import com.zepp.translate.repositories.LanguageTranslateRepository;
import com.zepp.translate.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
@Profile("test")
public class DekelPrcBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final UserService userService;
    private final LanguageTranslateRepository languageTranslateRepository;

    @Autowired
    public DekelPrcBootstrap(UserService userService, LanguageTranslateRepository languageTranslateRepository) {
        this.userService = userService;
        this.languageTranslateRepository = languageTranslateRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            getUsers();
            getLanguageTranslate();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Nisu kreirani useri i language translate");
        }
    }

    private void getUsers() throws Exception {
        Role role2 = new Role();
        role2.setName("ROLE_USER");

        User user1 = new User();
        user1.setFirstName("Vasa");
        user1.setLastName("Vasić");
        user1.setUsername("vasa");
        user1.setPassword(SecurityUtility.passwordEncoder().encode("vasa"));
        user1.setEmail("vasa.vasic@test.com");
        Set<UserRole> userRoles = new HashSet<>();
        Role role1= new Role();
        role1.setName("ROLE_ADMIN");

        User user2 = new User();
        user2.setFirstName("Darko");
        user2.setLastName("Cep");
        user2.setUsername("dare");
        user2.setPassword(SecurityUtility.passwordEncoder().encode("dare"));
        user2.setEmail("dare@test.com");
        Set<UserRole> userRolesKiza = new HashSet<>();



        userRoles.add(new UserRole(user1, role1));

        userRolesKiza.add(new UserRole(user2, role2));

        userService.createUser(user1, userRoles);

        userService.createUser(user2, userRolesKiza);
    }

    private void getLanguageTranslate() {
        LanguageTranslate enToBg = new LanguageTranslate();
        enToBg.setTarget("bg");
        enToBg.setTargetLangName("Bugarski");
        enToBg.setOutput("Здравей свят");

        LanguageTranslate enToIt = new LanguageTranslate();
        enToIt.setTarget("it");
        enToIt.setTargetLangName("Italijanski");
        enToIt.setOutput("Ciao mondo");

        LanguageTranslate enToEs = new LanguageTranslate();
        enToEs.setTarget("es");
        enToEs.setTargetLangName("Španski");
        enToEs.setOutput("Hola Mundo");

        LanguageTranslate enTode = new LanguageTranslate();
        enTode.setTarget("de");
        enTode.setTargetLangName("Nemački");
        enTode.setOutput("Hallo Welt");

        LanguageTranslate enToSr = new LanguageTranslate();
        enToSr.setTarget("sr");
        enToSr.setTargetLangName("Srpski");
        enToSr.setOutput("Zdravo Svete");

        LanguageTranslate enToRu = new LanguageTranslate();
        enToRu.setTarget("ru");
        enToRu.setTargetLangName("Ruski");
        enToRu.setOutput("Привет, мир");

        LanguageTranslate enToHu = new LanguageTranslate();
        enToHu.setTarget("hu");
        enToHu.setTargetLangName("Mađarski");
        enToHu.setOutput("Helló Világ");

        LanguageTranslate enToFr = new LanguageTranslate();
        enToFr.setTarget("fr");
        enToFr.setTargetLangName("Francuski");
        enToFr.setOutput("Bonjour le monde");

        LanguageTranslate enToNl = new LanguageTranslate();
        enToNl.setTarget("nl");
        enToNl.setTargetLangName("Holandski");
        enToNl.setOutput("Hallo Wereld");

        LanguageTranslate enToRo = new LanguageTranslate();
        enToRo.setTarget("ro");
        enToRo.setTargetLangName("Rumunski");
        enToRo.setOutput("Salut Lume");

        languageTranslateRepository.save(enToBg);
        languageTranslateRepository.save(enToIt);
        languageTranslateRepository.save(enToEs);
        languageTranslateRepository.save(enTode);
        languageTranslateRepository.save(enToSr);
        languageTranslateRepository.save(enToRu);
        languageTranslateRepository.save(enToHu);
        languageTranslateRepository.save(enToFr);
        languageTranslateRepository.save(enToNl);
        languageTranslateRepository.save(enToRo);
    }
}
