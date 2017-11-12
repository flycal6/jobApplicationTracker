angular.module('authModule').component('logout', {
	templateUrl: 'app/authModule/logout/logout.component.html',
	controller: function(authService, $location, $rootScope){
		var vm = this;
		
		
		
		vm.logout = function(){
			authService.logout().then(function(res){
				$location.path('/login');
				$rootScope.$broadcast('Logged Out Message')
			})
		}
	},
	controllerAs: 'vm'
});