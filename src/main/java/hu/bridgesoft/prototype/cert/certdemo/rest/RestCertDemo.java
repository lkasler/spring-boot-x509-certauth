package hu.bridgesoft.prototype.cert.certdemo.rest;


import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestCertDemo {

    private static final String template = "Cert demo using cert user: %s, Hi %s!";

    @RequestMapping("/cert")
    public String certDemo(@RequestParam(value="name", defaultValue="World") String name) {
        String currentUserName = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }
        return String.format(template, currentUserName, name);
    }

}
