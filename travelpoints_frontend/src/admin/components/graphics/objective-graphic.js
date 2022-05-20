import React from 'react';
import CanvasJSReact from '../../../canvasjs.react';
//var CanvasJSReact = require('./canvasjs.react');
var CanvasJS = CanvasJSReact.CanvasJS;
var CanvasJSChart = CanvasJSReact.CanvasJSChart;

class ObjectiveGraphic extends React.Component {
  render() {
    const options = {
      title: {
        text: "The most visited objectives"
      },
      axisX: {
        	title: "Objective name",
        	reversed: true,
        	},
       axisY: {
        	title: "Number of visits",
        	},
      data: [{
                type: "column",
                dataPoints: [
                    { label: "Ruinele din Pompei",  y: 4  },
                    { label: "Muzeul Luvru", y: 1  },
                    { label: "Turnul Eiffel", y: 2  },
                    { label: "Colosseum",  y: 1  },
                    { label: "Disneyland Park",  y: 1  },
                    { label: "Big Ben",  y: 1  },
                    { label: "Basilica San Marco",  y: 2  },
                    { label: "Grand Bazaar",  y: 4  }
                ]
       }]
   }

   return (
      <div>
        <CanvasJSChart options = {options}
        />
      </div>
    );
  }
}
export default ObjectiveGraphic;
