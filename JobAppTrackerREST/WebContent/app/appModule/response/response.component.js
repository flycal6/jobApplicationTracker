angular.module('appModule')
	.component('response', {
		templateUrl: 'app/appModule/response/response.component.html',
		controller: function(responseService, $scope, $location){
			var vm = this;
			vm.responses = [];
			
			responseService.index().then(function(res){
				vm.responses = res.data;
				console.log(vm.responses)
			});
			
/**************************** view all responses *****************************/
//			$scope.$on('viewResponses', function(){
////				console.log('click recieved')
////				$location.path('/responses');
//				vm.setResponsePath();
//			});
//			
//			vm.setResponsePath = function(){
//				$location.path('/responses');
//			}

/**************************** add a response to an application *****************************/
			$scope.$on('createResponseForm', function(e, args){
				console.log('broadcast received')
				console.log(args)
			})
			
			
		},
		controllerAs: 'vm'
	});