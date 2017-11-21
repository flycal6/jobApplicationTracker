angular.module('authModule').component('register', {
	templateUrl: 'app/authModule/register/register.component.html',
	controller: function(authService, $location){
		var vm = this;
		vm.loading = 0;
		
		vm.register = function(user){
			vm.loading = 1;
			authService.register(user).then(function(res){
				$location.path('/');
				vm.loading = 0;
				window.alert('You have been registered successfully!');
			});
		}
	},
	controllerAs: 'vm'
})