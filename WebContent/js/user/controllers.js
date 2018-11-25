app.controller('pbilicensecontroller',['$scope','$http',function($scope,$http){
	$scope.user={};
	$scope.user.aliasName=null;
	$scope.user.emailAddress=null;
	$scope.user.typeOfLicense=null;
	$scope.aliasName=null;
	$scope.domainName=null;
	$scope.showReconfirm=false;
	
	$scope.validateInputs=function(){
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
	};
	
	$scope.porvideLicense=function(){
		$scope.user.aliasName=$scope.aliasName;
		$scope.user.emailAddress=$scope.aliasName+'@'+$scope.domainName+'.wal-mart.com';
		var jsonFormat=JSON.stringify($scope.user);
		alert(jsonFormat);
		$http.post(getURI()+'PbiLicense/ProvideLicese',jsonFormat).then(function(response){
			$scope.returneMessage=response.data.message;
		},function(response){
			$scope.returneMessage=response.data.message;
		});
	};
	
	$scope.reConfirm=function(){
		$scope.showReconfirm=true;
	};
	
	}]);
