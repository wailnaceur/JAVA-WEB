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
	var color = [];
	
	var chart = new Chart(ctx, {
		// The type of chart we want to create
		type: 'bar',
		// The data for our dataset
		data: {
			labels: keys,
			//datasets : dataset
			//labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
			datasets: [{
				label: 'Nombre de postion par SmartPhone',
                 backgroundColor: [
                	  'rgba(75, 192, 192, 0.2)',
				      'rgba(255, 99, 132, 0.2)',
				      'rgba(255, 159, 64, 0.2)',
				      'rgba(255, 205, 86, 0.2)',
				      'rgba(54, 162, 235, 0.2)',
				      'rgba(153, 102, 255, 0.2)',
				      'rgba(201, 203, 207, 0.2)'
				    ],
				     borderColor: [
				      'rgb(75, 192, 192)',
				      'rgb(255, 99, 132)',
				      'rgb(255, 159, 64)',
				      'rgb(255, 205, 86)',
				      'rgb(54, 162, 235)',
				      'rgb(153, 102, 255)',
				      'rgb(201, 203, 207)'
				    ],
				 borderWidth: 1,
                 borderAlign: 'center',
				//data: [0, 17, 4, 7, 10, 54, 12]
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





