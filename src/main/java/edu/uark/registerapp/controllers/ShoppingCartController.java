package edu.uark.registerapp.controllers;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.uark.registerapp.commands.products.ProductQuery;
import edu.uark.registerapp.controllers.enums.ViewModelNames;
import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.models.api.Product;
import edu.uark.registerapp.models.entities.ActiveUserEntity;
import edu.uark.registerapp.models.enums.EmployeeClassification;


@Controller
@RequestMapping(value = "/cart")
public class ShoppingCartController extends BaseRouteController {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView start(
		@RequestParam final Map<String, String> queryParameters,
		final HttpServletRequest request
	) {
		final Optional<ActiveUserEntity> activeUserEntity =
			this.getCurrentUser(request);
		if (!activeUserEntity.isPresent()) {
			return this.buildInvalidSessionResponse();
		} else if (!this.isElevatedUser(activeUserEntity.get())) {
			return this.buildNoPermissionsResponse(
				ViewNames.PRODUCT_LISTING.getRoute());
		}

		final ModelAndView modelAndView =
			this.setErrorMessageFromQueryString(
				new ModelAndView(ViewNames.PRODUCT_DETAIL.getViewName()),
				queryParameters);

		modelAndView.addObject(
			ViewModelNames.IS_ELEVATED_USER.getValue(),
			true);
		modelAndView.addObject(
			ViewModelNames.PRODUCT.getValue(),
			(new Product()).setLookupCode(StringUtils.EMPTY).setCount(0));

		return modelAndView;
	}

    //This is a method for adding a product to the cart
    //If the product is in the cart, add more
    //If the product is not in the cart, add to cart
	@RequestMapping()
	public ModelAndView add() {
		return (new ModelAndView());
	}

    //This is the method for removing a product from the cart
    //If the product is in the cart, remove it
    //User should not be able to remove an item that doesn't exist

	/*@RequestMapping()
	public ModelAndView remove() {
		return (new ModelAndView());
    }*/
    
    //This is the method for empyting the shopping cart
    //Removes all products from the cart
    //Should not be able to empty an empty carts

    /*@RequestMapping()
    public ModelAndView cancel() {
        return (new ModelAndView());
    }*/

    //This is the method to print a summary of the transaction
    //Displays each product in shopping cart along with price/quantity/total quantity/tostal price

    /*@RequestMapping()
    public ModelAndView summary() {
        return (new ModelAndView());
    }*/

}