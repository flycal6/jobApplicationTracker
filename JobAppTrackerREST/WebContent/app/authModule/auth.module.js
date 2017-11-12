angular.module('authModule', ['ngRoute', 'ngCookies'])
.config(function($routeProvider){
	$routeProvider
		.when('/register', {
			template: '<register></register>'
		})
		.when('/login', {
			template: '<login></login>'
		})
})