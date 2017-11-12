angular.module('authModule').component('login', {
	templateUrl: 'app/authModule/login/login.component.html',
	controller: function(authService, $location){
		var vm = this;
		vm.loading = 0;
		vm.unauthorized = null;
		
		vm.login = function(user){
		   	vm.loading = 1;
			authService.login(user).then(function(res){
				$location.path('/');
				vm.loading = 0;
			})
			.catch(function(err){
				vm.loading = 0;
				vm.unauthorized = 1;
			});
		}
	},
	controllerAs: 'vm'
})