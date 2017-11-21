angular.module('appModule').component('navigation', {
	templateUrl: 'app/appModule/navigation/navigation.component.html',
	controller: function($location, authService, $rootScope){
		var vm = this;
		
/************ Used to show or hide nav buttons depending if user is logged in *****************/
		vm.checkLogIn = function(){
			if(authService.getToken().id == null){
				return false;
			}
			else {
				return true;
			}
		};
		
/************ send user to auth components ****************************************************/
		vm.register = function(){
			$location.path('/register');
		};
		
		vm.login = function(){
			$location.path('/login');
		};
		
/************ view applications page ****************************************************/
		vm.viewApps = function(){
			$location.path('/');
			$rootScope.$broadcast('viewApps');
		};
		
/************ broadcast to view all responses ****************************************************/
		vm.viewAllResponses = function(){
//			$rootScope.$broadcast('viewResponses');
			$location.path('/responses');
		};

/************ add New App button check ****************************************************/
		vm.rootPath = function(){
			var path = $location.path();
			if(path == '/'){
				return true;
			}
			else{
				return false;
			}
		};
		
	},
	controllerAs: 'vm'
});