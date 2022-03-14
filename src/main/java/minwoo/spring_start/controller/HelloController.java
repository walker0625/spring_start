package minwoo.spring_start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!");
        return "hellopage";
    }

    @GetMapping("/mvc")
    public String mvc(@RequestParam(value = "name", required = false) String name, Model model){
        model.addAttribute("name", name);
        return "mvc";
    }

    @ResponseBody
    @GetMapping("/api")
    public String api(@RequestParam(value = "name", required = false) String name){
        return "api" + name;
    }

    @ResponseBody
    @GetMapping("/api/data")
    public Data apidata(@RequestParam(value = "name") String name, @RequestParam(value = "number") int number){
        Data data = new Data();
        data.setName(name);
        data.setNumber(number);

        return data;
    }

    static class Data {
        private int number;
        private String name;

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
