var app = angular.module('login',[]);
var headUrl = "/rest/login/";
app.controller('validationLogin',function($scope,$http,$location,$window){
	$scope.submitLoginForm = function(){
	    var url = headUrl + "validation";
	    var config = {
	    		headers : {
	    			'Accept' : 'text/plain'
	    		}
	    };
	    var data = {
	    		user : $scope.user,
	    		pass : $scope.pass
	    };
	    $http.post(url, data, config).then(function (response) {
	    	 var values = response.data;
	    	 if(values["isValid"]==true){
	    		 $window.location.href = values["url"];
	    	 }else{
	    		 $scope.user = "";
	    		 $scope.pass = "";
	    	 }
	      }, function error(response) {
	         $scope.postResultMessage = "Error with status: " +  response.statusText;
	      });	  
	}
});

app.controller('newRegister',function($scope,$http){
		$scope.submitRegisterForm = function(){
			var url = headUrl + "requestRegister";
			var config = {
		    		headers : {
		    			'Accept' : 'text/plain'
		    		}
		    };
			var data = {
					registerUserName : $scope.registerUserName,
					registerUserId : $scope.registerUserId,
					registerUserMail : $scope.registerUserMail,
					registerUserPhone : $scope.registerUserPhone,
					registerUserPassword : $scope.registerUserPassword,
					confirmUserRegisterPassword :$scope.confirmUserRegisterPassword,
		    };
			
			$http.post(url,data,config).then(
			    function(response){
			    	alert(response.data);
			    },
			    function error(response){
			    	alert(response.statusText);
			    }
			);
			
		}
});

app.controller('forgotPassword', function($scope,$http){
	
	$scope.submitForgotPasswordForm = function(){
		var url = headUrl + "requestForgot";
		 var config = {
		    		headers : {
		    			'Accept' : 'text/plain'
		    		}
		    };
		    var data = {
		    		userId : $scope.userId,
		    };
		 
		 
		 $http.post(url,data,config).then(
		   function(response){
			   alert(response.responseData);
		   },
		   
		   function error(response){
			   alert(response.statusText);
		   }
				 
		 );
		
	}
	
});


