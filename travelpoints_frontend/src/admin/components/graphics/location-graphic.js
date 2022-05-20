import React from 'react';
import CanvasJSReact from '../../../canvasjs.react';
//var CanvasJSReact = require('./canvasjs.react');
var CanvasJS = CanvasJSReact.CanvasJS;
var CanvasJSChart = CanvasJSReact.CanvasJSChart;

class LocationGraphic extends React.Component {
  render() {
  		const options = {
  			animationEnabled: true,
  			title:{
  				text: "The most visited target locations"
  			},
  			axisX: {
  				title: "Objective Location",
  				reversed: true,
  			},
  			axisY: {
  				title: "The number of visits",
  			},
  			data: [{
  				type: "bar",
  				dataPoints: [
  				    { y:  4, label: "Instanbul" },
  				    { y:  4, label: "Napoli" },
  					{ y:  4, label: "Paris" },
  					{ y:  2, label: "Venetia" },
  					{ y:  1, label: "Roma" },
  					{ y:  1, label: "Londra" },


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
export default LocationGraphic;
