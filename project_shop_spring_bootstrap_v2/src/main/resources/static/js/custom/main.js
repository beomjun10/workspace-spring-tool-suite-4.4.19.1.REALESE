import { common_header_user_cart_view } from './view/view-main-header-user-cart.js';


let hash = window.location.hash
let path = hash.substring(1);
let html = '';

/*
초기실행메쏘드
*/
export function init() {
	registEvent();
	navigate();
	common_header_user_cart();
}

/*
이벤트등록
*/
function registEvent() {
	
	$(window).on('hashchange', function(e) {
		//alert('hashchange event:' + e);
		hash = window.location.hash
		path = hash.substring(1);
		navigate();
	});
	$(document).on('click', function(e) {
		if ($(e.target).attr('data-navigate')) {
			//alert('click event --> hash변경:' + $(e.target).attr('data-navigate'));
		}
	});

}

/*
	이벤트발생시 처리메쏘드
*/
function navigate() {
	if (path == '/cart') {
		alert('cart page로이동[페이지요청]');
	}
}
/*
유저카트정보갱신메쏘드
*/
function common_header_user_cart() {
	html = common_header_user_cart_view();
	//$('.toolbar').html(html);
}

init();


export {common_header_user_cart}





