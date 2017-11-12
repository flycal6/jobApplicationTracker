angular.module('appModule').component('navigation', {
	templateUrl: 'app/appModule/navigation/navigation.component.html',
	controller: function($location, authService){
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
	},
	controllerAs: 'vm'
});