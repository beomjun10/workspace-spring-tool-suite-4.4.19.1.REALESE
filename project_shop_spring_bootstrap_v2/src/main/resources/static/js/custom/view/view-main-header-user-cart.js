/**
 * 
 */
export const common_header_user_cart_view=function(responseJsonObject={}) {
	
	let htmlTemplate =
		`<div class="inner">
					<div class="tools">
						<div class="search">
							<i class="icon-search"></i>
						</div>
						<div class="account">
							<a href="account-orders.html"></a><i class="icon-head"></i>
							<ul class="toolbar-dropdown">
								<li class="sub-menu-user">
									<div class="user-ava">
										<img src="img/account/user-ava-sm.jpg" alt="Daniel Adams">
									</div>
									<div class="user-info">
										<h6 class="user-name">Daniel Adams</h6>
										<span class="text-xs text-muted">290 Reward points</span>
									</div>
								</li>
								<li><a href="account-profile.html">My Profile</a></li>
								<li><a href="account-orders.html">Orders List</a></li>
								<li><a href="account-wishlist.html">Wishlist</a></li>
								<li class="sub-menu-separator"></li>
								<li><a href="#"> <i class="icon-unlock"></i>Logout
								</a></li>
							</ul>
						</div>
						<div class="cart">
							<a href="cart.html"></a><i class="icon-bag"></i><span class="count">3</span><span class="subtotal">$289.68</span>
							<div class="toolbar-dropdown">
								<div class="dropdown-product-item">
									<span class="dropdown-product-remove"><i class="icon-cross"></i></span><a class="dropdown-product-thumb" href="shop-single.html"><img src="img/cart-dropdown/01.jpg" alt="Product"></a>
									<div class="dropdown-product-info">
										<a class="dropdown-product-title" href="shop-single.html">Unionbay
											Park</a><span class="dropdown-product-details">1 x $43.90</span>
									</div>
								</div>
								<div class="dropdown-product-item">
									<span class="dropdown-product-remove"><i class="icon-cross"></i></span><a class="dropdown-product-thumb" href="shop-single.html"><img src="img/cart-dropdown/02.jpg" alt="Product"></a>
									<div class="dropdown-product-info">
										<a class="dropdown-product-title" href="shop-single.html">Daily
											Fabric Cap</a><span class="dropdown-product-details">2 x
											$24.89</span>
									</div>
								</div>
								<div class="dropdown-product-item">
									<span class="dropdown-product-remove"><i class="icon-cross"></i></span><a class="dropdown-product-thumb" href="shop-single.html"><img src="img/cart-dropdown/03.jpg" alt="Product"></a>
									<div class="dropdown-product-info">
										<a class="dropdown-product-title" href="shop-single.html">Haan
											Crossbody</a><span class="dropdown-product-details">1 x
											$200.00</span>
									</div>
								</div>
								<div class="toolbar-dropdown-group">
									<div class="column">
										<span class="text-lg">Total:</span>
									</div>
									<div class="column text-right">
										<span class="text-lg text-medium">$289.68&nbsp;</span>
									</div>
								</div>
								<div class="toolbar-dropdown-group">
									<div class="column">
										<a class="btn btn-sm btn-block btn-secondary" href="cart.html">View
											Cart</a>
									</div>
									<div class="column">
										<a class="btn btn-sm btn-block btn-success" href="checkout-address.html">Checkout</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
		 
      `;
	let bindTemplate=Handlebars.compile(htmlTemplate);
	let resultTemplate=bindTemplate(responseJsonObject);
	return resultTemplate;
}







