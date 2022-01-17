var label;
var dataset;

$(document).ready(function() {
	$.ajax({
		url: "PositionServlet",
		data: { action: "charge" },
		method: "POST",
		success: function(data) {
			console.log("hello");
			console.log(data);
			// var map2 = new Map(JSON.parse(JSON.stringify(data)));
			//console.log(map2);
			label = data.map(val => val["key"]);
			dataset = data.map(val => val["value"]);
			updateChart(label, dataset);
		},
		error: function(data) {
			console.log("error a kamal ", data);
			console.log(error);
		}
	});
});
function updateChart(keys, values) {
	var ctx = document.getElementById('myChart').getContext('2d');
	var chart = new Chart(ctx, {
		// The type of chart we want to create
		type: 'bar',
		// The data for our dataset
		data: {
			labels: keys,
			//datasets : dataset
			//labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
			datasets: [{
				label: 'nombre de postion par SmartPhone',
				backgroundColor: 'rgb(233, 99, 132)',
				borderColor: 'rgb(70, 99, 132)',
				//data: [0, 10, 5, 2, 20, 30, 45]
				data: values
			}]
		},
		// Configuration options go here
		options: {
			options: {
				scales: {
					y: {
						beginAtZero: true
					}
				}
			},
		}
	});
}



