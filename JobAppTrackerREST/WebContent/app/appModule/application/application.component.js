angular.module('appModule')
	.component('application', {
		templateUrl: 'app/appModule/application/application.component.html',
		controller: function(appService, $scope){
			var vm = this;
			vm.loading = 1;
			vm.applicationSelected = null;
			vm.createApplication = null;
			vm.applications = [];
			
/******************************* refresh page ***************************************/
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
			
/******************************* show create form ***************************************/
			$scope.$on('create', function(){
				vm.setCreateApplication();
			});
			
			vm.setCreateApplication = function(){
				vm.createApplication = true;
			};
			
/******************************* show create form ***************************************/
			vm.newApp = {};
			vm.newAppSubmit = function(newApp){
				vm.loading = 1;
				console.log(newApp);
				appService.create(newApp).then(function(res){
					console.log(res)
					vm.createApplication = null;
					reload();
				})
			}
			
			
/******************************* show detail view ***************************************/
			vm.setSelected = function(app){
				console.log(app)
				vm.applicationSelected = app;
			};
		},
		controllerAs: 'vm'
	});