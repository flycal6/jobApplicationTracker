angular.module('appModule')
	.factory('interviewService', function($http, authService, $location){
		var service = {};
		service.selectedRes = null;
		service.selectedApp = null;
		service.viewIntForm = false;
		
		service.index = function(){
			var uid = authService.getToken().id;
			console.log('inside interviewService.index()')
			return $http({
				method: 'GET',
				url: 'rest/user/' + uid + '/interviews'
			});
		}
		
		service.create = function(aid, rid, interview){
			var uid = authService.getToken().id;
			
			return $http({
				method: 'POST',
				url: 'rest/user/' + uid + '/app/' + aid + '/res/' + rid,
				headers: {
					'Content-Type': 'application/json'
				},
				data: interview
			});
		};
		
		service.storeResAndApp = function(res, app){
			service.selectedRes = res;
			service.selectedApp = app;
			service.viewIntForm = true;
			$location.path('/interviews');
		};
		
		return service;
	});