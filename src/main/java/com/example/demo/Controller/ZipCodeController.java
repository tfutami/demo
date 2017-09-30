package com.example.demo.Controller;

import com.example.demo.Service.ZipCodeService;
import com.example.demo.dto.ZipCodeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class ZipCodeController {

    @Autowired
    ZipCodeService zpcService;

    @RequestMapping("/zipcode")
    public String zipcodeForm(HttpSession session, Model model){
        return "zipcode";
    }

    @RequestMapping(value="/zipcode/confirm", method = RequestMethod.POST)
    public String zipcodeConfirm(HttpSession session, Model model,
                                 @RequestParam("/zipcode") String zipcode){
        if (zipcode == null || zipcode.equals("")){
            model.addAttribute("errorMessage", "郵便番号を入力してください。");
            return zipcodeForm(session, model);
        }

        ZipCodeDto zipCodeDto = zpcService.service(zipcode);
        model.addAttribute("zipcodeList", zipCodeDto.getResults());
        return "zipcode-confirm";

    }

}
