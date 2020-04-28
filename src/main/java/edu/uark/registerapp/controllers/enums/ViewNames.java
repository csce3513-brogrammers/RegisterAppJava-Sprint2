package edu.uark.registerapp.controllers.enums;

public enum ViewNames {
	SIGN_IN("signIn", "/"),
	MAIN_MENU("mainMenu"),
	CART("cart"),
	PRODUCT_DETAIL("productDetail"),
	EMPLOYEE_DETAIL("employeeDetail"),
	PRODUCT_LISTING("productListing"),
	SHOPPING_CART("shoppingCart"),
	PAYMENT_PAGE("payment"),
	TXN_SUMMARY("txnSummary"),
	ADD_ITEM("addItem");
	
	public String getRoute() {
		return this.route;
	}
	public String getViewName() {
		return this.viewName;
	}

	private String route;
	private String viewName;

	private ViewNames(final String viewName) {
		this(viewName, "/".concat(viewName));
	}

	private ViewNames(final String viewName, final String route) {
		this.route = route;
		this.viewName = viewName;
	}
}
