angular.module('appModule')
	.component('application', {
		templateUrl: 'app/appModule/application/application.component.html',
		controller: function(appService, $scope, $location, $rootScope, responseService){
			var vm = this;
			vm.loading = 1;
			vm.applicationSelected = null;
			vm.createApplication = null;
			vm.upateApplication = null;
			vm.applications = [];
			
/******************************* show all responses, hide apps ***************************************/
			$scope.$on('viewResponses', function(){
				vm.showResponses();
			});
			
			vm.showResponses = function(){
				vm.hideApps = true;
			};
			
/******************************* show apps, hide responses ***************************************/
			$scope.$on('viewApps', function(){
				vm.createApplication = null;
				vm.hideApps = false;
				vm.upateApplication = null;
				vm.applicationSelected = null;
			});
			
/******************************* refresh page ***************************************/
			var reload = function(){
				vm.loading = 1;
				vm.applicationSelected = null;
				appService.index().then(function(res){
					vm.applications = res.data;
					console.log(vm.applications)
					vm.loading = 0;
				})
				.catch(function(err) {
					$location.path('/login');
				});
			};
			
			reload();
			
/******************************* show create form ***************************************/
			vm.setCreateApplication = function(){
				vm.applicationSelected = null;
				vm.createApplication = true;
				vm.hideApps = false;
			};
			
/******************************* show response creation form ***************************************/
			vm.viewResponseCreationForm = function(aid){
				$rootScope.$broadcast('showCreateResponseForm', aid);
				vm.hideApps = true;
			};
			
/******************************* show interview creation form ***************************************/
			vm.viewInterviewCreationForm = function(aid){
				$rootScope.$broadcast('showCreateInterviewForm', aid);
				vm.hideApps = true;
			};
			
/******************************* create new application ***************************************/
			vm.newApp = {};
			vm.newAppSubmit = function(newApp){
				vm.loading = 1;
				appService.create(newApp).then(function(res){
					console.log(res)
					vm.createApplication = null;
					reload();
				})
			}
			
/******************************* show update form ***************************************/
			vm.setUpateApplication = function(app){
				vm.updateApp = app;
				vm.updateApp.date = new Date(app.date);
				vm.upateApplication = true;
			};
			
			vm.unsetUpdateApplication = function(){
				vm.upateApplication = false;				
			}
			
/******************************* perform app update ***************************************/
			vm.updateAppSubmit = function(app){
				vm.loading = 1;
				appService.update(app).then(function(res){
					vm.unsetUpdateApplication();
					vm.loading = 0;
				})
			};
			
/******************************* Delete Application ***************************************/
			vm.deleteSelected = function(app){
				vm.loading = 1;
				appService.destroy(app).then(function(res){
					vm.loading = 0;
					reload();
				});
			};
			
/******************************* show detail view ***************************************/
			vm.setSelected = function(app){
				vm.applicationSelected = app;
			};
		},
		controllerAs: 'vm'
	});