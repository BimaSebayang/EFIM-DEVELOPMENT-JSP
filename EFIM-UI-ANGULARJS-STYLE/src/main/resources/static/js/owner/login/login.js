var app = angular.module('login',[]);

app.controller('validationLogin',function($scope,$http,$location,$window){
	$scope.submitForm = function(){
	    var url = "/rest/login/validation";
	    var config = {
	    		headers : {
	    			'Accept' : 'text/plain'
	    		}
	    }
	    var data = {
	    		user : $scope.user,
	    		pass : $scope.pass
	    }
		
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
}
);