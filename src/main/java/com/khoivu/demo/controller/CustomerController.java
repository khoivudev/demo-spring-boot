package com.khoivu.demo.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.khoivu.demo.model.Customer;

import jakarta.validation.Valid;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
  @InitBinder 
  public void initBinder(WebDataBinder dataBinder) {
    StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
    dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
  }

  @GetMapping("/showCustomerForm")
  public String showForm(Model model) {
    Customer theCustomer = new Customer();
    model.addAttribute("customer", theCustomer);
    return "customer-form";
  }

  @PostMapping("/processCustomerForm")
  public String processForm(
                  @Valid @ModelAttribute("customer") Customer theCustomer, 
                  BindingResult theBindingResult) {
    if(theBindingResult.hasErrors()) {
      return "customer-form";
    } else {
      return "customer-confirmation";
    }
  }
  
}
