angular.module('appModule')
	.component('application', {
		templateUrl: 'app/appModule/application/application.component.html',
		controller: function(appService, $scope){
			var vm = this;
			vm.loading = 1;
			vm.applicationSelected = null;
			vm.createApplication = null;
			vm.applications = [];
			
			var reload = function(){
				vm.loading = 1;
				vm.applicationSelected = null;
				appService.index().then(function(res){
					vm.applications = res.data;
					console.log(vm.applications)
					vm.loading = 0;
				})
			};
			
			reload();
			
			$scope.$on('create', function(){
				vm.setCreateApplication();
			});
			
			vm.setCreateApplication = function(){
				vm.createApplication = true;
			};
			
			vm.setSelected = function(app){
				console.log(app)
				vm.applicationSelected = app;
			};
		},
		controllerAs: 'vm'
	});