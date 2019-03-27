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
	    	$scope.redirectToUrl = function(){
	    		$window.location.href = response.data;
	    	}
	      }, function error(response) {
	        $scope.postResultMessage = "Error with status: " +  response.statusText;
	      });
	    
	    $scope.user = "";
	    $scope.pass = "";
	      
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


