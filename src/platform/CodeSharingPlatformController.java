package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.LinkedList;

@RestController
public class CodeSharingPlatformController {
    @Autowired
    Snipets snipets;

    @GetMapping("/code/{id:\\d+}")
    public ModelAndView getHtmlCode(@PathVariable int id) {
        ModelAndView model = new ModelAndView("index.html");
        Code code = snipets.getCodeById(id - 1);
        model.addObject("code", code);
        return model;
    }
    @PostMapping("/api/code/new")
    public String addSnippet(@RequestBody Code code) {
        code.setDate(LocalDateTime.now());
        snipets.addCode(code);
        String s = String.format("{ \"id\" : \"%d\" }", snipets.getLength());
        return s;
    }

    @GetMapping("/api/code/{id:\\d+}")
    public Code getAPICode(@PathVariable int id) {
        Code code = snipets.getCodeById(id - 1);
        return code;
    }

    @GetMapping("/code/new")
    public ModelAndView editCode() {
        ModelAndView model = new ModelAndView("codenew.html");
        return model;
    }

    @GetMapping("api/code/latest")
    public LinkedList<Code> latestCodeAPI() {
        int n = snipets.getLength();
        LinkedList<Code> list = new LinkedList<>();
        for (int i = n - 1; n >= n - 10; n--) {
            list.add(snipets.getCodeById(i));
        }
        return list;
    }

    @GetMapping("code/latest")
    public ModelAndView latestCodeHtml() {
        ModelAndView model = new ModelAndView("latest.ftlh");
        int n = snipets.getLength();
        LinkedList<Code> list = new LinkedList<>();
        for (int i = n - 1; n >= n - 10; n--) {
            list.add(snipets.getCodeById(i));
        }
        model.addObject("code", list);
        return model;
    }
}
