angular.module('appModule')
	.component('application', {
		templateUrl: 'app/appModule/application/application.component.html',
		controller: function(appService){
			var vm = this;
			vm.applications = [];
			
			var reload = function(){
				appService.index().then(function(res){
					vm.applications = res.data;
					console.log(vm.applications)
				})
			};
			
			reload();
		},
		controllerAs: 'vm'
	});