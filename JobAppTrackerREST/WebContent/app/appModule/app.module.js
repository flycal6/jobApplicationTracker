angular.module('appModule', [ 'ngRoute', 'authModule' ]).config(
		function($routeProvider) {
			$routeProvider
			.when('/', {
				template : '<application></application>'
			})
			.when('/interviews', {
				template: '<interview></interview>'
			})
			.when('/responses', {
				template : '<response></response>'
			})
			.otherwise({
				template : '<not-found></not-found>'
			})
		})
