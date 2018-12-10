var config={
		"protocol" : "http",
		"port" : "2222",
		"domain" : "localhost",
		"project" : "PowerBiLicense"
}

function getURI(){
		return config.protocol +"://"+ config.domain +":"+ config.port +"/"+ config.project +"/api/" ;
}