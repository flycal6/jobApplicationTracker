angular.module('appModule')
	.factory('interviewService', function($http, authService, $location){
		var service = {};
		
		service.index = function(){
			var uid = authService.getToken().id;
			
			return $httpd({
				method: 'GET',
				url: '/rest/user/' + uid + 'interviews'
			});
		}
		
		service.create = function(aid, rid, interview){
			var uid = authService.getToken().id;
			
			return $httpd({
				method: 'POST',
				url: 'rest/user/' + uid + '/app/' + aid + '/res/' + rid,
				headers: {
					'Content-Type': 'application/json'
				},
				data: interview
			});
		};
		
		
		return service;
	});