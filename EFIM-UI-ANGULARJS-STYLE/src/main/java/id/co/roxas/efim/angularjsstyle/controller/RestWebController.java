package id.co.roxas.efim.angularjsstyle.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import id.co.roxas.efim.angularjsstyle.model.Customer;

@RestController
public class RestWebController {
  
  List<Customer> cust = new ArrayList<Customer>();
  
  @RequestMapping(value = "/getallcustomer", method = RequestMethod.GET)
  public List<Customer> getResource(){
	  System.out.println("rm : /getAllCustomer" );
      return cust;
  }
  
  @RequestMapping(value="/postcustomer", method=RequestMethod.POST)
  public String postCustomer(@RequestBody Customer customer){
      System.out.println("rm : /postCustomer");
	cust.add(customer);
    return "Sucessful!";
  }
}
