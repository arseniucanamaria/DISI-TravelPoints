import React from 'react';
import CanvasJSReact from '../../../canvasjs.react';
//var CanvasJSReact = require('./canvasjs.react');
var CanvasJS = CanvasJSReact.CanvasJS;
var CanvasJSChart = CanvasJSReact.CanvasJSChart;

class HourGraphic extends React.Component {
  render() {
  		const options = {
  			animationEnabled: true,
  			title:{
  				text: "The visits per hour"
  			},
  			axisX: {
  				title: "Hour",
  				reversed: true,
  			},
  			axisY: {
  				title: "Visits",
  			},
  			data: [{
  				type: "bar",
  				dataPoints: [
  				    { y:  1, label: "08:00" },
					{ y:  2, label: "09:00" },
					{ y:  0, label: "10:00" },
					{ y:  3, label: "11:00" },
					{ y:  0, label: "12:00" },
					{ y:  5, label: "13:00" },
					{ y:  6, label: "14:00" },
					{ y:  2, label: "15:00" },
					{ y:  1, label: "16:00" },
					{ y:  9, label: "17:00" },
					{ y:  1, label: "18:00" },
					{ y:  1, label: "19:00" },
					{ y:  2, label: "20:00" },
					{ y:  3, label: "21:00" },
					{ y:  4, label: "22:00" },
  				]
  			}]
  		}
  		return (
  		<div>
  			<CanvasJSChart options = {options}
  			/>
  			{/*You can get reference to the chart instance as shown above using onRef. This allows you to access all chart properties and methods*/}
  		</div>
  		);
  	}

  }
export default HourGraphic;
