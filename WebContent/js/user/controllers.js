app.controller('pbilicensecontroller',['$scope','$http',function($scope,$http){
	$scope.user={};
	$scope.user.aliasName=null;
	$scope.user.emailAddress=null;
	$scope.user.typeOfLicense=null;
	$scope.domainName=null;
	$scope.showReconfirm=false;
	$scope.domainNameList=["AR","BR","CA","CAM","CL","CN","EMEA","HOMEOFFICE","IN","JP","MX","PR","UK","US","WMCT","WMSC"];
	$scope.reConfirmedUser={};
	$scope.reConfirmedUser.aliasName=null;
	$scope.reConfirmedUser.emailAddress=null;
	$scope.reConfirmedUser.typeOfLicense=null;
	$scope.reConfirmedDomainName=null;
	
	/*$scope.validateInputs=function(){
		var basicValidateArray=["null","na"];
		var pattern=/[\w]+$/;
		if (basicValidateArray.indexOf($scope.aliasName.toLowerCase())!=-1){
			$scope.returneMessage="Please dont null or NA in input";
		}else{
			if(pattern.test($scope.aliasName) && pattern.test($scope.domainName)){
				$scope.porvideLicense();
			}else{
				$scope.returneMessage="Please enter valid input without special characters";
			};
		};
	};*/
	
	$scope.porvideLicense=function(user){
		var jsonFormat=JSON.stringify(user);
		$http.post(getURI()+'PbiLicense/ProvideLicese',jsonFormat).then(function(response){
			$scope.returneMessage=response.data.message;
		},function(response){
			$scope.returneMessage=response.data.message;
		});
	};
	
	$scope.reConfirmFunction=function(){
		$scope.showReconfirm=true;
	};
	
	$scope.reConfirm=function(){
		if($scope.user.aliasName==$scope.reConfirmedUser.aliasName){
			if($scope.domainName==$scope.reConfirmedDomainName){
				if($scope.user.typeOfLicense==$scope.reConfirmedUser.typeOfLicense){
					$scope.reConfirmedUser.emailAddress=$scope.reConfirmedUser.aliasName+'@'+$scope.reConfirmedDomainName+'.wal-mart.com';
					alert($scope.reConfirmedUser.emailAddress)
					$scope.porvideLicense($scope.reConfirmedUser);
				}else{
					$scope.returneMessage="Missmach in type of license";
				}
			}else{
				$scope.returneMessage="Missmach in domain names";
			}
		}else{
			$scope.returneMessage="Missmach in alias names";
		}
	};
	}]);
