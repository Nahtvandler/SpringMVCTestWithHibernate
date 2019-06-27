package spring.controller;

import spring.hibernate.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.FileWriteHelper;
import spring.service.HibernateService;
import spring.JsonDTO;
import spring.ListTestPojo.ListElem;
import spring.ListTestPojo.ListModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private FileWriteHelper fileWriteHelper;

    @Autowired
    private HibernateService hibernateService;

    public MainController(FileWriteHelper fileWriteHelper, HibernateService hibernateService) {
        this.fileWriteHelper = fileWriteHelper;
        this.hibernateService = hibernateService;
    }

//    @RequestMapping(value = "/")
//    private String main() {
//        return "index";
//    }

    @RequestMapping("/allCompany")
    private @ResponseBody String getAllCompany() {
        List<Company> companyList = hibernateService.getAllCompany();

        return companyList.toString();
    }

    @RequestMapping("/")
    private ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("jsonDTO", new JsonDTO());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/list")
    private ModelAndView list() {

        List<ListElem> list = new ArrayList<>();
        list.add(new ListElem("name 1"));
        list.add(new ListElem("name 2"));
        list.add(new ListElem("name 3"));


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ListModel", new ListModel(list));
        modelAndView.setViewName("indexListTest");
        return modelAndView;
    }

    @RequestMapping("/listGet")
    private @ResponseBody String listget(@RequestParam("elemName") String name) {
        return "Выбран элемент с именем: "+name;
    }

    @RequestMapping("/saveSomething")
    private @ResponseBody String testJson(@RequestParam("Name") String name, @RequestParam("Content") String content) {
        System.out.println("Param from request name: " + name + ", content: " + content);
        return HttpStatus.OK.toString();
    }

    @RequestMapping("/json")
    private @ResponseBody String json(@RequestBody JsonDTO jsonDTO) {
        System.out.println("Json from request name: " + jsonDTO.getName() + ", content: " + jsonDTO.getContent());

        try {
            fileWriteHelper.createTemporaryFile(jsonDTO.getName(), jsonDTO.getContent());
        } catch (IOException e) {
            return HttpStatus.INTERNAL_SERVER_ERROR.toString();
        }

        return HttpStatus.OK.toString();
    }

    @RequestMapping("/model")
    private @ResponseBody String model(@ModelAttribute("jsonDTO") JsonDTO jsonDTO) {
        System.out.println("Json from request name: " + jsonDTO.getName() + ", content: " + jsonDTO.getContent());
        return HttpStatus.OK.toString();
    }

    @RequestMapping("/config")
    private @ResponseBody String writeToConfig() {
        try {
            FileWriteHelper.writeToConfig("lksjdf");
        } catch (IOException e) {
            System.out.println(e);
            return HttpStatus.INTERNAL_SERVER_ERROR.toString();
        }
        return HttpStatus.OK.toString();
    }

    @RequestMapping("/createTmp")
    private @ResponseBody String createTmpFile(@RequestParam("content") String content) {
        try {
            fileWriteHelper.createTemporaryFile("test_file", ".tmp", content);
        } catch (IOException e) {
            System.out.println("Error at create tmp file " + e);
            return HttpStatus.INTERNAL_SERVER_ERROR.toString();
        }
        return HttpStatus.OK.toString();
    }



    @RequestMapping(value = "/returnCode")
    private @ResponseBody String checkStatuses(@RequestParam("code") int code) {
        System.out.println("code from request = " + code);
        return HttpStatus.valueOf(code).toString();
    }
}
