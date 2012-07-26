window.com_morevaadin_vaadin7_html_js_JavascriptTooltipExtension = function() {

	this.attach = function(options) {

		var connectorId = this.getParentId();

		var element = this.getElement(connectorId);

		var a = element.childNodes[0]; 
		
		a.rel = "tooltip";
		a.title = this.getState().display;

		$(a).tooltip();
	}
}