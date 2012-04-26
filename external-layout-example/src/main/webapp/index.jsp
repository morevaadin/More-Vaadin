<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Vaadin external layout example</title>
<link rel="stylesheet" type="text/css" href="style/style.css">
<script type="text/javascript">
	var vaadin = {
		vaadinConfigurations : {
			'extlayout' : {
				appUri : '<%= request.getContextPath() %>/app',
				themeUri: '<%= request.getContextPath() %>/VAADIN/themes/reindeer',
				versionInfo :  {
			          vaadinVersion: "6.7.7"
				}
			}
		}
	};
</script>
<script language='javascript' src='<%= request.getContextPath() %>/VAADIN/widgetsets/com.morevaadin.vaadin.externallayout.widgetset.ELayoutExampleWidgetset/com.morevaadin.vaadin.externallayout.widgetset.ELayoutExampleWidgetset.nocache.js'></script>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/VAADIN/themes/reindeer/styles.css"/></head>
<body>
	<iframe tabIndex="-1" id="__gwt_historyFrame" style="position:absolute;width:0;height:0;border:0;overflow:hidden;" src="javascript:false"></iframe>
	<div id="menu"></div>
	<h1>Welcome to Vaadin external layout example</h1>
	<div id="extlayout"></div>
</body>
</html>