angular.module('authModule').component('register', {
	templateUrl: 'app/authModule/register/register.component.html',
	controller: function(authService, $location){
		var vm = this;
		
		vm.register = function(user){
			authService.register(user).then(function(res){
				$location.path('/');
				window.alert('You have been registered successfully!');
			});
		}
	},
	controllerAs: 'vm'
})