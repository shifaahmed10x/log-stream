import ReactECharts from "echarts-for-react";

function LogLevelChart() {
  const option = {
    backgroundColor: "transparent",
    tooltip: {
      trigger: "item",
    },
    legend: {
      bottom: 0,
      textStyle: {
        color: "#fff",
      },
    },
    series: [
      {
        type: "pie",
        radius: "60%",
        data: [
          { value: 320, name: "Error" },
          { value: 1120, name: "Warning" },
          { value: 11010, name: "Info" },
        ],
      },
    ],
  };

  return <ReactECharts option={option} style={{ height: "350px" }} />;
}

export default LogLevelChart;