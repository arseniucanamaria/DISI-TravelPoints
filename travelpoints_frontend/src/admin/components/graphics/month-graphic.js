import React from 'react';
import CanvasJSReact from '../../../canvasjs.react';
//var CanvasJSReact = require('./canvasjs.react');
var CanvasJS = CanvasJSReact.CanvasJS;
var CanvasJSChart = CanvasJSReact.CanvasJSChart;

class MonthGraphic extends React.Component {
  render() {
  		const options = {
  			animationEnabled: true,
  			title:{
  				text: "The visits per month"
  			},
  			axisX: {
  				title: "Month of the year",
  				reversed: true,
  			},
  			axisY: {
  				title: "The number of visits",
  			},
  			data: [{
  				type: "bar",
  				dataPoints: [
  				    { y:  10, label: "Ianuarie" },
					{ y:  5, label: "Februarie" },
					{ y:  7, label: "Martie" },
					{ y:  20, label: "Aprilie" },
					{ y:  3, label: "Mai" },
					{ y:  2, label: "Iunie" },
					{ y:  1, label: "Iulie" },
					{ y:  0, label: "August" },
					{ y:  10, label: "Septembrie" },
					{ y:  19, label: "Octombrie" },
					{ y:  25, label: "Noiembrie" },
					{ y:  100, label: "Decembrie" },
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
export default MonthGraphic;
