<%@ include file="/WEB-INF/jsp/include.jsp" %>

<html>
<head>
  <title><fmt:message key="appTitle"/></title>
  <style>
    .error { color: red; }
  </style>  
  
  <style type="text/css">
      html { height: 100% }
      body { height: 100%; margin: 0px; padding: 0px }
      #map_canvas { height: 100%; width: 100%; }
    </style>
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false">
    </script>
    
    <script type="text/javascript">
function showLocation(position) {
  var latitude = position.coords.latitude;
  var longitude = position.coords.longitude;
  alert("Latitude : " + latitude + " Longitude: " + longitude);
  
  
  var myLatlng = new google.maps.LatLng(latitude, longitude);
  
  var myOptions = {
      zoom: 8,
      center: myLatlng,
      mapTypeId: google.maps.MapTypeId.ROADMAP
  };
  
  var map = new google.maps.Map(document.getElementById("map_canvas"),myOptions);
  
  // TODO 3: Replace xxxxxx to get the accuracy of our location
  var marker = new google.maps.Marker({
      position: myLatlng, 
      map: map, 
      title: 'Your Phone is Here!'
      title:"Accuracy of " + pos.coords.accuracy + " meters"
  });
  
  
}

function errorHandler(err) {
  if(err.code == 1) {
    alert("Error: Access is denied!");
  }else if( err.code == 2) {
    alert("Error: Position is unavailable!");
  }
}
function getLocation(){

   if(navigator.geolocation){
      // timeout at 60000 milliseconds (60 seconds)
      var options = {timeout:60000};
      navigator.geolocation.getCurrentPosition(showLocation, 
                                               errorHandler,
                                               options);
   }else{
      alert("Sorry, browser does not support geolocation!");
   }
   
// When the window has finished to load, call the getLocation function
   window.addEventListener("load", getLocation, true);
}
</script>
  
</head>
<body>
<h1 align="center"><fmt:message key="messagePage.heading"/></h1>
<form:form method="post" commandName="message">
  <table align="center" width="70%" bgcolor="#D8BFD8" border="0" cellspacing="0" cellpadding="5">    
    <c:if test="${model.messages !=null}">
    <c:forEach items="${model.messages}" var="prod">
    <tr>
        <td align="right" width="50%">
           	 <c:out value="${prod.dateReceived}"/>&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;
        </td>
        <td align="left"  width="50%">
        <c:out value="${prod.message}"/>
        </td>
        <td>
        <button type="button" onclick="getLocation()" value="Map">Map </button>   
        </td>
   	 </tr> 
    </c:forEach>
    </c:if>
    <c:if test="${empty model.messages}">
    <tr>
        <td align="center" width="100%" style="color: #0000FF; font-size: 20pt">
       <b> Sorry !!! No Messages Received !!!</b>
        </td>
        
    </tr> 
    
    </c:if>
    <br>
    <br>
    <tr>
    <td width="100%" colspan=2 align="center" style="color: #008080; font-size: 18pt">
    <a href="login.htm">Logout</a>
    </td>
    </tr>
  </table>
<div id="map_canvas" style="width: 50%; height: 50%"></div>
</form:form>

</body>
</html>