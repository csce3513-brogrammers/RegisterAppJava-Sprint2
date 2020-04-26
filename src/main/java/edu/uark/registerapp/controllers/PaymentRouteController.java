 package edu.uark.registerapp.controllers;

 import java.util.Map;
 import java.util.Optional;

 import javax.servlet.http.HttpServletRequest;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.MediaType;
 import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestMethod;
 import org.springframework.web.bind.annotation.RequestParam;
 import org.springframework.web.servlet.ModelAndView;

 import edu.uark.registerapp.controllers.enums.QueryParameterNames;
 import edu.uark.registerapp.controllers.enums.ViewModelNames;
 import edu.uark.registerapp.controllers.enums.ViewNames;
 import edu.uark.registerapp.models.entities.ActiveUserEntity;

 @Controller
 @RequestMapping(value = "/payment")
 public class PaymentRouteController extends BaseRouteController {
     @RequestMapping(method = RequestMethod.GET)
     public ModelAndView showPaymentPage( 
         @RequestParam final Map<String, String> queryParameters) {

        ModelAndView modelAndView = 
            this.setErrorMessageFromQueryString(
                new ModelAndView(
                    ViewNames.PAYMENT_PAGE.getViewName()), 
                    queryParameters);

        return modelAndView;

     @RequestMapping(method = RequestMethod.POST)
     public ModelAndView ShowTxnSummary() {

        return new ModelAndView(ViewNames.TXN_SUMMARY.getViewName());
     }

        return modelAndView;
    }
}
