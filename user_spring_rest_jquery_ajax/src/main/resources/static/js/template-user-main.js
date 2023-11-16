/**
 * 
 */
export function user_main(responseJsonObject = {}) {
	let htmlTemplate =
		`<img src='image/enter.png' width="540" height="350px" style="margin: 10px" />`;
	let bindTemplate=Handlebars.compile(htmlTemplate);
	let resultTemplate=bindTemplate(responseJsonObject);
	return resultTemplate;
}
