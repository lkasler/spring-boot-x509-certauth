package hu.sbspsystems.prototype.cert.certdemo.rest;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestCertDemo {

    private static final String template = "Cert demo, Hi %s!";

    @RequestMapping("/cert")
    public String certDemo(@RequestParam(value="name", defaultValue="World") String name) {
        return String.format(template, name);
    }

}
